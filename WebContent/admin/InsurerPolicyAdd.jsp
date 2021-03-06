﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="/admin/style/base.css" />
<link type="text/css" rel="stylesheet" href="/admin/style/global.css" />
<link href="/resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/js/xheditor/xheditor-zh-cn.min.js"></script>
<script type="text/javascript">var root = "";</script>
<script type="text/javascript" src="/resources/js/admin.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/photo.js"></script>
<script type="text/javascript" src="/resources/js/My97DatePicker/config.js"></script>
<script type="text/javascript" src="/resources/js/My97DatePicker/lang/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/js/My97DatePicker/skin/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="/resources/js/My97DatePicker/skin/default/datepicker.css" />
<script type="text/javascript" src="/resources/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
input[type="text"]{min-width:50px;width:140px;}
</style>
<title>个人保单添加</title>
</head>
<body id="right">
<div class="operation o-h bg-f8">
	<div class="operationLeft f-l"><font style="margin-left:10px;font-size:14px; font-weight:bold; text-indent:14px; letter-spacing:2px;">个人保单添加</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:history.back();" style="margin-left:100px;"><i class="iconfont">&#xe681;</i>返回列表</a></div>
	<div class="operationRight f-r">
	</div>
</div>
<form id="commonForm" action="/emInsurerPolicy.do?method=add" method="post">
	<table class="tform">
<tr>
<td>团保方案：</td>
<td>
<select id="groupinsurancepolicyid" name="groupinsurancepolicyid">
<c:forEach items="${groupinsurancepolicyItems}" var="group">
<option value="${group.id }">${group.groupinsurancepolicyname }</option>
</c:forEach>
</select>
</td>
</tr>
</table>
<br/><br/>
<span>被保险人</span>
<table class="tform">
<tr>
<td>姓名：</td>
<td>性别：</td>
<td>证件类型：</td>
<td>身份证：</td>
<td>护照：</td>
</tr>
<tr>
<td><input type="text" id="insured.insuredname" name="insured.insuredname" value="${insured.insuredname }" size=50></td>
<td>
<select name="insured.gender" id="insured.gender" class="select100">
<option value="男" <c:if test="${insured.gender eq '男' }">selected="selected"</c:if>>男</option>
<option value="女" <c:if test="${insured.gender eq '女'}">selected="selected"</c:if>>女</option>
</select></td>
<td><input type="text" id="insured.idtype" name="insured.idtype" value="${insured.idtype }" size=50></td>
<td><input type="text" id="insured.idnumber" name="insured.idnumber" value="${insured.idnumber}" size=50></td>
<td><input type="text" id="insured.passport" name="insured.passport" value="${insured.passport }" size=50></td>
</tr>
<tr>
<td>出生年月：</td>
<td>工作单位：</td>
<td>工号：</td>
<td>工龄：</td>
<td>科室：</td>
</tr>
<tr>
<td><input type="text" id="insured.birthdate" name="insured.birthdate" readonly="readonly" value="${insured.birthdate_}" onclick="WdatePicker({maxDate:'2018-12-31', dateFmt:'yyyy-MM-dd'})" style="width: 70px;"/></td>
<td><input type="text" id="insured.employer" name="insured.employer" value="${insured.employer}" size=50></td>
<td><input type="text" id="insured.jobnumber" name="insured.jobnumber" value="${insured.jobnumber }" size=50></td>
<td><input type="text" id="insured.workage" name="insured.workage" value="${insured.workage}" size=50></td>
<td><input type="text" id="insured.title" name="insured.title" value="${insured.title }" size=50></td>
</tr>
<tr>
<td>人员类别：</td>
<td>年龄：</td>
<td>开户行省：</td>
<td>开户行市：</td>
<td>开户行支行：</td>
</tr>
<tr>
<td><input type="text" id="insured.insuredtype" name="insured.insuredtype" value="${insured.insuredtype}" size=50></td>
<td><input type="text" id="insured.age" name="insured.age" value="${insured.age }" size=50></td>
<td><input type="text" id="insured.bankprovince" name="insured.bankprovince" value="${insured.bankprovince }" size=50></td>
<td><input type="text" id="insured.bankcity" name="insured.bankcity" value="${insured.bankcity}" size=50></td>
<td><input type="text" id="insured.subbranch" name="insured.subbranch" value="${insured.subbranch }" size=50></td>
</tr>
<tr>
<td>银行账号：</td>
<td>开户行：</td>
<td>账户名：</td>
<td>电子邮件：</td>
<td>机构：</td>
</tr>
<tr>
<td><input type="text" id="insured.accountnumber" name="insured.accountnumber" value="${insured.accountnumber }" size=50></td>
<td><input type="text" id="insured.bankname" name="insured.bankname" value="${insured.bankname }" size=50></td>
<td><input type="text" id="insured.accountname" name="insured.accountname" value="${insured.accountname}" size=50></td>
<td><input type="text" id="insured.email" name="insured.email" value="${insured.email }" size=50></td>
<td><input type="text" id="insured.department" name="insured.department" value="${insured.department }" size=50></td>
</tr>
<tr>
<td  colspan="5">手机号：</td>
</tr>
<tr>
<td colspan="5"><input type="text" id="insured.mobile" name="insured.mobile" value="${insured.mobile }" size=50></td>
</tr>
</table>
<br/><br/>
<span>投保险种</span>
<table class="tform">
<tr>
<td>险种组：</td>
<td><select id="insurancegroupid" name="insurancegroupid"></select></td>
<td>险种：</td>
<td><select id="insuranceid" name="insuranceid"></select></td>
</tr>
<tr>
<td>保险编号：</td>
<td colspan="3"><input type="text" id="clientid" name="clientid" value="" size=50></td>
</tr>
<tr>
<td>保险期间（起）：</td>
<td><input type="text" id="periodbegin" name="periodbegin" readonly="readonly" value="" onclick="WdatePicker({maxDate:'2018-12-31', dateFmt:'yyyy-MM-dd'})" style="width: 70px;"/></td>
<td>保险期间（止）：</td>
<td><input type="text" id="periodend" name="periodend" readonly="readonly" value="" onclick="WdatePicker({maxDate:'2018-12-31', dateFmt:'yyyy-MM-dd'})" style="width: 70px;"/></td>
</tr>
<tr>
<td>保险状态：</td>
<td><select name="policystate" id="policystate" class="select100">
<option value="在保">在保</option>
<option value="停保">停保</option>
</select></td>
<td>医保状态：</td>
<td><input type="text" id="shistate" name="shistate" value="" size=50></td>
</tr>
<tr>
<td>医保地点：</td>
<td><input type="text" id="shiarea" name="shiarea" value="" size=50></td>
<td>工作地：</td>
<td><input type="text" id="joblocal" name="joblocal" value="" size=50></td>
</tr>
<tr>
<td>关系：</td>
<td><select name="relation" id="relation" class="select100">
<option value="雇员">雇员</option>
<option value="子女">子女</option>
<option value="员工">员工</option>
<option value="夫妻">夫妻</option>
<option value="配偶">配偶</option>
</select></td>
<td>雇员编号：</td>
<td><input type="text" id="jobnumber" name="jobnumber" value="" size=50></td>
</tr>
<tr>
<td>开户行：</td>
<td><input type="text" id="bankname" name="bankname" value="" size=50></td>
<td>账户名：</td>
<td><input type="text" id="accountname" name="accountname" value="" size=50></td>
</tr>
<tr>
<td>银行账号：</td>
<td colspan="3"><input type="text" id="accountnumber" name="accountnumber" value="" size=50></td>
</tr>
</table>
<table class="tform">

		<tr>
			<td colspan="2">

				<input id="uf_parentid" name="uf_parentid" type="hidden" value="${uf_parentid}"/>
				<input id="keyword" name="keyword" type="hidden" value="${keyword}"/>
				<input id="m" name="m" type="hidden" value="${m}"/>
				<input id="s" name="s" type="hidden" value="${s}"/>
				<input type="button" class="btn1" value=" 提  交 " onclick="checkf()"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>
<script language=javascript>
function checkf() {
	if($("#groupinsurancepolicyid").val() == "") {alert("请正确输入团保方案！");return false;}
	if($("#insurancegroupid").val()  == "") {alert("请正确输入险种组！");return false;}
	if($("#insuranceid").val()  == "") {alert("请正确输入险种！");return false;}

	if($("#insured.insuredname").val()  == "") {alert("请正确输入被保险人姓名！");return false;}
	if($("#insured.idnumber").val()  == "") {alert("请正确输入被保险人身份证！");return false;}
//	if($("#insured.passport").val()  == "") {alert("请正确输入被保险人护照！");return false;}
	if($("#insured.birthdate").val()  == "") {alert("请正确输入被保险人出生年月！");return false;}
//	if($("#insured.employer").val()  == "") {alert("请正确输入被保险人工作单位！");return false;}
//	if($("#insured.insuredname").val()  == "") {alert("请正确输入被保险人工号！");return false;}
//	if($("#insured.insuredname").val()  == "") {alert("请正确输入被保险人姓名！");return false;}
//if($("#insured.insuredname").val()  == "") {alert("请正确输入被保险人姓名！");return false;}
//	if($("#insured.insuredname").val()  == "") {alert("请正确输入被保险人姓名！");return false;}
	
	if(commonForm.periodbegin.value=="") {alert("请正确输入保险期间（起）！");return false;}
	if(commonForm.periodend.value=="") {alert("请正确输入保险期间（止）！");return false;}
	if(commonForm.policystate.value=="") {alert("请正确输入保险状态！");return false;}
	if(commonForm.shistate.value=="") {alert("请正确输入医保状态！");return false;}
	if(commonForm.shiarea.value=="") {alert("请正确输入医保地点！");return false;}
	if(commonForm.joblocal.value=="") {alert("请正确输入工作地！");return false;}
	if(commonForm.relation.value=="") {alert("请正确输入关系！");return false;}
	if(commonForm.jobnumber.value=="") {alert("请正确输入雇员编号！");return false;}
	if(commonForm.bankname.value=="") {alert("请正确输入开户行！");return false;}
	if(commonForm.accountname.value=="") {alert("请正确输入账户名！");return false;}
	if(commonForm.accountnumber.value=="") {alert("请正确输入银行账号！");return false;}
	if(commonForm.clientid.value=="") {alert("请正确输入保险编号！");return false;}

	document.getElementById("commonForm").submit() ;
  
}
$(function(){
	$("#groupinsurancepolicyid").change(function() {
		//险种
		var insuranceid = $("#insuranceid");
		insuranceid.empty();
		$("<option value=''></option>").val("").text("").appendTo(insuranceid);
		$.getJSON("/emInsurance.do?method=json&policyid=" + $(this).val(), function(result) {
			$.each(result, function(i, item) {
				$("<option></option>").val(item.id).text(item.insurancename).appendTo(insuranceid);
			});
		});
		//险种组
		var insurancegroupid = $("#insurancegroupid");
		insurancegroupid.empty();
		$("<option value=''></option>").appendTo(insurancegroupid);
		$.getJSON("/emInsuranceGroup.do?method=json&policyid=" + $(this).val(), function(result) {
			$.each(result, function(i, item) {
				$("<option></option>").val(item.id).text(item.insurancegroupname).appendTo(insurancegroupid);
			});
		});
	});
	$("#groupinsurancepolicyid").change();
});

</script>