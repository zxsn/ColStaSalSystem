<%@page import="javax.print.DocFlavor.INPUT_STREAM"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function checkEmployee()
	{
		var myform=document.forms[0];
		myform.action="employee/getEmployeeInfo_DisplayEmployeeInfo";
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
	用户名：<input type="text" name="employee.id" /><br />		
	<input type="button" name="btncheck" onclick="checkEmployee()" value="查询" /><br />
 </form>
</body>
</html>