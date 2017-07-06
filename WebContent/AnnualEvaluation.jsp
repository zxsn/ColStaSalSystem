<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>年终考核优秀奖金</title>

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
</script>

</head>
<body>
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

	</div>


	<s:form id="queryForm">

		<div class="top" style="margin-left:-4%;" align="center">
			
			<button type="button" style="margin-bottom:10px;"
				class="btn btn-success" onclick="getFinalBonus()">查询</button>

		</div>
	</s:form>

	<table width="85%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="40">
				<table width="100%" border="0" cellpadding="4" cellspacing="1"
					bgcolor="#000000" class="newfont03">
					<tr class="CTitle" bgcolor="#CAE1FF">
						<td height="22" colspan="7" align="center"
							style="font-size:16px; "></td>
					</tr>
					<tr bgcolor="#EEEEEE">
						<td width="10%">姓名</td>
						<td width="10%">职工号</td>
						<td width="10%">单位</td>
						<td width="10%">考核结果</td>
						<td width="10%">岗位工资</td>
						<td width="10%">薪级工资</td>
						<td width="10%">发放金额</td>
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
