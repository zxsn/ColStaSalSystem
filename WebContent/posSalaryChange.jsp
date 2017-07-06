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
		function modifyPosSalaryStandard() {
			var mainDocument=window.top.document.getElementById("mainFrame").contentWindow.document;
			var myform=mainDocument.getElementById("myform");
			myform.action="salaryStandard/modifyPosSalaryStandard_showSalaryStandard";
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
	    <span style="font-size:22px; font-weight:bold;">请输入修改后的工资标准：</span>	<br/>	
	    <div style="margin-left:-50px;"> 
		<s:textfield style="display:none" name="tableName" value="%{#session.tableName}"/><br />
		<s:textfield style="display:none" name="type" value="%{#session.type}"/><br />
		岗位：<s:textfield name="position" value="%{#session.position}"/><br />
		级数：<s:textfield name="level" value="%{#session.level}"/><br />
		<span style="margin-left:-35px;">工资标准：</span><s:textfield name="salaryStandard" value="%{#session.salaryStandard}"/><br />
		<span style="margin-left:-35px;">起点薪级：</span><s:textfield name="startPayLevel" value="%{#session.startPayLevel}"/><br />
		<button type="button" class="btn btn-success" onclick="modifyPosSalaryStandard()">修改</button>
		</div>
	</s:form>
</body>
</html>