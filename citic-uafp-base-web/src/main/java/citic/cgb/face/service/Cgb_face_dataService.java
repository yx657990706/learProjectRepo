/*
 * =============================================
 * Copyright (c) 2014-2015 by CITIC All rights reserved.
 * Created [2017-04-12]
 * =============================================
 */

package citic.cgb.face.service;

/**
 * <p>
 * Cgb_face_dataService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author $Author: $
 */

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import citic.aml.base.AmlBaseService;
import citic.base.annotations.BusiTx;
import citic.base.utils.DtUtils;
import citic.cgb.face.domain.Cgb_face_data;
import citic.cgb.face.domain.Cgb_face_data_AFP;
import citic.cgb.face.domain.Cgb_face_group_rel;
import citic.cgb.face.domain.Cgb_face_img;
import citic.cgb.tools.ImgUtils;

import com.google.common.collect.Sets;

@Service
public class Cgb_face_dataService extends AmlBaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7489706239407878384L;
	
	/** map命名空间 */
	private String namespace = "citic.cgb.face.mapper.busi.Cgb_face_dataMapper.";
	
	@Autowired
	private Cgb_face_dataHmdSendService service;
	
	/**
	 * 列表查询，根据查询对象中的page对象属性，确定是否进行分页查询，查询总记录数，放在page对象中
	 * 名单新增
	 * 
	 * @param cgb_face_data * @return
	 */
	public List<Cgb_face_data> getCgb_face_dataList(Cgb_face_data cgb_face_data) throws Exception {
		// 定义转换码表 
		String[] cdColumns = new String[] {"victim_card_type:G00044:victim_card_type_disp", "risk_type:G00045:risk_type_disp"};
		List<Cgb_face_data> list = busiDao.selectList(namespace + "selectCgb_face_dataByVo", cgb_face_data);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		//获取图片BASE64字符串
		if (list != null && list.size() > 0) {
			String rootPath = codeService.getCodeValue("Dpara", "1");
			for (int i = 0; i < list.size(); i++) {
				Cgb_face_data data = list.get(i);
				String imgBase64 = ImgUtils.getSrcImgBase64Str(rootPath + File.separatorChar + data.getImg_path());
				list.get(i).setImg_base64(imgBase64);
			}
		}
		return list;
	}
	
	/**
	 * 图片存储
	 * 
	 * @param cgb_face_data * @return
	 */
	public int insertCgb_face_dataImgList(Cgb_face_img cgb_face_img) throws SQLException {
		int i = busiDao.insert(namespace + "insertCgb_face_img", cgb_face_img);
		return i;
		
	}
	
	/**
	 * 辅助证件存储
	 * 
	 * @param cgb_face_data * @return
	 */
	public int insertCgb_face_dataAssist(Cgb_face_data cgb_face_data) throws SQLException {
		int i = busiDao.insert(namespace + "insertCgb_face_assist", cgb_face_data);
		return i;
	}
	
	/**
	 * 名单审核list
	 * 
	 * @param cgb_face_data
	 * @return
	 * @throws SQLException
	 * @author yinxiong
	 * @date 2017年4月21日 上午9:58:24
	 */
	public List<Cgb_face_data> getCgb_face_dataCheckList(Cgb_face_data cgb_face_data) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"busi_website:Dorgan:busi_website_disp", "victim_card_type:G00044:victim_card_type_disp", "busi_way:G00046:busi_way_disp",
											"risk_type:G00045:risk_type_disp", "md_channel:G00050:md_channel_disp"};
		List<Cgb_face_data> list = busiDao.selectList(namespace + "selectCgb_face_dataCheckList", cgb_face_data);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 名单查询List<br>
	 * 
	 * 审核状态定义：<br>
     * 1.审核通过   建库审核通过，没有出库审核<br>
     * 2.审核不通过 建库审核不通过<br>
     * 3.出库通过   建库审核通过后，又出库成功<br>
     * 4.出库不通过 建库成功后，存在出库记录但出库不通过
	 * @param cgb_face_data
	 * @return
	 * @throws SQLException
	 * @author yinxiong
	 * @date 2017年4月21日 上午10:00:03
	 */
	public List<Cgb_face_data> getCgb_face_dataQueryList(Cgb_face_data cgb_face_data) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"busi_website:Dorgan:busi_website_disp", "victim_card_type:G00044:victim_card_type_disp", "busi_way:G00046:busi_way_disp",
											"risk_type:G00045:risk_type_disp", "check_result:G00048:check_result_disp", "md_channel:G00050:md_channel_disp"};
		//查询条件转换
		String rs = cgb_face_data.getCheck_result();
		if ("2".equals(rs)) {
			cgb_face_data.setRm_flag_disp("'0','1'");
		} else if ("4".equals(rs)) {
			cgb_face_data.setCheck_result("2");
			cgb_face_data.setRm_flag_disp("'2'");
		}else if ("5".equals(rs)) {
			cgb_face_data.setCheck_result("2");
			cgb_face_data.setRm_flag_disp("'3'");
		}
		List<Cgb_face_data> list = busiDao.selectList(namespace + "selectCgb_face_dataQueryList", cgb_face_data);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		//还原查询条件
		cgb_face_data.setCheck_result(rs);
		
		return list;
	}
	
	/**
	 * 嫌疑人图像信息
	 * 
	 * @param cgb_face_data * @return
	 */
	public List<Cgb_face_data> getCgb_face_suspectImgList(Cgb_face_data cgb_face_data) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"busi_website:Dorgan:busi_website_disp", "victim_card_type:G00044:victim_card_type_disp", "busi_way:G00046:busi_way_disp",
											"risk_type:G00045:risk_type_disp", "data_source:G00047:data_source_disp"};
		List<Cgb_face_data> list = busiDao.selectList(namespace + "selectCgb_face_suspectImglist", cgb_face_data);
		//或在DAO查询中直接转换  
		list = codeService.transListOfBean(list, cdColumns);
		return list;
	}
	
	/**
	 * 一组图片明细查询
	 * //图像id置换问题:手工添加的图片需要去人脸识别获取id，时机发生在审核通过后。那么审核的查询组信息和查询的组信息获取方式有差异
	 * //审核的全部来自HMD003接口,查询的是：至多1+5来自HMD003接口，核查照和辅助照来自本地
	 * //这就涉及图片存储，目前定义图片为一个目录，按照ID存，图片暂时永久存储添加时可以删除。
	 * 
	 * @param cgb_face_data
	 * @return
	 * @throws SQLException
	 * @author yinxiong
	 * @date 2017年4月21日 上午10:19:48
	 */
	public List<Cgb_face_data> getCgb_face_dataGroupList(Cgb_face_data cgb_face_data, String flag) throws Exception {
		
		// 定义转换码表 
		String[] cdColumns = new String[] {"victim_card_type:G00044:victim_card_type_disp", "risk_type:G00045:risk_type_disp"};
		//根据组号查询数据
		List<Cgb_face_data> list = null;
		//查询的风险类型不同
		if ("1".equals(flag)) {
			list = busiDao.selectList(namespace + "selectCgb_face_dataGroupCheckList", cgb_face_data);
		} else {
			list = busiDao.selectList(namespace + "selectCgb_face_dataGroupQueryList", cgb_face_data);
		}
		if (list != null && list.size() > 0) {
			
			list = codeService.transListOfBean(list, cdColumns);
			//获取图片地址,转换为base64
			if (list.get(0).getData_source().equals("1")) {//判断数据来源 1:手工   2:柜面/VTM 3:高清拍摄(暂不考虑)
				//获取嫌疑人图像并转换为base64
				String suspectImgPath = list.get(0).getImg_path();
				String suspect_img = this.getSrcImgBase64ByPath(suspectImgPath);
				//获取联网核查照并转换为base64
				String victimImgPath = list.get(0).getImg_path_2();
				String victim_img = this.getSrcImgBase64ByPath(victimImgPath);
				//赋值
				list.get(0).setSuspect_img(suspect_img);
				list.get(0).setVictim_img(victim_img);
				//取相似图片base64
				for (int i = 1; i < list.size(); i++) {
					String sPath = list.get(i).getImg_path();
					String vPath = list.get(i).getImg_path_2();
					String s_img = this.getSrcImgBase64ByPath(sPath);
					String v_img = this.getSrcImgBase64ByPath(vPath);
					list.get(i).setSuspect_img(s_img);
					list.get(i).setVictim_img(v_img);
				}
			} else {
				//封装查询对象
				Cgb_face_data request = new Cgb_face_data();
				for (int i = 0; i < list.size(); i++) {
					String v1 = list.get(i).getSuspect_img_id();
					String v2 = list.get(i).getVictim_img_id();
					if (i == 0) {
						request.setSuspect_img_id(v1);
						request.setVictim_img_id(v2);
					} else {
						this.setParamByKey(i, v1, request);
					}
				}
				//调用HMD004接口获取图像
				Cgb_face_data_AFP afp = service.sendHMD004ReqMsg(request);
				//将图像base64封入list
				for (int i = 0; i < list.size(); i++) {
					if (i == 0) {
						list.get(i).setSuspect_img(ImgUtils.getSrcImgBase64StrByData(afp.getSuspect_img()));//嫌疑人图片base64
						list.get(i).setVictim_img(ImgUtils.getSrcImgBase64StrByData(afp.getVictim_img()));//受害人图片base64
					} else {
						list.get(i).setSuspect_img(ImgUtils.getSrcImgBase64StrByData(this.getParamByKey(i, afp)));//相似图片
						list.get(i).setVictim_img(ImgUtils.getSrcImgBase64StrByData(this.getParamLwhcByKey(i, afp)));//相似图片的联网核查照
					}
				}
			}
			
			//查询辅助照片(最多三张)
			//根据图像ID查询辅助图像地址
			List<Cgb_face_img> imgList = busiDao.selectList(namespace + "selectAssistImgPathListByID", list.get(0).getSuspect_img_id());
			//将图像bse64处理,最多取3张
			if (imgList != null && imgList.size() > 0) {
				for (int j = 0; j < imgList.size(); j++) {
					String img = this.getSrcImgBase64ByPath(imgList.get(j).getImg_path());
					if (j == 0) {
						list.get(0).setAssist_img_1(img);
					} else if (j == 1) {
						list.get(0).setAssist_img_2(img);
					} else {
						list.get(0).setAssist_img_3(img);
					}
				}
			}
		}
		//返回查询结果
		return list;
	}
	
	/**
	 * 根据图片id获取图片base64(可直接用于html)
	 * 
	 * @param imgId
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月25日 下午2:27:56
	 */
	private String getSrcImgBase64ByID(String imgId) throws Exception {
		String imgBase64 = "";
		if (!StringUtils.isBlank(imgId)) {
			Cgb_face_img victimImg = busiDao.selectOne(namespace + "selectCgb_face_imgByVo", imgId);
			String rootPath = codeService.getCodeValue("Dpara", "1");//上传根路径
			String imgPath = rootPath + File.separatorChar + victimImg.getImg_path();//文件绝对路径
			
			imgBase64 = ImgUtils.getSrcImgBase64Str(imgPath);
		}
		return imgBase64;
	}
	
	/**
	 * 根据图片相对路径获取图片base64(可直接用于html)
	 * 
	 * @param relativePath
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月25日 下午2:35:54
	 */
	private String getSrcImgBase64ByPath(String relativePath) throws Exception {
		String imgBase64 = "";
		if (!StringUtils.isBlank(relativePath)) {
			String rootPath = codeService.getCodeValue("Dpara", "1");//上传根路径
			String imgPath = rootPath + File.separatorChar + relativePath;//文件绝对路径
			imgBase64 = ImgUtils.getSrcImgBase64Str(imgPath);
		}
		
		return imgBase64;
	}
	
	/**
	 * 根据图片相对路径获取图片base64
	 * 
	 * @param relativePath
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月25日 下午2:35:54
	 */
	private String getImgBase64ByPath(String relativePath) throws Exception {
		String imgBase64 = "";
		if (!StringUtils.isBlank(relativePath)) {
			String rootPath = codeService.getCodeValue("Dpara", "1");//上传根路径
			String imgPath = rootPath + File.separatorChar + relativePath;//文件绝对路径
			imgBase64 = ImgUtils.getImgBase64Str(imgPath);
		}
		
		return imgBase64;
	}
	
	/**
	 * 根据序号取值
	 * 
	 * @param key
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年4月22日 下午5:43:03
	 */
	private String getParamByKey(int key, Cgb_face_data_AFP request) {
		String val = "";
		switch (key) {
		case 1:
			val = request.getSimilarity_img_1();
			break;
		case 2:
			val = request.getSimilarity_img_2();
			break;
		case 3:
			val = request.getSimilarity_img_3();
			break;
		case 4:
			val = request.getSimilarity_img_4();
			break;
		case 5:
			val = request.getSimilarity_img_5();
			break;
		default:
			break;
		}
		return val;
	}
	
	private String getParamLwhcByKey(int key, Cgb_face_data_AFP request) {
		String val = "";
		switch (key) {
		case 1:
			val = request.getSimilarity_lwhc_img_1();
			break;
		case 2:
			val = request.getSimilarity_lwhc_img_2();
			break;
		case 3:
			val = request.getSimilarity_lwhc_img_3();
			break;
		case 4:
			val = request.getSimilarity_lwhc_img_4();
			break;
		case 5:
			val = request.getSimilarity_lwhc_img_5();
			break;
		default:
			break;
		}
		return val;
	}
	
	/**
	 * 给DTO赋值
	 * 
	 * @param key
	 * @param val
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年4月22日 下午5:38:15
	 */
	private Cgb_face_data setParamByKey(int key, String val, Cgb_face_data request) {
		switch (key) {
		case 1:
			request.setSimilarity_id_1(val);
			break;
		case 2:
			request.setSimilarity_id_2(val);
			break;
		case 3:
			request.setSimilarity_id_3(val);
			break;
		case 4:
			request.setSimilarity_id_4(val);
			break;
		case 5:
			request.setSimilarity_id_5(val);
			break;
		default:
			break;
		}
		return request;
	}
	
	/**
	 * 名单组审核 <br>
	 * 以组为单位，更新数据状态
	 * 
	 * @param cgb_face_data
	 * @author yinxiong
	 * @date 2017年4月24日 上午10:45:14
	 */
	@BusiTx
	public void checkDo(Cgb_face_data cgb_face_data) throws Exception {
		boolean flag = false;
		String[] xy = cgb_face_data.getGID();//由组号&来源拼接而成的
		//去掉重复数据
		HashSet<String> set = Sets.newHashSet(xy);
		xy = set.toArray(new String[set.size()]);
		List<String> x = new ArrayList<String>(xy.length);//组id
		List<String> y = new ArrayList<String>(xy.length);//组来源
		//拆分
		for (String str : xy) {
			String[] a = str.split("&");
			x.add(a[0]);
			y.add(a[1]);
		}
		String[] groupIds = x.toArray(new String[x.size()]);
		String[] sources = y.toArray(new String[y.size()]);
		
		cgb_face_data.setCheck_time(DtUtils.getNowTime());//审核时间
		String identify_result = cgb_face_data.getIdentify_result();//认定结果 0：正常 1：黑名单 2：灰名单
		if ("0".equals(identify_result)) {//审核不通过
			cgb_face_data.setCheck_result("3");
			String ids = "";
			for (String id : groupIds) {
				ids += "'" + id + "',";
			}
			ids = ids.substring(0, ids.length() - 1);
			cgb_face_data.setIds(ids);
			
			//人工添加的组需要全部修改，系统增加的只修改主记录风险类型  
			for (int i = 0; i < groupIds.length; i++) {
				if (!"1".equals(sources[i])) {
					cgb_face_data.setIs_main("1");
				}
				cgb_face_data.setRisk_type("0");
				cgb_face_data.setGroup_id(groupIds[i]);
				//修改主记录的风险类型
				busiDao.update(namespace + "updateCgb_face_dataRiskType", cgb_face_data);
			}
			//更新组状态
			busiDao.update(namespace + "updateCgb_face_groupResult", cgb_face_data);
		} else {
			cgb_face_data.setCheck_result("2");
			for (int i = 0; i < sources.length; i++) {
				String groupId = groupIds[i];
				if ("1".equals(sources[i])) {//1：人工新增 2：柜面上报 3：高清拍摄（暂不考虑）
					//获取同组名单数据
					List<Cgb_face_data> relList = busiDao.selectList(namespace + "selectCgb_face_group_dataByGroupID", groupId);
					for (Cgb_face_data data : relList) {
						//设置认定结果
						data.setRisk_type(identify_result);
						//设置图像base64
						data.setImg_base64(getImgBase64ByPath(data.getImg_path()));
						//调用接口同步数据并获取图像id
						Cgb_face_data_AFP response = service.sendHMD002ReqMsg(data);
						//返回结果代为0，并且生成了新的图像id
						if (response.getResult().equals("0") && !StringUtils.isBlank(response.getSuspect_img_id())) {
							data.setImg_id(response.getSuspect_img_id());//人脸识别同一生成的图像ID
							//更新嫌疑人图像ID 3条sql
							busiDao.update(namespace + "updateCgb_face_group_relByImgID", data);
							busiDao.update(namespace + "updateCgb_face_dataByImgID", data);
							busiDao.update(namespace + "updateCgb_face_imgByImgID", data);
							//							//辅助证件表，暂不考虑
							//							busiDao.update(namespace + "updateCgb_face_assistByImgID", cgb_face_data);
							flag = true;
						}
					}
				} else {
					
					//找出当前待认定的记录
					Cgb_face_data request = busiDao.selectOne(namespace + "selectCgb_face_group_dataByKeys", groupId);
					//获取同组剩余名单数据
					List<Cgb_face_data> otherList = busiDao.selectList(namespace + "selectCgb_face_group_dataByKeysNo", groupId);
					for (int j = 0; j < otherList.size(); j++) {
						String v1 = otherList.get(j).getSuspect_img_id();
						this.setParamByKey(j + 1, v1, request);
					}
					//设置认定结果
					request.setRisk_type(identify_result);
					//同步数据给人脸识别系统
					Cgb_face_data_AFP response = service.sendHMD003ReqMsg(request);
					if (response.getResult().equals("0")) {
						flag = true;
					}
				}
				if (flag) {
					cgb_face_data.setRisk_type(identify_result);
					cgb_face_data.setGroup_id(groupId);
					//修改数据的风险类型
					busiDao.update(namespace + "updateCgb_face_dataRiskType", cgb_face_data);
					//修改组状态及认定结果
					busiDao.update(namespace + "updateCgb_face_groupResult", cgb_face_data);
				}
			}
		}
		
	}
	
	/**
	 * 人工新增名单数据认定
	 * 
	 * @param cgb_face_data
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月26日 上午10:41:44
	 */
	public void personAddCgb_face_group(Cgb_face_data cgb_face_data, String[] keys) throws Exception {
		
		String in_key = "";
		String group_id = this.getGroupID("SEQ_CGB_FACE_GROUP");//生成组号
		cgb_face_data.setGroup_id(group_id);
		cgb_face_data.setData_source("1");//1:人工新增 2：柜面上传 3：高清拍摄
		cgb_face_data.setCommit_time(DtUtils.getNowTime());//19位提交时间
		cgb_face_data.setCheck_result("1");
		//插入组信息
		busiDao.insert(namespace + "InsertCgb_face_groupByAdd", cgb_face_data);
		//插入关系信息
		List<Cgb_face_group_rel> list = this.getRelList(cgb_face_data, keys);
		busiDao.insert(namespace + "insertCgb_face_group_relByBatch", list);
		if (keys != null && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				in_key += ",'" + keys[i] + "'";
			}
			in_key = in_key.substring(1);
		}
		cgb_face_data.setIds(in_key);
		cgb_face_data.setFirmly_flag("1");
		//修改认定状态
		busiDao.update(namespace + "updateFirmly_flag", cgb_face_data);
		
	}
	
	/**
	 * 获取分组关系list
	 * 
	 * @param request
	 * @return
	 * @author yinxiong
	 * @date 2017年4月14日 下午3:37:07
	 */
	private List<Cgb_face_group_rel> getRelList(Cgb_face_data request, String[] keys) {
		List<Cgb_face_group_rel> list = new ArrayList<Cgb_face_group_rel>();
		if (keys != null && keys.length > 0) {
			int num = 0;
			for (int i = 0; i < keys.length; i++) {
				Cgb_face_group_rel rel = new Cgb_face_group_rel();
				rel.setGroup_id(request.getGroup_id());
				rel.setSuspect_img_id(keys[i]);
				rel.setNum(++num);
				rel.setIs_main(i == 0 ? "1" : "0");
				list.add(rel);
			}
		}
		
		return list;
	}
	
	/**
	 * 插入单条记录
	 * 
	 * @param cgb_face_data * @return
	 */
	public int insertCgb_face_data(Cgb_face_data cgb_face_data) throws SQLException {
		int i = busiDao.insert(namespace + "insertCgb_face_data", cgb_face_data);
		return i;
	}
	
	/**
	 * 执行更新操作
	 * 
	 * @param cgb_face_data * @return
	 */
	public int modifyCgb_face_data(Cgb_face_data cgb_face_data) throws SQLException {
		cgb_face_data.setModify_time(DtUtils.getNowTime());
		int i = busiDao.update(namespace + "updateCgb_face_data", cgb_face_data);
		return i;
	}
	
	/**
	 * 根据主键删除
	 * 
	 * @param suspect_img_id * @return
	 */
	@BusiTx
	public int deleteCgb_face_data(String suspect_img_id) throws SQLException {
		
		//1.根据id查询嫌疑人、受害人和辅助证件路径并删除附件
		
		//2.删除表中记录
		int i = busiDao.delete(namespace + "deleteCgb_face_imgByID", suspect_img_id);
		i = busiDao.delete(namespace + "deleteCgb_face_assistByID", suspect_img_id);
		i = busiDao.delete(namespace + "deleteCgb_face_dataByID", suspect_img_id);
		return i;
	}
	
	public int deleteCgb_face_dataByCheck(Cgb_face_data cgb_face_data) throws SQLException {
		//删除组关系
		int i = busiDao.delete(namespace + "deleteCgb_face_group_relByID", cgb_face_data);
		return i;
	}
	
	/**
	 * 根据主键查询单条记录
	 * 
	 * @param suspect_img_id * @return
	 */
	public Cgb_face_data getCgb_face_dataDisp(String suspect_img_id) throws SQLException {
		// 定义转换码表 
		String[] cdColumns = new String[] {"busi_website:Dorgan:busi_website_disp"};
		Cgb_face_data cgb_face_data = busiDao.selectOne(namespace + "selectCgb_face_dataByID", suspect_img_id, cdColumns);
		if (cgb_face_data == null)
			cgb_face_data = new Cgb_face_data();
		String busitime = cgb_face_data.getBusi_time().trim();
		String validity = cgb_face_data.getVictim_card_validity().trim();
		if (!StringUtils.isBlank(busitime)) {
			String date1 = busitime.replaceAll("-", "");
			cgb_face_data.setBusi_time(date1);
		}
		if (!StringUtils.isBlank(validity)) {
			String date2 = validity.replaceAll("-", "");
			cgb_face_data.setVictim_card_validity(date2);
		}
		return cgb_face_data;
	}
	
	/**
	 * 获取10位长度的组号
	 * 
	 * @param seqName
	 * @return
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年4月14日 下午2:03:19
	 */
	private String getGroupID(String seqName) throws Exception {
		int init_len = 10;//定义组号长度
		String seq = this.getSequenceValus("SEQ_CGB_FACE_GROUP");
		int x = seq.length();//序列长度
		StringBuilder sb = new StringBuilder("G");
		for (int i = 0; i < (init_len - x - 1); i++) {
			sb.append("0");
		}
		return sb.toString() + seq;
	}
	
	/**
	 * 名单出库 <br>
	 * 设置出库人及时间，并标记数据状态
	 * 
	 * @param cgb_face_data
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月28日 上午11:18:41
	 */
	public void RemoveDo(Cgb_face_data cgb_face_data) throws Exception {
		
		cgb_face_data.setRm_time(DtUtils.getNowTime());
		cgb_face_data.setRm_flag("1");
		//标记名单
		busiDao.update(namespace + "updateCgb_face_dataByRemove", cgb_face_data);
	}
	
	/**
	 * 名单出库审核
	 * 
	 * @param cgb_face_data
	 * @throws Exception
	 * @author yinxiong
	 * @date 2017年6月28日 上午11:58:17
	 */
	public void RemoveCheckDo(Cgb_face_data cgb_face_data) throws Exception {
		boolean flag = true;
		Cgb_face_data request = new Cgb_face_data();
		String bzw = cgb_face_data.getBzw();
		String ids = "";
		String[] keys = cgb_face_data.getIds().split("@", -1);//全部出库的图片ID以@做分隔符拼接
		for (int j = 0; j < keys.length; j++) {
			ids += ",'" + keys[j] + "'";
			if (j == 0) {
				request.setSuspect_img_id(keys[j]);
			} else {
				this.setParamByKey(j, keys[j], request);
			}
		}
		ids = ids.substring(1);
		cgb_face_data.setIds(ids);
		cgb_face_data.setRm_check_time(DtUtils.getNowTime());
		//判断是否出库审核通过
		if ("Y".equals(bzw)) {
			cgb_face_data.setRm_flag("2");
			
			//同步数据给人脸识别系统
			Cgb_face_data_AFP response = service.sendHMD006ReqMsg(request);
			if (!StringUtils.equals("0", response.getResult())) {
				flag = false;
			}
		} else {
			//更新出库审核人和时间以及出库标识
			cgb_face_data.setRm_flag("3");
		}
		if (flag) {
			busiDao.update(namespace + "updateCgb_face_dataByRemoveCheck", cgb_face_data);
		}
	}
}
