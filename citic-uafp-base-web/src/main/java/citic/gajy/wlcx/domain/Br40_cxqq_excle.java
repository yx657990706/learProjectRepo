package citic.gajy.wlcx.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data                                                  
@EqualsAndHashCode(callSuper = false)
public class Br40_cxqq_excle extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2104573013748383518L;

	/**监管类型*/
	private String tasktype = "";
	
	/**请求单标识*/
	private String qqdbs = "";
	
	/**任务流水号*/
	private String rwlsh = "";
	
	/**请求措施类型 此处需要区分01：常规查询 02:动态查询 03:继续动态查询 就行*/
	private String qqcslx = "";
	
	/**执行启始时间*/
	private String zxqssj = "";
	
	/**执行结束时间*/
	private String jssj = "";
	
	/**导入excel*/
	private MultipartFile file;
	
	/**创建人*/
	private String create_user = "";
	
	/**创建时间*/
	private String create_time = "";
	
	/**路径*/
	private String filepath = "";
	
	/**附件名称*/
	private String filename = "";
}
