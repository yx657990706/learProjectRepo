package citic.cgb.face.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import citic.base.BaseVo;

@Data                                                  
@EqualsAndHashCode(callSuper = false)  
public class Cgb_face_img extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 866060094374028133L;

	/**图片id*/
	private   String img_id="";
	
	/**图片类型*/
	private  String img_type="";
	
	/**图片路径*/
	private   String img_path="";
	
   /**图片名称*/
	private String img_name="";
	
	//嫌疑人图像ID
	private String suspect_img_id="";
	//辅助证件类型
	private String assist_card_type="";
	//辅助证件号码
	private String assist_card_num="";
	//辅助证件名称
	private String assist_card_name="";
	
 }
