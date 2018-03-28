package citic.whpsb.wlcx.service;

/**
 * <p>
 * Br51_cxqq_backService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import citic.base.BaseService;
import citic.whpsb.wlcx.domain.Br51_cxqq_back;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_acct;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_card;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_msg;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_party;
import citic.whpsb.wlcx.domain.Br51_cxqq_back_trans;

@Service
public class Br51_cxqq_backService extends BaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3059991342581591120L;

	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.whpsb.mapper.busi.Br51_cxqq_backMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br51_cxqq_back * @return
	 */
	public List<Br51_cxqq_back> getBr51_cxqq_backList(Br51_cxqq_back br51_cxqq_back) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {	"party_class_cd:G00023:party_class_cd_disp","cljg:G00025:cljg_disp",
		"status:G00029:status_disp","qrymode:G00024:qrymode_disp","orgkey:Dorgan:orgkey_disp"};
		
		// 处理日期 数据库中19位，页面传的是10位
		if (!"".equals(br51_cxqq_back.getDealing_time_start())) {// 处理时间起
			br51_cxqq_back.setDealing_time_start(br51_cxqq_back.getDealing_time_start() + " 00:00:00");
		}
		if (!"".equals(br51_cxqq_back.getDealing_time_end())) {// 处理时间止
			br51_cxqq_back.setDealing_time_end(br51_cxqq_back.getDealing_time_end() + " 23:59:59");
		}
		
		List<Br51_cxqq_back> list = busiDao.selectList(namespace + "selectBr51_cxqq_backByVo", br51_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询反馈文件信息
	 * 
	 * @param br51_cxqq_back * @return
	 */
	public List<Br51_cxqq_back_msg> getBr51_cxqq_back_msgList(Br51_cxqq_back_msg br51_cxqq_back_msg) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {	"status:G00027:status_disp"};
		
		// 处理日期 数据库中19位，页面传的是10位
		if (!"".equals(br51_cxqq_back_msg.getCreate_dt_start())) {// 处理时间起
			br51_cxqq_back_msg.setCreate_dt_start(br51_cxqq_back_msg.getCreate_dt_start() + " 00:00:00");
		}
		if (!"".equals(br51_cxqq_back_msg.getCreate_dt_end())) {// 处理时间止
			br51_cxqq_back_msg.setCreate_dt_end(br51_cxqq_back_msg.getCreate_dt_end() + " 23:59:59");
		}
		
		List<Br51_cxqq_back_msg> list = busiDao.selectList(namespace + "selectBr51_cxqq_back_msgByVo", br51_cxqq_back_msg);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	/**
	 * 开户资料查询
	 * 
	 * @param ah * @return
	 */
	public Br51_cxqq_back_party getBr51_cxqq_back_partyDisp(String bdhm) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		
		Br51_cxqq_back_party br51_cxqq_back_party = busiDao.selectOne(namespace + "selectBr51_cxqq_back_partyByID", bdhm, cdColumns);
		if (br51_cxqq_back_party == null)
			br51_cxqq_back_party = new Br51_cxqq_back_party();
		return br51_cxqq_back_party;
	}
	
	/**
	 * 账卡号持有人资料查询
	 * 
	 * @param ah * @return
	 */
	public Br51_cxqq_back_card getBr51_cxqq_back_cardDisp(String bdhm) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp","zzlx:DwhZjlx:zzlx_disp"};
		
		Br51_cxqq_back_card br51_cxqq_back_card = busiDao.selectOne(namespace + "selectBr51_cxqq_back_cardByID", bdhm, cdColumns);
		if (br51_cxqq_back_card == null)
			br51_cxqq_back_card = new Br51_cxqq_back_card();
		return br51_cxqq_back_card;
	}
	
	/**
	 * 账户信息查询
	 * 
	 * @param ah * @return
	 */
	public Br51_cxqq_back_acct getBr51_cxqq_back_acctDisp(String bdhm) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp", "hbzl:Dwhbz:hbzl_disp", "zhzt:G00026:zhzt_disp"};
		
		Br51_cxqq_back_acct br51_cxqq_back_acct = busiDao.selectOne(namespace + "selectBr51_cxqq_back_acctByID", bdhm, cdColumns);
		if (br51_cxqq_back_acct == null)
			br51_cxqq_back_acct = new Br51_cxqq_back_acct();
		return br51_cxqq_back_acct;
	}
	
	/**
	 * 交易明细查询
	 * 
	 * @param ah * @return
	 */
	public Br51_cxqq_back_trans getBr51_cxqq_back_transDisp(String bdhm) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		
		Br51_cxqq_back_trans br51_cxqq_back_trans = busiDao.selectOne(namespace + "selectBr51_cxqq_back_transByID", bdhm, cdColumns);
		if (br51_cxqq_back_trans == null)
			br51_cxqq_back_trans = new Br51_cxqq_back_trans();
		return br51_cxqq_back_trans;
	}
	
	/**
	 * 账卡号持有人资料查询
	 * 
	 * @param br51_cxqq_back_acct
	 * @return
	 * @throws SQLException
	 * @date 2016年9月3日 上午11:07:35
	 */
	public List<Br51_cxqq_back_card> getBr51_cxqq_back_cardList(Br51_cxqq_back br51_cxqq_back) throws SQLException {
		// 定义转换码表 
		///I:对私 C:对公 
		String[] cdColumns = new String[] {};
		if (br51_cxqq_back.getParty_class_cd().equalsIgnoreCase("I")) {
			cdColumns = new String[] {"zzlx:DwhZjlx:zzlx_disp"};
		} else {
			cdColumns = new String[] {"zzlx:DwhZjlx:zzlx_disp"};
		}
		List<Br51_cxqq_back_card> list = busiDao.selectList(namespace + "selectBr51_cxqq_back_cardListByVo", br51_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 开户资料查询
	 * 
	 * @param br51_cxqq_back_acct
	 * @return
	 * @throws SQLException
	 * @date 2016年9月3日 上午11:07:35
	 */
	public List<Br51_cxqq_back_party> getBr51_cxqq_back_partyList(Br51_cxqq_back br51_cxqq_back) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"frdbzjlx_disp:DwhZjlx:frdbzjlx_disp", "dbrzzlx:DwhZjlx:dbrzzlx_disp"};
		
		List<Br51_cxqq_back_party> list = busiDao.selectList(namespace + "selectBr51_cxqq_back_partyListByVo", br51_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 交易明细查询
	 * 
	 * @param br51_cxqq_back_acct
	 * @return
	 * @throws SQLException
	 * @date 2016年9月3日 上午11:07:35
	 */
	public List<Br51_cxqq_back_trans> getBr51_cxqq_back_transList(Br51_cxqq_back br51_cxqq_back) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"debit_credit:G00008:debit_credit_disp", "currency:Dwhbz:currency_disp"};
		
		List<Br51_cxqq_back_trans> list = busiDao.selectList(namespace + "selectBr51_cxqq_back_transListByVo", br51_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 账户信息查询
	 * 
	 * @param br51_cxqq_back_acct
	 * @return
	 * @throws SQLException
	 * @date 2016年9月3日 上午11:07:35
	 */
	public List<Br51_cxqq_back_acct> getBr51_cxqq_back_acctList(Br51_cxqq_back br51_cxqq_back) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"zhzt:G00026:zhzt_disp", "hbzl:Dwhbz:hbzl_disp"};
		
		List<Br51_cxqq_back_acct> list = busiDao.selectList(namespace + "selectBr51_cxqq_back_acctListByVo", br51_cxqq_back);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param ah * @return
	 */
	public Br51_cxqq_back getBr51_cxqq_backDisp(String bdhm) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		
		Br51_cxqq_back br51_cxqq_back = busiDao.selectOne(namespace + "selectBr51_cxqq_backByID", bdhm, cdColumns);
		if (br51_cxqq_back == null)
			br51_cxqq_back = new Br51_cxqq_back();
		return br51_cxqq_back;
	}
	
}
