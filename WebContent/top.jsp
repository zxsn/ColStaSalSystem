<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>高校职工基本工资管理系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript">
		
		function logout() {
		alert("确认注销?");
		top.location.href="logout";
		}
		
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
	</head>
	<body>

		<div class="top">
			<div class="span4">
				 <!-- <img src="img/logo.gif" alt="" width="381" height="130"> --> 
			</div>
			<div class="span6">
				
					<h2 class="title" style="margin: 30px;">高校职工基本工资管理系统</h2>
				
			</div>
			<div class="span4 offset1" style="margin-left:180px;">
				<div class="pull-right user">
					<span class="label label-success">当前用户</span>	
					<span class="label label-info"><s:property value="#session.employeeLogin.name"/>(<s:property value="#session.employeeLogin.id"/>)</span>
					<br/>
					<div class="btn-group user-btn">
					  <a class="btn btn-primary" onclick="logout()"><i class="icon-user icon-white"></i> 注销</a>
					  <ul class="dropdown-menu">
					    <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
					    <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
					    <li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>
					    <li class="divider"></li>
					    <li><a href="#"><i class="i"></i> Make admin</a></li>
					  </ul>
					</div>
				</div>
			</div>

			<div style="height:100%;clear:both;"></div>

		</div>

	</body>
</html>
