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
<title>医护添加</title>
</head>
<body id="right">
<div class="operation o-h bg-f8">
	<div class="operationLeft f-l"><font style="margin-left:10px;font-size:14px; font-weight:bold; text-indent:14px; letter-spacing:2px;">医护添加</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:history.back();" style="margin-left:100px;"><i class="iconfont">&#xe681;</i>返回列表</a></div>
	<div class="operationRight f-r">
	</div>
</div>
<form id="commonForm" action="/emDoctor.do?method=add" method="post">
	<table class="tform">
<tr>
<td width="120" class="right">医户名称：</td>
<td><input type="text" id="doctorname" name="doctorname" value="" size=50></td>
</tr>
<tr>
<td width="120" class="right">手机：</td>
<td><input type="text" id="mobile" name="mobile" value="" size=50></td>
</tr>
<tr>
<td width="120" class="right">所属公司（医院）：</td>
<td><select name="companyid">
<c:if test="${not empty companyList}">
<c:forEach var="listItem" items="${companyList}" varStatus="idx">
	<option value="${listItem.companyid}">${listItem.companyname}</option>
</c:forEach>
</c:if>
</select></td>
</tr>
<tr>
<td width="120" class="right">医护类别：</td>
<td><select name="doctortypeid">
<c:if test="${not empty doctortypeList}">
<c:forEach var="listItem" items="${doctortypeList}" varStatus="idx">
	<option value="${listItem.doctortypeid}">${listItem.doctortypename}</option>
</c:forEach>
</c:if>
</select></td>
</tr>
<tr>
<td width="120" class="right">科室：</td>
<td><select name="specialtyid">
<c:if test="${not empty specialtyList}">
<c:forEach var="listItem" items="${specialtyList}" varStatus="idx">
	<option value="${listItem.specialtyid}">${listItem.specialtyname}</option>
</c:forEach>
</c:if>
</select></td>
</tr>
<tr>
<td width="120" class="right">专长：</td>
<td><input type="text" id="expert" name="expert" value="" size=50></td>
</tr>
<tr>
<td width="120" class="right">简介：</td>
<td><input type="text" id="note" name="note" value="" size=50></td>
</tr>
<tr>
<td width="120" class="right">照片：</td>
<td><a class="mya" href="javascript:f_photo0.click();"><img id="imgphoto0" src="/resources/images/folder2.png"></a></td>
</tr>
<tr>
<td width="120" class="right">价格：</td>
<td><input type="text" id="price" name="price" value="" size=50></td>
</tr>
<tr>
<td width="120" class="right">顺序号：</td>
<td><input type="text" id="seq" name="seq" value="1000" size=50></td>
</tr>

		<tr>
			<td colspan="2">
<input type="hidden" id="photo0" name="photo0"/>
				<input id="uf_parentid" name="uf_parentid" type="hidden" value="${uf_parentid}"/>
				<input id="keyword" name="keyword" type="hidden" value="${keyword}"/>
				<input id="m" name="m" type="hidden" value="${m}"/>
				<input id="s" name="s" type="hidden" value="${s}"/>
				<input type="button" class="btn1" value=" 提  交 " onclick="checkf()"/>
			</td>
		</tr>
	</table>
</form>
<input type="file" id="f_photo0" name="f_photo0" onchange='_compress(this,$("#photo0"),$("#imgphoto0"));' style="width:0px;"/>
</body>
</html>
<script language=javascript>
function checkf() {
	if(commonForm.doctorname.value=="") {alert("请正确输入医户名称！");return false;}
	if(commonForm.mobile.value=="") {alert("请正确输入手机！");return false;}
	if(commonForm.price.value=="" || commonForm.price.value!="" && !(is_float(commonForm.price.value) || is_int(commonForm.price.value))) {alert("请正确输入价格！");return false;}
	if(commonForm.seq.value=="" || commonForm.seq.value!="" && !is_int(commonForm.seq.value)) {alert("请正确输入顺序号！");return false;}

	document.getElementById("commonForm").submit() ;
  
}


</script>