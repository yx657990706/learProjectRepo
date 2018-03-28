package citic.aml.system.service;

/**
 * <p>
 * UserService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */
import java.util.List;

import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.aml.system.domain.Citrth_statistics;

@Service
public class Citrth_statisticsService extends AmlBaseService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6336401450279529628L;
	/** map命名空间 */
	private String namespace = "citic.aml.system.mapper.busi.CitrthStatisticsMapper.";
	
	// 查询类统计
	public List<Citrth_statistics> getCitrth_statisticsList(Citrth_statistics citrth_statistics) {
		// 定义转换码表
		String[] cdColumns = {"city:Dcityno:city_disp", "money:formatamt"};
		List<Citrth_statistics> list = busiDao.selectList(namespace + "selectCitrth_statisticsByVo", citrth_statistics);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
}
