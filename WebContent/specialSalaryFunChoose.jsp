<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>特殊情况工资变动</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
<script type="text/javascript">
	function specialSalaryChange()
	{
		var myform=document.getElementById("form1");
		myform.action="specialSalary/specialSalaryChange";
		myform.method="post";
		myform.submit();
	}
	
	function specialSalaryRecovery()
	{
		var myform=document.getElementById("form2");
		myform.action="specialSalary/specialSalaryRecovery";
		myform.method="post";
		myform.submit();
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
<body onload="checkLogin()">
	<br />
	<!-- <a href="specialSalaryChange.jsp">特殊工资变动</a><br /><br />
	<a href="specialSalaryRecovery.jsp">特殊工资恢复</a>-->
	<div class="container">
	<h2>特殊情况工资变动</h2>
	<hr/>
	<form id="form1">
	    <div class="control-group">
		职工号：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="specialSalaryChange.eId"/>
		</div>
		
		<!--
		 <div class="control-group">
		姓名：<input type="text" name=""/>
		</div>
		
		 <div class="control-group">
		单位：<input type="text" name=""/>
		</div>
		-->
		
		<div class="control-group">
		工资变动幅度<br/>(负数代表减薪)：<input type="text" name="specialSalaryChange.amount" />
		</div>
		
		<div class="control-group">
		变动原因：<input type="text" name="specialSalaryChange.reason"/>
		</div>
		
		<!-- 
		 <div class="control-group">
		修改时间：<input type="text" name=""/>
		</div>
		 -->
		
		<div class="control-group">
			<input class="btn btn-primary" style="width:60px;" name="btnchange" onclick="specialSalaryChange()" value="确定" />
		</div>
	</form>
	</div>
	<hr/>

	<div class="container">
	<form id="form2">
		<h2>特殊情况工资恢复</h2>
		<div class="control-group">
		职工号：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="specialSalaryRecovery.eId" />
		</div>
		
		<!--  
	    <div class="control-group">
		姓名：<input type="text" name=""/>
		</div>
		
		 <div class="control-group">
		单位：<input type="text" name=""/>
		</div>
		-->
		
		<div class="control-group">
		恢复原因：<input type="text" name="specialSalaryRecovery.recoveryReason"/>
		</div>
		
		<!--  
		 <div class="control-group">
		修改时间：<input type="text" name=""/>
		</div>
		-->
		
		<div class="control-group">
			<input class="btn btn-primary" style="width:60px;" name="btnRecovery" onclick="specialSalaryRecovery()" value="确定" />
		</div>
	</form>
    </div>
</body>
</html>