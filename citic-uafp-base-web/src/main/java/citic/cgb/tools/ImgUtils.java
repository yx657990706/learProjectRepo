package citic.cgb.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

public class ImgUtils {
	
	/**
	 * 可直接应用的base64字符串
	 * @param imgPath
	 * @return
	 * @throws IOException
	 * 
	 * @author yinxiong
	 * @date 2017年4月18日 下午5:19:19
	 */
	public static String getSrcImgBase64Str(String imgPath) throws IOException{
		InputStream in = null;
		byte[] data = null;
		String format = "png";//默认图像格式
		try {
			int index = imgPath.lastIndexOf(".");
			if(index!=-1){
				format = imgPath.substring(index+1);
			}
			in = new FileInputStream(imgPath);
			data = new byte[in.available()];
			in.read(data);
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		String base64Str = Base64.encodeBase64String(data);
		//获取可直接应用于<img src=""/>标签的图片资源
		// data:image/jpg;base64,base64编码 = jpg图片【jpg,gif,png,jpeg适用该格式】
		String imgSrcStr = "data:image/"+format+";base64,"+base64Str;
		return imgSrcStr;
	}
	/**
	 * 将base64包装为可直接显示的字符串
	 * @param imgBase64
	 * @return
	 * @throws IOException
	 * 
	 * @author yinxiong
	 * @date 2017年4月26日 下午7:55:24
	 */
	public static String getSrcImgBase64StrByData(String imgBase64) throws IOException{
		String format = "png";//默认图像格式
		//获取可直接应用于<img src=""/>标签的图片资源
		// data:image/jpg;base64,base64编码 = jpg图片【jpg,gif,png,jpeg适用该格式】
		String imgSrcStr = "data:image/"+format+";base64,"+imgBase64;
		return imgSrcStr;
	}
	/**
	 * 图片转换为BASE64字符串
	 * @param imgPath 图片绝对路径
	 * @return
	 * @throws IOException
	 * 
	 * @author yinxiong
	 * @date 2017年4月18日 下午4:15:42
	 */
	public static String getImgBase64Str(String imgPath) throws IOException{
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgPath);
			data = new byte[in.available()];
			in.read(data);
		} finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		
		return Base64.encodeBase64String(data);
	}
	
	/**
	 * 图片base64字符串转换为图像
	 * @param imgBase64Str
	 * @param path
	 * @return
	 * @throws IOException
	 * 
	 * @author yinxiong
	 * @date 2017年4月18日 下午4:25:57
	 */
	public static boolean generateImgByBase64Str(String imgBase64Str,String path) throws IOException{
		OutputStream out = null;
		if(imgBase64Str == null){
			return false;
		}
		try{
			//解密
			byte[] data = Base64.decodeBase64(imgBase64Str);
			//处理数据
			for(int i=0;i<data.length;i++){
				if(data[i]<0){
					data[i] += 256;
				}
			}
			out =new FileOutputStream(path);
			out.write(data);
			out.flush();
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
		
		return true;
	}
	
}
