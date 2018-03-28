package citic.cgb.quartz.quartzImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import citic.cgb.quartz.JobInterface;
import citic.dxzp.ct.service.Ct_yjmdService;

@Component
public class JobInterfaceImpl implements JobInterface{

	@Autowired
	private Ct_yjmdService ct_yjmdService;
	
	
	@Scheduled(cron="0 15 2 * * ?")//每天凌晨2点15分执行一次
	@Override
	public void unZipFile() {
		ct_yjmdService.unZipFile();
	}
}
