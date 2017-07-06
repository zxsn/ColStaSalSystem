<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" >
	<title>高校教职工工资系统</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript"> 
		function modifyLevSalaryStandard() {
			var mainDocument=window.top.document.getElementById("mainFrame").contentWindow.document;
			var myform=mainDocument.getElementById("myform");
			myform.action="salaryStandard/modifyLevSalaryStandard_showSalaryStandard";
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
	<s:form id="myform" style="text-align:center;">
	    <br/>
	    <span style="font-size:22px; font-weight:bold; ">请输入修改后工资标准：</span>	
		<div style="margin-left:-50px;">
		<s:textfield style="display:none" name="tableName" value="%{#session.tableName}"/><br />
		<s:textfield style="display:none" name="type" value="%{#session.type}"/><br />	
		薪级：<s:textfield name="payLevel" value="%{#session.payLevel}"/><br />
		<span style="margin-left:-35px;">工资标准：</span><s:textfield  name="payLevelSalaryStandard" value="%{#session.payLevelSalaryStandard}"/><br />
		
		<button type="button" class="btn btn-success" onclick="modifyLevSalaryStandard()">修改</button>
		</div>
	</s:form>
</body>
</html>