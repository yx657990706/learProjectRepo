package citic.cgb.face.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cgb_face_request_log  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2563267534819325163L;
	
	/**请求系统的代码 */
	private String sys_code = "";
	
	/**交易代码（接口编号：如AFP005） */
	private String trans_code = "";
	
	/**查询时间 19位yyyyMMdd HH:mm:ss */
	private String query_time = "";
	
	/**查询条件 */
	private String query_condition = "";
	
	/**备注 */
	private String remark = "";
	
	/**发起方交易流水号*/
	private String sender_sn = "";	
}
