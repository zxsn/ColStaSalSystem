<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>高校教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
		<script type="text/javascript">
		//var myfrom=document.getElementById("myform1");
		function showError() {
			var innerInfo = "<%=session.getAttribute("innerInfo")%>";
			<%session.removeAttribute("innerInfo");%>
			if (innerInfo != "null" && innerInfo != "" && innerInfo != null) {
					alert(innerInfo);
				}

			}

			showError();

			function exportExcel() {
				var myform = document.forms[0];
				myform.action = "change/InfoExport_campusmobilization";
				myform.method = "post";
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
	<div class="container" style="text-align:center;width:90%；margin-top:25px;">
		<form class="form-horizontal">
		<h2><font color="blue">校内工资变动</font></h2>
		<table border="1px" bordercolor="grey" width="100%" cellspacing="0"style="border:1px;">
				<thead>
				<tr>
				<th width="10%"> 职工号</th> 
				<th width="10%"> 姓名</th> 
				<th width="20%"> 新单位名称</th> 
				<th width="20%"> 原单位名称</th> 
				<th width="20%"> 变更依据</th> 
				<th width="20%"> 备注</th> 
				</tr>
				</thead>
				
				<tbody>
				 
				 
				<tr>
				<td><input name="departmentChange.eId" type="text" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"/></td>
				<td><input name="departmentChange.name" type="text" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"/></td>
				<td><input name="departmentChange.newDepartment" type="text" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"/></td>
				<td><input name="departmentChange.oldDepartment" type="text" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"/></td>
				<td><input name="departmentChange.according" type="text" value="填写变更依据" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"
				onfocus="this.value=''" /></td>
				<td><input name="departmentChange.note" type="text" value="填写备注" style="width:99%;padding-left:0px;padding-right:0px;border: 1px none #CCCCCC;"
				onfocus="this.value=''" /></td>
			    </tr>
			    </tbody>
				 
			</table>
			<div style="margin-top:10px">
			<input class="btn btn-success" type="button" value="导出" onclick="exportExcel()"/>
			</div>
		</form>
	</div>
</body>
</html>