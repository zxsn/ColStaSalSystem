<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自动生成工资</title>
<script type="text/javascript">
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
  		<a href="autoSalary">自动生成工资</a>
</body>
</html>