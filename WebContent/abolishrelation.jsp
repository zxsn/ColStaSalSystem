<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>高校教职工工资系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
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
	<div class="container">
		<div class="rows">
			<div class="span4">
				<h2>
					<font color="blue">取消工资关系管理</font>
				</h2>
			</div>

			<div class="span3" style="margin-top:15px;">
				<form class="form-horizontal">
					<a class="btn btn-primary"><i class="icon-print"></i> 打印公司介绍信</a>
				</form>
			</div>
		</div>
	</div>
	<hr />


	<div class="container">
		<form class="form-horizontal">
			<fieldset>
				<table class="table table-bordered span9">
					<thead>
						<tr>
							<th>取消工资关系</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>姓名</td>
							<td></td>
							<td>职工号</td>
							<td></td>
						</tr>

						<tr>
							<td>离校时间</td>
							<td></td>
							<td>人员工资状态</td>
							<td></td>
						</tr>

						<tr>
							<td>离校原因</td>
							<td colspan="3"></td>
						</tr>

						<tr>
							<td>取消工资关系时间</td>
							<td><input type="text" style="border-style:none;width:99%;" /></td>
							<td>业务处理时间</td>
							<td><input type="text" style="border-style:none;width:99%;" /></td>
						</tr>

						<tr>
							<td>备注</td>
							<td colspan="3"><input type="text"
								style="border-style:none;width:99%" /></td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>

		<div class="container">
			<form class="horizontal">
				<input type="submit" value="提交" />
			</form>
		</div>
	</div>

</body>
</html>