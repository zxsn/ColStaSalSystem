<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalaryInfoDisplay</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	function getSalaryInfo()
	{
		var myform=document.forms[0];
		myform.action="salary/getSalaryInfo_SalaryInfoDisplay";
		myform.method="post";		
		myform.submit();
	}
	
	function exportSalaryInfo()
	{
		var myform=document.forms[0];
		myform.action="salary/exportSalaryInfo_success";
		myform.method="post";		
		myform.submit();
	}
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>
	";

		if (nid == "null" || nid == "") {
			window.location.href = "login.jsp";
			$(".alert").alert("请先登录！");
		}
	}
</script>
</head>
<body onload="checkLogin()">
	<form id="myform1">
		<table>
			<%-- <s:iterator value="eInfo" id="li">
				<tr>
					<td><s:property value="#li.id" /></td>
					<td><s:property value="#li.name" /></td>
					<td>
				</tr>
			</s:iterator> --%>
			<%-- <s:textfield name="employee.id" value="%{employee.id}"/> --%>
			<!-- 职工号：<input type="text" name="salary.eid"/><br/> -->
			<s:iterator value="#session.eSalaryInfo" id="li">
				<td>职工号：<s:textfield name="li.id" value="%{#li.eid}" /></td>
				<br />
				<td>岗位工资：<s:textfield name="li.name"
						value="%{#li.positionSalary}" /></td>
				<br />
				<td>薪级工资：<s:textfield name="li.name" value="%{#li.levelSalary}" /></td>
				<br />
				<td>地区差：<s:textfield name="li.name"
						value="%{#li.areaDifference}" /></td>
				<br />
				<td>岗位津贴：<s:textfield name="li.name"
						value="%{#li.positionAllowance}" /></td>
				<br />
				<td>教护补贴：<s:textfield name="li.name"
						value="%{#li.educationAllowance}" /></td>
				<br />
				<td>特殊津贴：<s:textfield name="li.name"
						value="%{#li.specialAllowance}" /></td>
				<br />
				<td>独生子女补贴：<s:textfield name="li.name"
						value="%{#li.onlyChildAllowance}" /></td>
				<br />
				<td>其它补贴：<s:textfield name="li.name"
						value="%{#li.otherAllowance}" /></td>
				<br />
				<td>电话补贴：<s:textfield name="li.name"
						value="%{#li.phoneAllowance}" /></td>
				<br />
				<td>月增资额：<s:textfield name="li.name"
						value="%{#li.monthAddAllowance}" /></td>
				<br />
				<td>补发工资：<s:textfield name="li.name"
						value="%{#li.supplementSalary}" /></td>
				<br />
				<td>本月总工资：<s:textfield name="li.name"
						value="%{#li.totleSalary}" /></td>
				<br />
				<td>备注：<s:textfield name="li.name" value="%{#li.remarks}" /></td>
				<br />
			</s:iterator>
		</table>
		<input type="button" name="btngetInfo" onclick="getSalaryInfo()"
			value="查询" /> <input type="button" name="btnexportInfo"
			onclick="exportSalaryInfo()" value="导出" />
	</form>
</body>
</html>