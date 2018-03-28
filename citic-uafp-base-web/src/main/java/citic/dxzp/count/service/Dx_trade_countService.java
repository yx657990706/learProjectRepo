/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2016-02-29]
 * =============================================
 */

package citic.dxzp.count.service;

/**
 * <p>
 * Cgb_risk_caseService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.dxzp.count.domain.Dx_trade_count;

@Service
public class Dx_trade_countService extends AmlBaseService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7222042381316260742L;
	/** map命名空间 */
	private String namespace = "citic.dxzp.count.mapper.busi.Dx_trade_countMapper.";
	
	// 查询类统计
	public List<Dx_trade_count> getDx_trade_countList(Dx_trade_count dx_trade_count) {
		// 定义转换码表
		String[] cdColumns = {"city:Dcityno:city_disp", "money:formatamt"};
		List<Dx_trade_count> list = busiDao.selectList(namespace + "selectDx_trade_totalByVo", dx_trade_count);
		list = codeService.transListOfBean(list, cdColumns);
		//或在DAO查询中直接转换  
		if (list != null && list.size() > 0) {
			for (int i = 1; i < list.size(); i++) {
				if (StringUtils.equals(list.get(i).getBusiness_kind(), "小计") && !StringUtils.equals(list.get(i).getCity_disp(), "总计")) {
					list.get(i).setBusiness_kind("");
					list.get(i).setCity_disp("小计");
				} else if (StringUtils.equals(list.get(i).getBusiness_kind(), "小计") && StringUtils.equals(list.get(i).getCity_disp(), "总计")) {
					list.get(i).setBusiness_kind("");
				}
			}
		}
		return list;
	}
	
	/**
	 * 导出excel
	 * 
	 * @param dx_trade_count
	 * @return
	 */
	public List<Dx_trade_count> getDx_trade_countListExport(Dx_trade_count dx_trade_count) {
		// 定义转换码表
		String[] cdColumns = {"city:Dcityno:city_disp", "money:formatamt"};
		List<Dx_trade_count> list = busiDao.selectList(namespace + "selectDx_trade_totalByVo", dx_trade_count);
		// 或在DAO查询中直接转换
		list = codeService.transListOfBean(list, cdColumns);
		if (list != null && list.size() > 0) {
			for (int i = 1; i < list.size(); i++) {
				if (StringUtils.equals(list.get(i).getBusiness_kind(), "小计") && !StringUtils.equals(list.get(i).getCity_disp(), "总计")) {
					list.get(i).setBusiness_kind("");
					list.get(i).setCity_disp("小计");
				} else if (StringUtils.equals(list.get(i).getBusiness_kind(), "小计") && StringUtils.equals(list.get(i).getCity_disp(), "总计")) {
					list.get(i).setBusiness_kind("");
				}
			}
		}
		return list;
	}
}
