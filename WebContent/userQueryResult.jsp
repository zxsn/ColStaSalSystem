<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%Integer i = 1; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>高校教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<link rel="stylesheet" href="bootstrap/css/datepicker.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
		<script type="text/javascript">		
			function checkLogin() {
				var nid = "<%=session.getAttribute("user.id")%>";
				
				if (nid == "null" || nid == "") {			
					window.location.href="login.jsp";
					$(".alert").alert("请先登录！");
				}
			}
			function userSalaryQuery()
			{
				var myform=document.forms[0];
				myform.action="salaryQuery/userSalaryQuery";
				myform.method="post";
				myform.submit();
			}
		</script>
</head>
<body onload="checkLogin()">
	<div class="container" style="text-align:center;">
	<h3><font color="#CCFFFF">查询结果</font></h3>
	<table class="table table-bordered" width="40%">
	<thead>
		<tr>
			<th></th>
			<th>职工号</th>
			<th>岗位工资</th>
			<th>薪级工资</th>
			<th>本月工资总额</th>
			<th>发放日期</th>
		</tr>
	</thead>
	 
	<tbody>
	<s:iterator value="#session.salaryList" id="salary"> 
		<tr>
		<td><%out.print(i++);%></td>
		<td><s:property value="#salary.eid"/></td>
		<td><s:property value="#salary.positionSalary"/></td>
		<td><s:property value="#salary.levelSalary"/></td>
		<td><s:property value="#salary.totleSalary"/></td>
		<td><s:date name="#salary.time" format="yyyy-MM-dd" /></td>
		</tr>
		</s:iterator>
		<tr>
			<td>总额</td>
			<td></td>
			<td><s:property value="#session.totalPosition"/></td>
			<td><s:property value="#session.totalLevel"/></td>
			<td><s:property value="#session.totalAmount"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td>平均额</td>
			<td></td>
			<td><s:property value="#session.averagePosition"/></td>
			<td><s:property value="#session.averageLevel"/></td>
			<td><s:property value="#session.averageAmount"/></td>
			<td></td>
		</tr>
	 </tbody>
	</table>
	</div>
</body>
</html>