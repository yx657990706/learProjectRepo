package citic.cgb.tools;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import citic.core.service.CodeService;

import com.google.common.collect.Lists;
import com.sunyard.TransEngine.client.ClientApi;
import com.sunyard.TransEngine.doc.ECMDoc;
import com.sunyard.TransEngine.util.OptionKey;

/**
 * 影像查询
 * <br>1.先根据条件调用getImgUrlListByBatchId或者getImgUrlByBusiSerialNo方法，获取地址列表
 * <br>2.根据地址，调用insertImgToFile生成图像文件
 * @author yinxiong
 * @date 2017年6月18日 下午2:06:40
 */
public class ImageQuary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1223586260071303332L;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CodeService codeService;
	
	/** 影像开始标签 */
	private final String IMG_START_TAG = "URL=\"";
	/** 影像结束标签 */
	private final String IMG_END_TAG = "\"";
	/** batch_id开始标签 */
	private final String BATCH_ID_START_TAG = "BATCH_ID=\"";
	/** batch_id结束标签 */
	private final String BATCH_ID_END_TAG = "\"";
	
	@Setter
	@Getter
	private String ip;//影像系统ip
	@Setter
	@Getter
	private String port;//端口
	//影像系统取消了密码校验，口令无实际意义
	@Setter
	@Getter
	private String username = "admin";//用户名
	@Setter
	@Getter
	private String password = "111";//口令
	
	
	/**
	 * 根据流水号获取影像有关的URL地址
	 * 
	 * @param imgId 影像id
	 * @return
	 * @throws Exception
	 */
	public List<String> getImgUrlByBusiSerialNo(String busiSerialNo) throws Exception {
		List<String> imgUrlsList = Lists.newArrayList();
		String[] imgBatchs = null;
		String imgxml = "";
		ClientApi api = new ClientApi(ip, port, username, password);
		ECMDoc doc = new ECMDoc();
		doc.setBusiAttribute("BUSI_SERIAL_NO", busiSerialNo); // 指定要查询的影像流水号
		doc.setObjName("SDSS");// 指定查询批次所属的业务模型名
		doc.setOption(OptionKey.QUERY_BATCH_FILE);// 指定查询类型为查询批次文件
		// 查询批次信息
		imgxml = api.queryBatch(doc);
		imgBatchs = StringUtils.substringsBetween(imgxml, BATCH_ID_START_TAG, BATCH_ID_END_TAG);
		if (imgBatchs != null && imgBatchs.length > 0) {
			for (String batchid : imgBatchs) {
				// 查询批次下的影像文件
				doc.setBatchID(batchid);// 指定要查询的批次号
				String imgUrlXml = api.queryFile(doc);
				
				String[] imgUrls = StringUtils.substringsBetween(imgUrlXml, IMG_START_TAG, IMG_END_TAG);// 截取图片的影像url用数组返回
				if (imgUrls != null && imgUrls.length > 0) {
					for (int i = 0; i < imgUrls.length; i++) {
						if (!StringUtils.contains(imgUrls[i], ".xml")) {//过滤掉xml
							imgUrls[i] = imgUrls[i].replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
							imgUrlsList.add(imgUrls[i]);
						}
					}
				} else {
					logger.info("影像url不存在");
				}
			}
		} else {
			logger.info("根据影像流水查询批次号失败");
		}
		
		return imgUrlsList;
	}
	
	/**
	 * 根据url下载影像
	 * 
	 * @param imgId
	 * @return map 地址[filepath]和名称[filename]
	 * @throws Exception
	 */
	public boolean insertImgToFile(String imgUrl, String relativePath, String fileName) throws Exception {
		boolean flag = false;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		try {
			URL url = new URL(imgUrl);
			//打开网络输入流
			dis = new DataInputStream(url.openStream());
			// 从缓存中获取根路径
			String root = "/afpdata";//codeService.getCodeValue("Dpara", "1");
			String path = root + File.separatorChar + relativePath;
			File newFile = new File(path);
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			//建立一个新的文件
			File newfile = new File(path + File.separator + fileName);
			fos = new FileOutputStream(newfile);
			byte[] buffer = new byte[1024];
			int length;
			//开始填充数据
			while ((length = dis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.flush();
			flag = true;
		} catch (Exception e) {
			logger.error("影像下载失败");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
			if (dis != null) {
				try {
					dis.close();
				} catch (Exception e) {
				}
			}
		}
		return flag;
	}
	
}
