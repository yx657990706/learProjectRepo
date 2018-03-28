var Common = new Object();

// 去掉全部空格
Common.trim = function(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

// 计算字符串长度
Common.strlen = function(str) {
	var Charset = document.characterSet
	return str.replace(/[^\x00-\xff]/g, "**").length;
}
// 获取当前时间yyyy-MM-dd
Common.nowdate = function() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var day = now.getDate();
	var clock = year + "-";
	if (month < 10)
		clock += "0";
	clock += month + "-";
	if (day < 10)
		clock += "0";
	clock += day;

	return clock;
}

// 全部函数定义
validator = {
	errinput : 'errinput',
	errmsg : 'errmsg',
	errcls : 'no',
	yescls : 'yes',
	errorTip : 'errorTip',
	errorInput : 'errorInput',
	validTip : 'validTip',
	require : /[^(^\s*)|(\s*$)]/,
	email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	phone : /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/,
	mobile :/^((13[0-9])|(14[5|7])|(15[^4])|(17[0-8])|(18[0-9]))[0-9]{8}$/,
	telno : /(^((13[0-9])|(14[5|7])|(15[^4])|(17[0-8])|(18[0-9]))[0-9]{8}$)|(^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$)/,
	url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
	idCard : "this.isIdCard(value)",
	currency : /^\d+(\.\d+)?$/,
	number : /^\d+$/,
	zip : /^[1-9]\d{5}$/,
	ip : /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,
	qq : /^[1-9]\d{4,8}$/,
	integer : /^[-\+]?\d+$/,
	double : /^[-\+]?\d+(\.\d+)?$/,
	english : /^[A-Za-z]+$/,
	chinese : /^[\u0391-\uFFE5]+$/,
	userName : /^[A-Za-z0-9_]{3,}$/i,
	// unSafe :
	// /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
	// unSafe : /[<>\?\!\？\！\#\$\*\&;\\\/\[\]\{\}=\(\)\.\^%,]/,
	unSafe : /[\?\!\？\！\$\*\^%]/,
	// safeStr : /[^#\'\"~\.\*\$&;\\\/\|]/,
	isSafe : function(str) {
		return !this.unSafe.test(str);
	},
	safeString : "this.isSafe(value)",
	filter : "this.doFilter(value)",
	limit_max : "this.checkLimit(Common.strlen(value),'max')",
	limit_min : "this.checkLimit(Common.strlen(value),'min')",
	limit : "this.checkLimit(Common.strlen(value),'both')",
	limitB : "this.checkLimit(this.LenB(value))",
	date : "this.isDate(value)",
	repeat : "this.checkRepeat(value)",
	range : "this.checkRange(value)",
	compare : "this.checkCompare(value)",
	custom : "this.Exec(value)",
	group : "this.mustChecked()",
	ajax : "this.doajax(errindex)",
	hasnotnull : "this.hasNotnull(value)",
	replaceStr : /[^(^(\s*)((@E)|(@N)|(@I))(\s*)$)]/,
	name : "this.checkName(value)",
	cardno : "this.checkCardno(value)",
	futureDate : "this.checkFutureDate(value)",
	pastDate : "this.checkPastDate(value)",
	numLen : "this.checkNumLen(value)",
	date_8 :"this.checkDate_8(value)",

	
	/**
	 * 指定长度的数字校验
	 * <br>用法：require="true" datatype="numLen_8" para="联系电话"
	 */
	checkNumLen : function(value) {
		if (value.length > 0) {
			var element = this['element'];
			var plen = Common.strlen(value);
			var elemName = this['element'].attr('para');//字段中文名
			elemName = "undefined"==typeof(elemName)?"数字":elemName;//处理未定义情况
			var elemLen = this['element'].attr('maxlength');//最大长度限制或者规定长度
			// 长度校验
			if (plen != elemLen) {
				element.attr("msg", "请输入"+elemLen+"位"+elemName+"！");
				return false;
			} 
			// 数字校验
			if (!this.number.test(value)) {
				element.attr("msg", "请输入"+elemLen+"位"+elemName+"！");
				return false;
			}
		}
		return true;
	},
	
	// 8位yyyyMMdd日期格式
	checkDate_8 : function(value) {
		if (value.length > 0) {
			var date_10;
			var element = this['element'];
			var plen = Common.strlen(value);
			if (plen != 8) {
				element.attr("msg", "请输入8位有效日期！");
				return false;
			}
			// 日期格式化为yyyy-MM-dd
			date_10 = value.substring(0, 4) + "-" + value.substring(4, 6)
			+ "-" + value.substring(6);
			// 校验日期
			if (!this.isDate(date_10, "ymd")) {
				element.attr("msg", "请输入正确的日期！");
				return false;
			}
		}
		return true;
	},
	// 日期格式并大于当前日期
	checkFutureDate : function(value) {
		if (value.length > 0) {
			var date_10;
			var element = this['element'];
			var plen = Common.strlen(value);
			if (plen != 8 && plen != 10) {
				element.attr("msg", "请输入合法的日期！");
				return false;
			}
			// 日期格式化为yyyy-MM-dd
			if (plen == 8) {
				date_10 = value.substring(0, 4) + "-" + value.substring(4, 6)
						+ "-" + value.substring(6);
			} else {
				date_10 = value.replace("/","-").replace("/","-");
			}
			// 校验日期
			if (!this.isDate(date_10, "ymd")) {
				element.attr("msg", "请输入正确的日期！");
				return false;
			}
			// 判断与当前日期的大小
			var now = Common.nowdate();
			if (date_10 < now) {
				element.attr("msg", "不能小于当前日期！");
				return false;
			}
		}
		return true;
	},
	// 日期格式并小于当前日期
	checkPastDate : function(value) {
		if (value.length > 0) {
			var date_10;
			var element = this['element'];
			var plen = Common.strlen(value);
			if (plen != 8 && plen != 10) {
				element.attr("msg", "请输入合法的日期！");
				return false;
			}
			// 日期格式化为yyyy-MM-dd
			if (plen == 8) {
				date_10 = value.substring(0, 4) + "-" + value.substring(4, 6)
						+ "-" + value.substring(6);
			} else {
				date_10 = value.replace("/","-").replace("/","-");
			}
			// 校验日期
			if (!this.isDate(date_10, "ymd")) {
				element.attr("msg", "请输入正确的日期！");
				return false;
			}
			// 判断与当前日期的大小
			var now = Common.nowdate();
			if (date_10 > now) {
				element.attr("msg", "不能大于当前日期！");
				return false;
			}
		}
		return true;
	},

	checkCardno : function(value) { // 证件号码
		var element = this['element'];
		var obj = jQuery('#' + element.attr('para')); // 证件类型
		var cardtype_v = obj.val();
		if (value.length > 0) {
			if (this.replaceStr.test(value)) {

				if (cardtype_v.length != 2) {
					element.attr("msg", "必须填写证件类型！");
					return false;
				}
				var plen = Common.strlen(value);
				if (plen < 6 || plen > 20) {
					element.attr("msg", "证件号长度不能少于6位或大于20位！");
					return false;
				}
				if (cardtype_v == "02" && value.length != 18) {// 第二代居民身份证必须18位
					element.attr("msg", "证件号必须18位！");
					return false;
				}
				if (cardtype_v == "01" || cardtype_v == "02"
						|| cardtype_v == "03") { // 身份证
					if (!this.isIdCard(value)) {
						element.attr("msg", "身份证格式错误！");
						return false;
					}
				}

			}
		} else {
			if (cardtype_v.length > 0 && value == "") {
				element.attr("msg", "不能为空！");
				return false;
			}
		}
		return true;
	},
	checkName : function(value) {
		if (value.length > 0) {
			if (this.replaceStr.test(value)) {
				var element = this['element'];
				if (/^[１２３４５６７８９０\d]+$/g.test(value)) {
					element.attr("msg", "不能全为数字(全角或半角)！");
					return false;
				}
				if (/(^\s+)|(\s+$)/g.test(value)) {
					element.attr("msg", "前后不能有空格");
					return false;
				}
				var plen = Common.strlen(value);
				if (plen < 4) {
					element.attr("msg", "名称不能小于4位");
					return false;
				}
				var name = value.replace(/[^\uFF00-\uFFFF]/g, ''); // 半角
				if (name != "") {
					element.attr("msg", "不能出现全角");
					return false;
				}
				var myReg = /(^[\u4E00-\u9FA5]+)$|^([\u4E00-\u9FA5]+•[\u4E00-\u9FA5]+)+$/g;
				if (myReg.test(value)) { // 中文或 中文•中文
				} else {
					myReg = /(^[A-Z]+)$|^([A-Z]+\s*[A-Z]+)$/g;
					if (myReg.test(value)) { // 英文或 英文 英文
					} else {
						element.attr("msg", "必须是大写英文名或中文名");
						return false;
					}
				}
			}
		}

		return true;
	},

	hasNotnull : function(value) {
		// alert(value+value.length);
		// alert(/(^\s+)|(\s+$)/.test(value)+" eeeee");
		if (/(^\s+)|(\s+$)/g.test(value)) {
			return false;
		}
		// 中间不能有空格
		var value1 = value.replace(/\s/g, ""); // 去除空格
		// alert(value1+value1.length);
		if (value.length != value1.length) {
			return false;
		}

		return true;

	},
	isIdCard : function(number) {
		var date, Ai, Ai_X;
		var verify = "10x98765432";
		var verify_X = "10X98765432";
		var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
		var area = [ '', '', '', '', '', '', '', '', '', '', '', '北京', '天津',
				'河北', '山西', '内蒙古', '', '', '', '', '', '辽宁', '吉林', '黑龙江', '',
				'', '', '', '', '', '', '上海', '江苏', '浙江', '安微', '福建', '江西',
				'山东', '', '', '', '河南', '湖北', '湖南', '广东', '广西', '海南', '', '',
				'', '重庆', '四川', '贵州', '云南', '西藏', '', '', '', '', '', '', '陕西',
				'甘肃', '青海', '宁夏', '新疆', '', '', '', '', '', '台湾', '', '', '',
				'', '', '', '', '', '', '香港', '澳门', '', '', '', '', '', '', '',
				'', '国外' ];

		var re = number
				.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
		if (re == null)
			return false;
		if (re[1] >= area.length || area[re[1]] == "")
			return false;
		if (re[2].length == 12) {
			Ai = number.substr(0, 17);
			Ai_X = number.substr(0, 17);
			date = [ re[9], re[10], re[11] ].join("-");
		} else {
			Ai = number.substr(0, 6) + "19" + number.substr(6);
			Ai_X = number.substr(0, 6) + "19" + number.substr(6);
			date = [ "19" + re[4], re[5], re[6] ].join("-");
		}
		if (!this.isDate(date, "ymd"))
			return false;
		var sum = 0;
		for (var i = 0; i <= 16; i++) {
			sum += Ai.charAt(i) * Wi[i];
		}
		Ai += verify.charAt(sum % 11);
		Ai_X += verify_X.charAt(sum % 11);
		return (number.length == 15 || number.length == 18
				&& (number == Ai || number == Ai_X));
	},

	isDate : function(op) {
		var formatString = this['element'].attr('format');
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch (formatString) {
		case "ymd":
			m = op.match(new RegExp(
					"^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
			if (m == null)
				return false;
			day = m[6];
			month = m[5] * 1;
			year = (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
			break;
		case "dmy":
			m = op.match(new RegExp(
					"^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
			if (m == null)
				return false;
			day = m[1];
			month = m[3] * 1;
			year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
			break;
		default:
			break;
		}
		//检查月份合法性
		if (!parseInt(month)||(parseInt(month)>12))
			return false;
		//检查日合法性
		if (!parseInt(day)||(parseInt(day)>31))
			return false;
		var date = new Date(year, month - 1, day);
		return (typeof (date) == "object" && year == date.getFullYear()
				&& month == (date.getMonth() + 1) && day == date.getDate());
		function GetFullYear(y) {
			return ((y < 30 ? "20" : "19") + y) | 0;
		}

	}, // end isDate
	doFilter : function(value) {
		var filter = this['element'].attr('accept');
		return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(
				/\s*,\s*/).join("|")), "gi").test(value);
	},

	checkLimit : function(len, type) {

		var minval = this['element'].attr('min') || Number.MIN_VALUE;
		var maxval = this['element'].attr('max') || Number.MAX_VALUE;
		if (type == 'max') {
			return (len <= maxval);
		}

		if (type == 'min') {
			return (minval <= len);
		}

		if (type == 'both') {
			return (minval <= len && len <= maxval);
		}

	},

	LenB : function(str) {
		return str.replace(/[^\x00-\xff]/g, "**").length;
	},

	checkRepeat : function(value) {
		var to = this['element'].attr('to');
		return value == jQuery('input[name="' + to + '"]').eq(0).val();
	},

	checkRange : function(value) {
		value = value | 0;
		var minval = this['element'].attr('min') || Number.MIN_VALUE;
		var maxval = this['element'].attr('max') || Number.MAX_VALUE;
		return (minval <= value && value <= maxval);
	},

	checkCompare : function(value) {
		var compare = this['element'].attr('compare');

		if (isNaN(value))
			return false;
		value = parseInt(value);
		return eval(value + compare);
	},

	Exec : function(value) {
		var reg = this['element'].attr('regexp');
		return new RegExp(reg, "gi").test(value);
	},

	mustChecked : function() {
		var tagName = this['element'].attr('name');
		var f = this['element'].parents('form');
		var n = f.find('input[name="' + tagName + '"][checked]').length;
		var count = f.find('input[name="' + tagName + '"]').length;
		var minval = this['element'].attr('min') || 1;
		var maxval = this['element'].attr('max') || count;
		return (minval <= n && n <= maxval);
	},

	doajax : function(value) {
		var element = this['element'];
		var errindex = this['errindex'];
		var url = this['element'].attr('url');
		var msgid = jQuery('#' + element.attr('msgid'));
		var val = this['element'].val();
		var str_errmsg = this['element'].attr('msg');
		var arr_errmsg;
		var errmsg;
		if (str_errmsg.indexOf('|') > -1) {
			arr_errmsg = str_errmsg.split('|');
			errmsg = arr_errmsg[errindex];
		} else {
			errmsg = '';
		}
		var type = this['element'].attr('type');
		var Charset = jQuery.browser.msie ? document.charset
				: document.characterSet;
		var methodtype = (Charset.toLowerCase() == 'utf-8') ? 'post' : 'get';
		var method = this['element'].attr('method') || methodtype;
		var name = this['element'].attr('name');
		if (url == "" || url == undefined) {
			alert('Please specify url');
			return false;
		}
		if (url.indexOf('?') > -1) {
			url = url + "&" + name + "=" + escape(val);
		} else {
			url = url + '?' + name + "=" + escape(val);
		}
		validator.removeErr(this['element']);
		this['element'].parent('*').find(
				'.' + validator.errorTip + ',.' + validator.validTip).remove();

		var s = $.ajax({
			type : method,
			url : url,
			data : {},
			cache : false,
			async : false,
			success : function(data) {
				data = data.replace(/(^\s*)|(\s*$)/g, "");
				if (data != 'success') {
					errmsg = errmsg == "" ? data : errmsg;
					(type != 'checkbox' && type != 'radio' && element
							.addClass(validator.errorInput));

					if (msgid.length > 0) {
						msgid.removeClass(validator.validTip).addClass(
								validator.errorTip).html(errmsg);
					} else {
						jQuery(
								"<span class='" + validator.errorTip
										+ "'>&nbsp;&nbsp;&nbsp;</span>").html(
								errmsg).insertAfter(element);
					}
					return false;
				}

				if (data == 'success') {
					if (msgid.length > 0) {
						msgid.removeClass(validator.errorTip).addClass(
								validator.validTip).html('&nbsp;&nbsp;&nbsp;');
					} else {
						jQuery(
								"<span class='" + validator.validTip
										+ "'>&nbsp;&nbsp;&nbsp;</span>")
								.insertAfter(element);
					}
					return true;
				}
			}
		}).responseText;
		s = s.replace(/(^\s*)|(\s*$)/g, "");
		return s == 'success' ? true : false;
	}
};

validator.getDefultMsg = function(datatype) {
	var obj = this['element'];
	switch (datatype) {
	case "require":
		return "不能为空";
	case "hasnotnull":
		return "不能有空格";
	case "replaceStr":
		return "不能是替代符@E @N @I";
	case "email":
		return "电子邮件地址格式错误";
	case "phone":
		return "电话号码格式错误";
	case "mobile":
		return "手机号码格式错误";
	case "telno":
		return "电话或手机号码格式错误";
	case "url":
		return "地址格式错误";
	case "idCard":
		return "身份证号码格式错误";
	case "currency":
		return "货币格式错误";
	case "number":
		return "请输入正整数";
	case "zip":
		return "邮政编码格式错误";
	case "ip":
		return "IP地址格式错误";
	case "qq":
		return "QQ号码格式错误";
	case "integer":
		return "请输入整数";
	case "double":
		return "请输入数字";
	case "english":
		return "只能输入英文字母";
	case "chinese":
		return "只能输入汉字";
	case "userName":
		return "只能输入数字及字母组合的字符串)";
		// case "isSafe" : return "不能包含! # < > ? * $ + - =@ % . * { } ( ) | \ /
		// ~ ^等字符";
	case "safeString":
		return "不能包含？！$ % ^*";
	case "limit_min":
		return "长度不能小于" + obj.attr('min')+"字节";
	case "limit_max":
		return "长度不能大于" + obj.attr('max')+"字节";
	case "limit":
		return "长度不能小于" + obj.attr('min') + "字节且不能大于" + obj.attr('max')+"字节";
	case "limitB":
		return "请输入" + obj.attr('min') + "至" + obj.attr('max') + "位字符串";
	case "date":
		return "日期格式错误";
	case "repeat":
		return "与上次输入的密码不同";
	case "range":
		return "请输入" + obj.attr('min') + "到" + obj.attr('max') + "之间的数字";
	case "compare":
		return "请输入" + obj.attr('compare') + "的数";
	case "group":
		return "必须选中" + obj.attr('min') + "至" + obj.attr('max') + "个选项";
	default:
		return '格式错误';

	}
}

// 错误信息展示
validator.showErr = function(element, errindex) {
	var str_errmsg = element.attr('msg') || 'unkonwn';

	var datatype = element.attr('datatype');
	if (str_errmsg == 'unkonwn') {
		var datatypes = datatype.split('|');
		var errmsgs = '';
		for (var i = 0; i < datatypes.length; i++) {
			var msg = validator.getDefultMsg(datatypes[i]);

			if (i == 0) {
				errmsgs += msg;
			} else {
				errmsgs += '|' + msg;
			}
		}
		str_errmsg = errmsgs;
	}

	var arr_errmsg = str_errmsg.split('|');
	var errmsg = arr_errmsg[errindex] ? arr_errmsg[errindex] : arr_errmsg[0];

	if (errmsg == 'unkonwn') {

		errmsg = validator.getDefultMsg(datatype);
	}

	var msgid = jQuery('#' + element.attr('msgid'));
	var type = element.attr('type');
	(type != 'checkbox' && type != 'radio' && element
			.addClass(this['errorInput']));

	// var tagName=element.attr('name');
	// if(tagName=="tcit"){
	// alert(errmsg+msgid);
	//
	// }

	if (msgid.length > 0) {
		// msgid.removeClass(this['validTip']).addClass(this['errorTip']).html(errmsg);
		validator.removeErr(msgid);
		jQuery(
				"<span class='" + this['errorTip']
						+ "'>&nbsp;&nbsp;&nbsp;</span>").html(errmsg)
				.insertAfter(msgid);
	} else {
		validator.removeErr(element);
		jQuery(
				"<span class='" + this['errorTip']
						+ "'>&nbsp;&nbsp;&nbsp;</span>").html(errmsg)
				.insertAfter(element);
	}
	return false;
}
// 移除验证对象后面的提示信息
validator.removeErr = function(element) {
	// element.parent('*').find('.'+this['errorTip']).remove();
	// element.parent('*').find('.'+validator.errorTip+',.'+validator.validTip).remove();
	var span = element.next('span');
	if (span) {
		span.remove();
	}
	element.removeClass(validator.errorInput);
}

validator.checkajax = function(element, datatype, errindex) {
	var value = jQuery.trim(element.val());
	this['element'] = element;
	this['errindex'] = errindex;
	validator.removeErr(element);
	return eval(this[datatype]);
}

validator.checkDatatype = function(element, datatype) {
	// var value=jQuery.trim(element.val());
	var value = element.val(); // alert(element.attr('name'));
								// alert("value::::::"+value);
	if (element)
		// alert("value::::"+document.forms[0].tstp.value);
		this['element'] = element;

	// validator.removeErr(element);
	switch (datatype) {
	case "idCard":
	case "date":
	case "repeat":
	case "range":
	case "compare":
	case "custom":
	case "group":
	case "limit":
	case "limit_min":
	case "limit_max":
	case "limitB":
	case "safeString":
	case "filter":
	case "hasnotnull":
	case "futureDate":	
	case "pastDate":
	case "date_8":
	case "numLen":
	case "cgb_fuction":
		return eval(this[datatype]);
	    break;    
	case "require":
		return this[datatype].test(value);
		break;
		
	default: // alert(this[datatype].test(value)+this[datatype]+value);

		if (value != "") {
			return this[datatype].test(value);
		} else {
			return true;
		}

		break;
	}
}

// 检查是否需要校验
validator.check = function(obj) {

	validator.removeErr(obj);
	var datatype = obj.attr('datatype');
	// var value = jQuery.trim(obj.val());
	var value = obj.val();

	if (typeof (datatype) == "undefined")
		return true;

	if (obj.attr('require') != "true" && value == "")
		return true;

	var datatypes = datatype.split('|');
	var isValid = true;

	jQuery.each(datatypes, function(index, type) {
		if (typeof (validator[type]) == "undefined") {
			isValid = false;
			return false;
		}

		// ajax validate
		if (type == 'ajax')
			return isValid = validator.checkajax(obj, type, index);

		if (validator.checkDatatype(obj, type) == false) {
			obj.addClass(validator.errorInput);

			validator.showErr(obj, index);
			return isValid = false;
		} else { // validate success
			// validator.showErr(obj, index);
			// obj.removeClass(validator.errorInput);
			var msgid = jQuery('#' + obj.attr('msgid'));
			if (msgid.length > 0) {
				// msgid.removeClass(validator.errorTip).addClass(validator.validTip).html('&nbsp;&nbsp;');
				validator.removeErr(msgid);
				jQuery(
						'<span class="' + validator.validTip
								+ '">&nbsp;&nbsp;&nbsp;&nbsp;</span>')
						.insertAfter(msgid);
			} else {
				// 取父标签的下面所有的正确和错误标志并删除
				// obj.parent('*').find('.'+validator.errorTip+',.'+validator.validTip).remove();
				// 删除验证对象后面的验证提示
				validator.removeErr(obj);
				//附加验证通过后的绿色图标
				//jQuery('<span class="' + validator.validTip+ '">&nbsp;&nbsp;&nbsp;&nbsp;</span>').insertAfter(obj);
			}
		}
	});
	return isValid;
}

// 验证所有返回true 所有都验证通过 false 有未验证的
jQuery.fn.validateAll = function() {
	var form = jQuery(this);
	var elements = form.find(':input[require]');
	var isValid = true;
	var errIndex = new Array();
	var n = 0;
	elements.blur(function(index) {
		return validator.check(jQuery(this));
	});
	elements.each(function(i) { // alert("222:::"+jQuery(this).attr("name"));
		if (validator.check(jQuery(this)) == false) {
			isValid = false;
			errIndex[n++] = i;
		}
		;
	});

	if (isValid == false) {
		elements.eq(errIndex[0]).focus().select();
	}

	return isValid;

}

// 查询页面调这个
jQuery.fn.checkFormSearch = function() {
	var form = jQuery(this);
	var elements = form.find(':input[require]');
	elements.blur(function(index) {
		return validator.check(jQuery(this));
	});

	form.submit(function() {
		return jQuery(this).isValid();
	});
}

//取得验证的状态
jQuery.fn.isValid = function() {

	var form = jQuery(this);
	var elements = form.find('.' + validator.errorTip);

	if (elements.length > 0) {
		return false;
	} else {
		return true;
	}
}