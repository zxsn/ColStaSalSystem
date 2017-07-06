<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资生成列表</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="css/AnnualBonus.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>
	";

		if (nid == "null" || nid == "") {
			window.location.href = "login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
</head>
<body onload="checkLogin()">
	<div class="container" style="height: 100%;">
		<h2 style="text-align: center;">月工资生成列表</h2>

		<table width="85%" border="0px" align="center" cellpadding="0"
			cellspacing="0" style="margin-bottom: 10%;">
			<tr>
				<td height="40">
					<table width="100%" border="0" cellpadding="4" cellspacing="1"
						bgcolor="#000000" class="newfont03">
						<tr class="CTitle" bgcolor="#CAE1FF">
							<td height="22" colspan="7" align="center"
								style="font-size: 16px;"></td>
						</tr>
						<tr bgcolor="#EEEEEE">
							<td width="15%">职工号</td>
							<td width="15%">姓名</td>
							<td width="15%">单位</td>
							<td width="15%">岗位工资</td>
							<td width="15%">薪级工资</td>
							<td width="10%">月薪</td>
							<td width="15%">时间</td>
						</tr>
						<s:iterator id="salaryList" value="#session.newSalaryList">
							<tr bgcolor="#EEEEEE">

								<td width="10%"><s:property value="#salaryList.eid" /></td>
								<td width="10%"><s:property value="#salaryList.name" /></td>
								<td width="10%"><s:property value="#salaryList.department" /></td>
								<td width="10%"><s:property
										value="#salaryList.positionSalary" /></td>
								<td width="10%"><s:property value="#salaryList.levelSalary" /></td>
								<td width="10%"><s:property value="#salaryList.salary" /></td>
								<td width="10%"><s:date name="#salaryList.date"
										format="yyyy-MM-dd" /></td>
							</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>
		<div style="text-align: center;">
			<a class="btn btn-primary" href="<s:url action="exportSalary"/>">导出</a>
		</div>
	</div>
</body>
</html>