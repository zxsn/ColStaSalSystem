<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");

	
	function addSalary()
	{
		var myform=document.forms[0];
		myform.action="salary/addSalary_success";
		myform.method="post";
		myform.submit();
	}
	
	function modifySalary()
	{
		var myform=document.forms[0];
		myform.action="salary/modifySalary_success";
		myform.method="post";
		myform.submit();
	}
	
	function deleteSalary()
	{
		var myform=document.forms[0];
		myform.action="salary/deleteSalary_success";
		myform.method="post";
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
<form id="myform1" >
	职工号：<input type="text" name="salary.eid" /><br />
	岗位工资：<input type="text" name="salary.positionSalary" /><br />
	薪级工资：<input type="text" name="salary.levelSalary" /><br />
	地区差：<input type="text" name="salary.areaDifference" /><br />
	岗位津贴：<input type="text" name="salary.positionAllowance" /><br />
	教护补贴：<input type="text" name="salary.educationAllowance" /><br />
	特殊津贴：<input type="text" name="salary.specialAllowance" /><br />
	独生子女补贴：<input type="text" name="salary.onlyChildAllowance" /><br />
	其它补贴：<input type="text" name="salary.otherAllowance" /><br />
	电话补贴：<input type="text" name="salary.phoneAllowance" /><br />
	月增资额：<input type="text" name="salary.monthAddAllowance" /><br />
	补发工资：<input type="text" name="salary.supplementSalary" /><br />
	本月总工资：<input type="text" name="salary.totleSalary" /><br />
	备注：<input type="text" name="salary.remarks" value="无" onfocus="if (value =='无'){value =''}" onblur="if (value ==''){value='无'}" /><br />
	<input type="button" name="btnadd" onclick="addSalary()" value="增加" />
	<input type="button" name="btnmodify" onclick="modifySalary()" value="修改" />
	<input type="button" name="btndel" onclick="deleteSalary()" value="删除"  /><br />
	
 </form>
</body>
</html>