/* =============================================
 *  Copyright (c) 2014-2015 by CITIC All rights reserved.
 *  Created [2016-02-29] 
 * =============================================
 */

package citic.dxzp.risk.service;

/**
 * <p>Cgb_risk_caseService.java</p>
 * <p>Description: </p>
 * @author $Author:  $
 */


import java.util.List;

import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.base.utils.DtUtils;
import citic.dxzp.risk.domain.Cgb_risk_case;
import citic.dxzp.risk.domain.Cgb_risk_category;

@Service
public class Cgb_risk_caseService extends AmlBaseService {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1712437977056916787L;
	/** map命名空间 */
	private String namespace = "citic.dxzp.risk.mapper.busi.Cgb_risk_caseMapper.";

    
	public List<Cgb_risk_case> getCgb_risk_caseList(Cgb_risk_case cgb_risk_case){
		       // 定义转换码表
				String[] cdColumns = new String[] { "organkey:Dorgan:organkey_disp","suborgankey:Dorgan:suborgankey_disp","infosource:G00001:infosource_disp","isreport:S00001:isreport_disp","status_cd:G00003:status_cd_disp"};
				List<Cgb_risk_case> list = busiDao.selectList(namespace + "selectCgb_risk_caseByVo", cgb_risk_case);
				// 或在DAO查询中直接转换
				list = codeService.transListOfBean(list, cdColumns);
				//事件简述处理
                if(list!=null&&list.size()>0){
                	String caseDesc_disp = "";
                	for(int i=0;i<list.size();i++){
                		String casedesc = list.get(i).getCasedesc();
                		caseDesc_disp=casedesc.length()>10?casedesc.substring(0,10)+"......":casedesc;
                		list.get(i).setCasedesc_disp(caseDesc_disp);
                	}
                }
				return list;
	}
	
	public List<Cgb_risk_category> getRisk_subCategory(String keys){
	List<Cgb_risk_category> list = busiDao.selectList(namespace + "selectGetRisk_subCategory", keys);
	return  list;
	}
	
	
	
	
	
	
	/**
	 * 提交审核、审核通过和审批通过
	 * @param cgb_risk_case
	 * 
	 * @author yinxiong
	 * @date 2016年7月8日 下午1:54:06
	 */
	public void modifyCgb_risk_caseStatus_cdByPl_choose(Cgb_risk_case cgb_risk_case){
		busiDao.update(namespace + "updateCgb_risk_caseStatus_cdByPl_choose", cgb_risk_case);
	}
	
	/**
	 * 退回
	 * @param cgb_risk_case
	 */
	public void modifyCgb_risk_caseStatus_cdByBack(Cgb_risk_case cgb_risk_case){
		busiDao.update(namespace + "updateCgb_risk_caseStatus_cdByBack", cgb_risk_case);
	}
	
	/**
	 * 添加
	 * @param cgb_risk_case
	 * @throws Exception 
	 */
	public void InsertCgb_risk_case(Cgb_risk_case cgb_risk_case) throws Exception{
		String caseId = "R00" + this.getSequenceValus("seq_cgb_risk_case");
		cgb_risk_case.setCaseid(caseId);//编号
		cgb_risk_case.setCreate_dt(DtUtils.getNowTime());//创建时间
		cgb_risk_case.setStatus_cd("0");// 状态 0：录入1：待审核2：待审批3：审批通过4：退回
		busiDao.insert(namespace + "insertCgb_risk_case", cgb_risk_case);
	}
	
	/**
	 * 修改
	 * @param cgb_risk_case
	 */
	public void modifyCgb_risk_case(Cgb_risk_case cgb_risk_case){
		busiDao.update(namespace + "updateCgb_risk_case", cgb_risk_case);
	}
	
	/**
	 * 删除
	 * @param caseId
	 */
	public void deleteCgb_risk_caseById(String  caseId){
		busiDao.update(namespace + "deleteCgb_risk_caseByID", caseId);
	}
	/**
	 * 根据主键获取信息
	 * @param cgb_risk_case
	 * @return
	 */
	public Cgb_risk_case getCgb_risk_case(Cgb_risk_case cgb_risk_case){
		String[] cdColumns = new String[] { "organkey:Dorgan:organkey_disp","suborgankey:Dorgan:suborgankey_disp"};
		Cgb_risk_case risk_case = busiDao.selectOne(namespace+"selectCgb_risk_caseByID",cgb_risk_case,cdColumns);
		if(risk_case==null){
			risk_case = new Cgb_risk_case();
		}
		return risk_case;
	}
}
