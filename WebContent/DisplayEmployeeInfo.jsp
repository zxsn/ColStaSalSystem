<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DisplayEmployeeInfo</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript">
	function findEmployee() {
			var topWin = window.top.document.getElementById("mainFrame").contentWindow;
			var myform1 = topWin.document.getElementById("myform1");
			myform1.action = "employee/getEmployeeInfo_DisplayEmployeeInfo";
			myform1.method = "post";
			myform1.submit();
		}
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
	
	function showError() {
		var resultInfo = "<%=session.getAttribute("resultInfo")%>";
		<%session.removeAttribute("resultInfo");%>
		if (resultInfo != "null" && resultInfo != "" && resultInfo != null) {			
				alert(resultInfo);
			}
	}

	showError();
</script>
</head>

<body onload="checkLogin()">
<br>
<s:form id="myform1" style="margin-left:300px; margin-bottom:-20px;" >
	<span style="font-weight:bold;">输入职工号：</span><input type="text" name="employee.id" id="input" style="margin-top:10px;" maxlength="6">
	<button type="button" class="btn btn-success" onclick="findEmployee()">查询</button>
</s:form>
<br>
<br>

<s:form id="myform" > 
<table style="width:90%; margin:0 auto; margin-bottom:50px;"class="table table-bordered table-hover" >
	<thead>
		<tr>
			<th>职工信息表</th>
		</tr>
	</thead>
	<tbody >
		<tr >
			<td style="width:40%;">职工号：</td> <td><s:property value="#session.eInfo.id"/></td>
		</tr>

		<tr>
			<td>姓名:</td> <td><s:property  value="#session.eInfo.name"/></td>
		</tr>

		<tr>
			<td>邮箱:</td> <td><s:property  value="#session.eInfo.email"/></td>
		</tr>

		<tr>
			<td>性别:</td> <td><s:property  value="#session.eInfo.gender"/> </td>
		</tr>

		<tr>
			<td>出生日期:</td> <td><s:date  name="#session.eInfo.birthday" format="yyyy-MM-dd"/></td>
		</tr>

		<tr>
			<td>身份证号:</td> <td><s:property  value="#session.eInfo.uid" /></td>
		</tr>

		<tr>
			<td>单位:</td> <td><s:property  value="#session.eInfo.department" /></td>
		</tr>

		<tr>
			<td>岗位性质:</td> <td><s:property  value="#session.eInfo.jobType" /></td>
		</tr>

		<tr>
			<td>人员身份:</td> <td><s:property  value="#session.eInfo.type" /></td>
		</tr>

		<tr>
			<td>进校来源:</td> <td><s:property  value="#session.eInfo.source" /></td>
		</tr>

		<tr>
			<td>入校报到时间:</td> <td><s:date  name="#session.eInfo.reachSchoolDate" format="yyyy-MM-dd"/></td>
		</tr>

		<tr>
			<td>最高学历:</td> <td><s:property  value="#session.eInfo.maxEducation" /></td>
		</tr>

		<tr>
			<td>最高学历获得时间:</td> <td><s:date  name="#session.eInfo.maxEducationDate" format="yyyy-MM-dd"/></td>
		</tr>

		<tr>
			<td>最高学位:</td> <td><s:property  value="#session.eInfo.maxDegree" /></td>
		</tr>

		<tr>
			<td>最高学位获得时间:</td> <td><s:date  name="#session.eInfo.maxDegreeDate" format="yyyy-MM-dd"/></td>
		</tr>

		<tr>
			<td>聘任职务:</td> <td><s:property  value="#session.eInfo.hireWork" /></td>
		</tr>

		<tr>
			<td>职务级别:</td> <td><s:property  value="#session.eInfo.workLevel" /></td>
		</tr>
		<tr>
			<td>任职时间:</td> <td><s:date  name="#session.eInfo.startWorkDate" format="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>聘任职称:</td> <td><s:property  value="#session.eInfo.hireTitle" /></td>
		</tr>
		<tr>
			<td>职称级别:</td> <td><s:property  value="#session.eInfo.titleLevel" /></td>
		</tr>
		<tr>
			<td>聘任时间:</td> <td><s:date  name="#session.eInfo.hireDate" format="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>（拟）聘任岗位:</td> <td><s:property  value="#session.eInfo.hireJob" /></td>
		</tr>
		<tr>
			<td>聘岗级别:</td> <td><s:property  value="#session.eInfo.jobLevel" /></td>
		</tr>
		
		<%session.removeAttribute("eInfo"); %>
	</tbody>
</table>
</s:form>

	
</body>
</html>