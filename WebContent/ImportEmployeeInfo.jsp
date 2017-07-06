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

<title>导入职工信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		if (nid == "null" || nid == "") {
			window.location.href = "login.jsp";
			alert("请先登录！");
		}
	}

	function showInfo() {
		var info = "<%=session.getAttribute("alertInfo")%>";
		<%session.removeAttribute("alertInfo");%>
		if (info != "null" && info != "") {
			alert(info);
		}
	}
	showInfo();
</script>
</head>

<body onload="checkLogin()">
	<s:form action="employee/importEmployeeInfo_ImportEmployeeInfo"
		method="post" enctype="multipart/form-data" role="form">
		<div
			style="margin-top:5%; font-size:30px; font-weight:bold; text-align:center;">职工信息批量导入</div>
		<div style="margin-left:40%; margin-top:5%; ">
			<input type="file" title="选择文件" name="employeeFile" label="excelFile"
				class="file-input-wrapper btn btn-default btn-primary" />
			<button type="submit" class="btn btn-success" onclick="succeed()">导入</button>
		</div>
	</s:form>

	<s:form name="EmployeeInfo">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="margin-top:30px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#000000" class="newfont03"
												style="background-color: #000000; border-collapse: separate; border-spacing: 1px;">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center"
														style="font-size:16px; ">职工基本信息</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">职工号</td>
													<td width="10%">姓名</td>
													<td width="10%">性别</td>
													<td width="10%">邮箱</td>
													<td width="10%">单位</td>
												</tr>

												<s:iterator id="employeeList" value="#session.employeeList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#employeeList.id" />
														</td>
														<td><s:property value="#employeeList.name" />
														</td>
														<td><s:property value="#employeeList.gender" />
														</td>
														<td><s:property value="#employeeList.email" />
														</td>
														<td><s:property value="#employeeList.department" />
														</td>
													</tr>
												</s:iterator>

											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>

	<%
		session.removeAttribute("employeeList");
	%>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script>
	$('input[type=file]').bootstrapFileInput();
	$('.file-inputs').bootstrapFileInput();
</script>
</html>
