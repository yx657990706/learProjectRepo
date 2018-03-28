package citic.gdjc.ckdj.service;

/**
 * <p>
 * Br50_cxqqService.java
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
import citic.gdjc.ckdj.domain.Br50_cxqq;
import citic.gdjc.ckdj.domain.Br50_cxqq_back_acct;
import citic.gdjc.ckdj.domain.Br50_cxqq_back_trans;
import citic.gdjc.ckdj.domain.Br50_cxqq_mx;

@Service
public class Br50_cxqqService extends BaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1517297915576646969L;
	
	/** 日志记录器 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** map命名空间 */
	private String namespace = "citic.gdjc.ckdj.mapper.busi.Br50_cxqqMapper.";
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 
	 * @param br50_cxqq * @return
	 */
	public List<Br50_cxqq> getBr50_cxqqList(Br50_cxqq br50_cxqq) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"datasource:G00012:datasource_disp", "orgkey:Dorgan:orgkey_disp", "status:G00022:status_disp"};
		List<Br50_cxqq> list = busiDao.selectList(namespace + "selectBr50_cxqqByVo", br50_cxqq);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询账户交易流水
	 * 
	 * @param br50_cxqq * @return
	 */
	public List<Br50_cxqq_mx> getBr50_cxqqListAccountTrans(Br50_cxqq_mx br50_cxqq_mx) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"type:G00006:type_disp", "idtype:DgdjcZjlx:idtype_disp", "exchangetype:G00020:exchangetype_disp", "status:G00017:status_disp", "cxfkjg:G00021:cxfkjg_disp"};
		List<Br50_cxqq_mx> list = busiDao.selectList(namespace + "selectBr50_cxqq_account_trans", br50_cxqq_mx);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询账户反馈信息
	 * 
	 * @param br50_cxqq * @return
	 */
	public List<Br50_cxqq_back_acct> getBr50_cxqqListAccount(Br50_cxqq_back_acct br50_cxqq_back_acct) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"status:G00022:status_disp", "cardstatus:G00011:cardstatus_disp", "datatype:G00014:datatype_disp", "exchangetype:G00015:exchangetype_disp",
											"currency:Dgdjcbz:currency_disp", "statusflag:G00016:statusflag_disp"};
		List<Br50_cxqq_back_acct> list = busiDao.selectList(namespace + "selectBr50_cxqq_back_acctByVo", br50_cxqq_back_acct);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 查询账户交易流水反馈信息
	 * 
	 * @param br50_cxqq * @return
	 */
	public List<Br50_cxqq_back_trans> getBr50_cxqqListAccountTransBack(Br50_cxqq_back_trans br50_cxqq_back_trans) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"currency:Dgdjcbz:currency_disp", "exchangetype:G00020:exchangetype_disp"};
		if (!"".equals(br50_cxqq_back_trans.getTranstime_start())) {
			br50_cxqq_back_trans.setTranstime_start(br50_cxqq_back_trans.getTranstime_start() + " 00:00:00");
		}
		if (!"".equals(br50_cxqq_back_trans.getTranstime_end())) {
			br50_cxqq_back_trans.setTranstime_end(br50_cxqq_back_trans.getTranstime_end() + " 23:59:59");
		}
		List<Br50_cxqq_back_trans> list = busiDao.selectList(namespace + "selectBr50_cxqq_back_transByVo", br50_cxqq_back_trans);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 插入单条记录
	 * 
	 * @param br50_cxqq * @return
	 */
	public int insertBr50_cxqq(Br50_cxqq br50_cxqq) throws SQLException {
		int i = busiDao.insert(namespace + "insertBr50_cxqq", br50_cxqq);
		return i;
	}
	
	/**
	 * 执行更新操作
	 * @param br50_cxqq * @return
	 */
	public int modifyBr50_cxqq(Br50_cxqq br50_cxqq) throws SQLException {
		int i = busiDao.update(namespace + "updateBr50_cxqq", br50_cxqq);
		return i;
	}
	
	/**
	 * 根据主键删除
	 * @param docno * @return
	 */
	public int deleteBr50_cxqq(String docno) throws SQLException {
		int i = busiDao.delete(namespace + "deleteBr50_cxqqByID", docno);
		return i;
	}
	
	/**
	 * 根据主键查询单条记录
	 * @param docno * @return
	 */
	public Br50_cxqq getBr50_cxqqDisp(String docno) throws SQLException {
		String[] cdColumns = new String[] {"flag:S00002:flag_disp"};
		Br50_cxqq br50_cxqq = busiDao.selectOne(namespace + "selectBr50_cxqqByID", docno, cdColumns);
		if (br50_cxqq == null)
			br50_cxqq = new Br50_cxqq();
		return br50_cxqq;
	}
	
}
