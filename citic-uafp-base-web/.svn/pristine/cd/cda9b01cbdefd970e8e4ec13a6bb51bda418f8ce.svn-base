package citic.cgb.quartz;


/**
 * 定时任务接口
 * <br>所有的定时任务在此定义，通过接口的实现类实现
 * 
 * @author yinxiong
 * @date 2016年11月7日 上午9:27:58
 */
public interface JobInterface {

	
	/**
	 * 解析上传的名单文件
	 * 
	 * <br>1.查询待处理的zip文件，逐个解析
	 *<br> 2.对于每个zip，解析出来的CSV按单个同名文件处理
	 * <br>3.对于每个CSV，数据用list接收，X条记录一次提交，写入临时表中
	 * <br>3.1数据分为对公对私2种，设计为2个表，因此2个临时表，2个数据表
	 * <br>4.所有excle处理完成后，将临时表数据处理到数据表中，采用merge方式。
	 * <br>5.更新名单文件的处理状态和时间，以及说明【成功写入名单文件处理完成，失败写原因】
	 * <br>6.清空临时表
	 */
	public void unZipFile(); 
	
}
