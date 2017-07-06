<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%Integer i = 1; %>
<!DOCTYPE html >
<html>
<head>

<meta charset="UTF-8">
		<title>高校教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<link rel="stylesheet" href="bootstrap/css/datepicker.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
		<script type="text/javascript">
			$(function(){ 
			    $("#date_1").datepicker({
		    		format: 'yyyy-mm-dd',
		    	}); 
			}); 
			
			$(function(){ 
			    $("#date_2").datepicker({
		    		format: 'yyyy-mm-dd',
		    	}); 
			}); 
			
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
	
	<form class="form-horizontal">
	<div class="container" style="text-align:center; margin:0 auto;">
		<h3><font color="blue">请输入查询条件</font></h3>
		 <div class="row" style="text-align:center; margin:0 auto;">
			<div class="span6">
			<span>查询起始年月：</span><input type="text" name="startDate" id="date_1"/>
			</div>
			
			<div class="span5">
			<span>查询结束年月：</span><input type="text" name="endDate" id="date_2"/>
			</div>
		  </div>
		  
		 <div class="span12">
		 	<a class="btn btn-primary" onclick="userSalaryQuery()">查询</a>
		 </div>
		
	</div>
	<hr/>
	</form>
</body>
</html>