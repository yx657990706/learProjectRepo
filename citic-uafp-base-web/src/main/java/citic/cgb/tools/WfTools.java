package citic.cgb.tools;

import java.io.File;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ml.bdbm.client.FTSRequest;
import com.ml.bdbm.client.FTSResponse;
import com.ml.bdbm.client.FTSTaskClient;
import com.ml.bdbm.client.TransferFile;

public class WfTools {
	
	private  final Logger logger = LoggerFactory.getLogger(WfTools.class);
	
	@Setter@Getter
	private  String  ip = "";//源系统ipInteger.parseInt()
	@Setter@Getter
	private  int  port = 32792;//目标端口号
	@Setter@Getter
	private  int  timeout = 30;//超时 单位为秒 实际可改为5-10分钟  web界面传输要求数据，暂定30秒
	
	/**
	 * 通过文服发送文件
	 * <br>外围到核心的形式
	 * @param srcPath 源文件路径
	 * @param srcName 源文件名称
	 * @param destPath 目标文件路径
	 * @param destName 目标文件名称
	 * @param taskId   文服分配的taskid
	 * @param sysId    系统目录标识
	 * @param fileIOName 文件IO
	 * @param encoding  编码方式,若无则默认GB18030
	 * @return
	 * 
	 * @author yinxiong
	 * @date 2017年5月20日 下午5:19:19
	 */
	public  boolean sendFile(String srcPath,String srcName,String destPath,String destName,String taskId,String sysId,String fileIOName,String encoding){
		boolean isSucc = false;
		try {

			//生成.end确认文件
			String endName = srcName + ".end";
			String oneline = "AGENTDIR=/cdadmin/UFSM/agent/"+sysId+"/save\n";//代理路径
			String twoline = "SYSTEMCOUNTS=001\n";//序列号 默认给001
			String threeline = "ROUT001="+taskId+";/cdadmin/UFSM/agent/"+sysId+"/save/;"+fileIOName+";";//tasked+目标路径＋io文件名
			encoding = StringUtils.isBlank(encoding)?"GB18030":encoding;//获取编码方式
			FileUtils.writeStringToFile(new File(srcPath + File.separator + endName), oneline + twoline + threeline, encoding);
			//创建数据文件请求
			TransferFile dataFile = new TransferFile(srcName, srcPath, destName, destPath);
			TransferFile[] dataFileList = new TransferFile[] {dataFile};//修改此处的file个数，可发送多个文件
			FTSRequest dataRequest = new FTSRequest(taskId, dataFileList);
			//创建end文件请求
			TransferFile endFile = new TransferFile(endName, srcPath, endName, destPath);
			TransferFile[] endFileList = new TransferFile[] {endFile};
			FTSRequest endRequest = new FTSRequest(taskId, endFileList);
			//建立文服连接
			FTSTaskClient client = new FTSTaskClient(ip, port);
			//发送数据文件
			FTSResponse dataRes = client.callTask(dataRequest, timeout);
			if (StringUtils.equals("0000", dataRes.getErrorCode())) {//发送成功
				FTSResponse endRes = client.callTask(endRequest, timeout);
				if(StringUtils.equals("0000", endRes.getErrorCode())){
					isSucc = true;
				}else{
					logger.error("确认文件["+endName+"]发送文服失败，代码："+endRes.getErrorCode()+" 消息："+endRes.getErrorMessage());
				}
			}else{
				logger.error("数据文件["+srcName+"]发送文服失败，代码："+dataRes.getErrorCode()+" 消息："+dataRes.getErrorMessage());
			}	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return isSucc;
	}
	
}
