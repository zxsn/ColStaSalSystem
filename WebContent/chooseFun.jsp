<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	function addCha()
	{
		top.location='addCha.jsp'; 
	}
	function addPay()
	{
		top.location='addPay.jsp'; 
	}
	function addPos()
	{
		top.location='addPos.jsp'; 
	}
	function changeToTest()
	{
		top.location='test.jsp'; 
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
	<input type="button" name="btnaddCha" onclick="addCha()" value="添加套改记录" /><br />
	<input type="button" name="btnaddPay" onclick="addPay()" value="添加薪级对应" /><br />
	<input type="button" name="btnaddPos" onclick="addPos()" value="添加岗位" /><br />
	<input type="button" name="btnCom" onclick="changeToTest()" value="计算工资" /><br />
 </form>
</body>
</html>