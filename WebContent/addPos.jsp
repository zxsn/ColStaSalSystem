<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	function addPos()
	{
		var myform=document.forms[0];
		myform.action="manage/addPos_chooseFun";
		myform.method="post";
		myform.submit();
	}
	
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";

		if (nid == "null" || nid == "") {
			window.location.href = "login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
</head>
<body onload="checkLogin()">
<form id="myform1" >
	级别：<input type="text" name="managePositionSalary.level" /><br />
	岗位：<input type="text" name="managePositionSalary.position" /><br />
	工资标准：<input type="text" name="managePositionSalary.salaryStandard" /><br />
	起点薪级：<input type="text" name="managePositionSalary.startPayLevel" /><br />
	<input type="button" name="btnadd" onclick="addPos()" value="确定" />
 </form>
</body>
</html>