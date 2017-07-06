<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>工资计算公式</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<style type="text/css">
.left {
	text-align: right;
	padding-right: 10px;
}
</style>
<script type="text/javascript">
		function initSalaryCompute()
		{
			var myform=document.forms[0];
			myform.action="initSalaryCompute/initSalaryCompute_salaryComputeFormula";
			myform.method="post";
			myform.submit();
			alert("设置成功!");
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


	<div class="container"
		style="margin-top: 20px; text-align: center; font-family: '宋体'">
		<div
			style="margin-top: 1%; font-size: 30px; font-weight: bold; text-align: center;">设置工资计算公式</div>
		<form id="myform" class="form-horizontal"
			style="margin-top: 5%; margin-left: -5%;">
			<table align="center">
				<tr>
					<td>地区差：</td>
					<td><input type="text" name="areaDifference" /></td>
				</tr>
				<tr>
					<td>岗位津贴：</td>
					<td><input type="text" name="positionAllowance" /></td>
				</tr>
				<tr>
					<td>教护补贴：</td>
					<td><input type="text" name="educationAllowance" /></td>
				</tr>
				<tr>
					<td>独生子女：</td>
					<td><input type="text" name="onlyChildAllowance" /></td>
				</tr>
				<tr>
					<td>特殊津贴(岗位加权)：</td>
					<td><input type="text" name="specialPositionParas" /></td>
				</tr>
				<tr>
					<td>特殊津贴(薪级加权)：</td>
					<td><input type="text" name="specialLevelParas" /></td>
				</tr>
				<tr>
					<td>其它补贴(岗位加权)：</td>
					<td><input type="text" name="otherPositionParas" />
					<td>
				</tr>
				<tr>
					<td>其它补贴(薪级加权)：</td>
					<td><input type="text" name="otherLevelParas" /></td>
				</tr>
				<tr>
					<td>电话补贴(岗位加权)：</td>
					<td><input type="text" name="phonePositionParam" /></td>
				</tr>
				<tr>
					<td>电话补贴(薪级加权)：</td>
					<td><input type="text" name="phoneLevelParam" /></td>
				</tr>
				<tr></tr>
			</table>
			<input type="button" name="btnOk" class="btn btn-success"
				onclick="initSalaryCompute()" value="确定" />
		</form>
	</div>
</body>
</html>