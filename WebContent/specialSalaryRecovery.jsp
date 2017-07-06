<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
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
	 <form>
	 <h2>特殊情况工资恢复人员列表</h2>
	 <table class="table table-bordered">
	 	<thead>
	 	<tr>
	 		<th>职工号</th>
	 		<th>姓名</th>
	 		<th>单位</th>
	 		<th>修改原因</th>
	 		<th>修改时间</th>
	 	</tr>
	 	</thead>
	 	
	 	<tbody>
	 	<s:iterator value="#session.infoRecovery" id="recovery">
				 <tr>
				 <td><s:property value="#recovery.eid"/></td>
				 <td><s:property value="#recovery.name"/></td>
				 <td><s:property value="#recovery.departmet"/></td>
				 <td><s:property value="#recovery.reason"/></td>
				 <td><s:date name="#recovery.date" format="yyyy-MM-dd hh-mm-ss"/></td>
				 </tr>
				</s:iterator>
	 	</tbody>
	 </table>
	 <div class="container" align="center">
	 	<a class="btn btn-primary"  href="<s:url action="specialSalary/exportRecovery"/>" >导出</a>
	 </div>
	 </form>
</body>
</html>