<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>高校职工基本工资管理系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap/css/datepicker.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		var type = "<%=session.getAttribute("user.userType")%>";
		if (nid == "null" || nid == "") {
			alert("请先登录！");			
			window.location.href="login.jsp";	
		}
		else if (type != "1" && type != 1) {
			alert("您不是管理员！无法进入！");			
			window.location.href="login.jsp";	
		}
	}
	checkLogin();
</script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/liveValidation.js"></script>
<script type="text/javascript" src="js/employee.js"></script>
</head>

<frameset rows="110,*" cols="*" style="border: 1px;" frameborder="0">
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize"
		id="topFrame" title="topFrame" />
	<frameset cols="300,*" border="3">
		<frame src="left.jsp" name="leftFrame" noresize="noresize"
			id="leftFrame" title="leftFrame" />
		<frame name="mainFrame" noresize="noresize" id="mainFrame"
			title="mainFrame" />
	</frameset>
</frameset>


</html>
