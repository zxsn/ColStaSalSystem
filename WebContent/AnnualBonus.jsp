<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>年终奖</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/AnnualBonus.css">

<script type="text/javascript">

	function getFinalBonus() {
		var myform = document.getElementById("queryForm");
		myform.action = "bonus/getSalaryResult_AnnualBonus";
		myform.method = "post";
		myform.submit();
	}
	

	function succeed(){
	    alert("导入成功！");
	}

	function setType() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
		
 		var result = "<%=session.getAttribute("type")%>";
		if( result!=null) {
	 	  $("#type").find("option[value='"+result+"']").attr("selected",true);     
	 	}
	}
     

</script>
 
</head>
<body onload="setType()">
	<div class="inputfile">
		<s:form style="text-align:center;"
			action="bonus/importTestResult_AnnualBonus" method="post"
			enctype="multipart/form-data" role="form">
			<div style="margin-left:-2.5%;">
				<input type="file" title="选择文件" name="testResultFile"
					label="testResultFile"
					class="file-input-wrapper btn btn-default btn-primary" />

				<button type="submit" class="btn btn-success" onclick="succeed()">导入考核结果</button>
			</div>
		</s:form>

		<s:form style="text-align:center;"
			action="bonus/importOffInfoResult_AnnualBonus" method="post"
			enctype="multipart/form-data" role="form">
			<div>
				<input type="file" title="选择文件" name="offInfoFile"
					label="offInfoFile"
					class="file-input-wrapper btn btn-default btn-primary" />
				<button type="submit" class="btn btn-success" onclick="succeed()">导入请假出国信息</button>
			</div>
		</s:form>
	</div>


	<s:form id="queryForm">
		<div class="top" align="center">
			<select id="type" name="type" >
				<option value="不发">不发放双薪</option>
				<option value="全部双薪">全部双薪</option>
				<option value="部分双薪">部分双薪</option>
			</select>
			<button type="button" style="margin-bottom:10px;"
				class="btn btn-success" onclick="getFinalBonus()">查询</button>

		</div>
	</s:form>

	<table width="85%" border="0" align="center" cellpadding="0"
		cellspacing="0" style="margin-bottom:10%;">
		<tr>
			<td height="40">
				<table width="100%" border="0" cellpadding="4" cellspacing="1"
					bgcolor="#EEEEEE" class="newfont03">
					<tr class="CTitle" bgcolor="#CAE1FF">
						<td height="22" colspan="7" align="center"
							style="font-size:16px; "></td>
					</tr>
					<tr bgcolor="#EEEEEE">
						<td width="10%">职工号</td>
						<td width="10%">双薪基数</td>
						<td width="10%">双薪类型</td>
						<td width="10%">部分双薪原因</td>
						<td width="10%">双薪月数</td>
						<td width="10%">时间</td>
					</tr>
					<s:iterator id="result" value="#session.result">
						<tr bgcolor="#EEEEEE">
							<td width="10%"><s:property value="#result.eId" /></td>
							<td width="10%"><s:property value="#result.basis" /></td>
							<td width="10%"><s:property value="#result.doubleSalaryType" />
							</td>
							<td width="10%"><s:property value="#result.cutReason" /></td>
							<td width="10%"><s:property value="#result.months" /></td>
							<td width="10%"><s:property value="#result.year" /></td>
						</tr>
					</s:iterator>
					<%session.removeAttribute("result"); %>
				</table>
			</td>
		</tr>
	</table>
</body>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script>
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
</script>
</html>
