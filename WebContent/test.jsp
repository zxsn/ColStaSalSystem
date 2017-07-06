<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function computeSalary()
	{
		var myform=document.forms[0];
		myform.action="manage/computeSalary_showSalary";
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
	
	级别：<input type="text" name="level" /><br />
	任职年限：<input type="text" name="off" /><br />
	套改年限：<input type="text" name="cha" /><br />
	<input type="button" name="btnadd" onclick="computeSalary()" value="算出工资" />
 </form>
</body>
</html>