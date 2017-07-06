<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校内调动</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//var myfrom=document.getElementById("myform1");
	
		function InnerChange()
		{
			var myform=document.forms[0];
			myform.action="change/SchoolInnerChange_success";
			myform.method="post";
			myform.submit();
		}
		
		function InfoExport()
		{
			var myform=document.forms[0];
			myform.action="change/InfoExport_success";
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
    <form id="myform1" >
    	职工号：<input type="text" name="departmentChange.eId"><br />
    	姓名：<input type="text" name="departmentChange.name"><br />
    	新单位名称：<input type="text" name="departmentChange.newDepartment"><br />
    	原单位名称：<input type="text" name="departmentChange.oldDepartment"><br />
    	变更依据：<input type="text" name="departmentChange.according"><br />
    	备注：	<input type="text" name="departmentChange.note"><br />
    	
		<input type="button" name="btnInnerChange" onclick="InnerChange()" value="确认" />
		<input type="button" name="btnExport" onclick="InfoExport()" value="导出" /><br />
 	</form>
  </body>
</html>
