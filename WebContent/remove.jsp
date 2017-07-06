<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>减员停薪、取消工资关系</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/AnnualBonus.css">


<script type="text/javascript">
	//var myfrom=document.getElementById("myform1");
	
		function showError() {
			var rightInfo = "<%=session.getAttribute("rightInfo")%>";
			<%session.removeAttribute("rightInfo");%>
			if (rightInfo != "null" && rightInfo != "" && rightInfo != null) {			
				alert(rightInfo);
			}
		}
		showError();
		
		function yesToSubmit()
		{
			var myform=document.getElementById("myform1");
			myform.action="employee/infoSubmit_remove";
			myform.method="post";
			myform.submit();
		}
		
		function yestoSubmit()
		{
			var myform=document.getElementById("myform2");
			myform.action="employee/infoSubmit2_remove";
			myform.method="post";
			myform.submit();
		}
		
		function Query()
		{
					
			var myform=document.getElementById("myform3");
			myform.action="employee/query_remove";
			myform.method="post";
			myform.submit();
		}
		function ok1()
		{
			/* var a=document.getElementById("div1");
			if(a.style.display=="none")
				a.style.display="block";
			else
				a.style.display="none"; */
			var myform1=document.getElementById("myform1");
			myform1.style.display="block";
		}
		function ok2()
		{
			var b=document.getElementById("div2");
			if(b.style.display=="none")
				b.style.display="block";
			else
				b.style.display="none";
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
	<div style="margin-top:20px;margin-left:20px;"> 
	<h2 style="margin-left:40.3%;">批量导入</h2>
	<s:form action="employee/importStopEmployeeInfo_remove" method="post"
		enctype="multipart/form-data" role="form">
      <div style="margin-left:40%;">
		<input type="file" name="stopEmployeeFile"  title="选择文件" class="file-input-wrapper btn btn-default btn-primary" />
		
		<input type="submit" class="btn btn-success" onclick="ok1()" value="导入" />
		</div>
	</s:form>
	</div>
	
	<form id="myform1">
	<table width="85%" border="0" align="center" cellpadding="0"
		cellspacing="0" style="margin-bottom:2%;">
		<tr>
			<td height="40">
				<table width="100%" border="0" cellpadding="4" cellspacing="1"
					bgcolor="#000000" class="newfont03">
					<tr class="CTitle" bgcolor="#CAE1FF">
						<td height="22" colspan="9" align="center"
							style="font-size:16px; "></td>
					</tr>
					<tr bgcolor="#EEEEEE">
						<td width="10%">姓名</td>
						<td width="10%">性别</td>
						<td width="10%">职工号</td>
						<td width="10%">单位</td>
						<td width="10%">离校时间</td>
						<td width="10%">离校原因</td>
						<td width="10%">人员工资状态</td>
						<td width="10%">停发时间</td>
						<td width="10%">备注</td>
					</tr>
					<s:iterator id="lList" value="#session.lList">
						<tr bgcolor="#EEEEEE">
							<td><s:property value="%{#lList.getName()}" /></td>
							<td><s:property value="%{#lList.getGender()}" /></td>
							<td><s:property value="%{#lList.geteId()}" /></td>
							<td><s:property value="%{#lList.getDepartment()}" /></td>
							<td><s:date name="%{#lList.getLeaveDate()}" format="yyyy-MM-dd" /></td>
							<td><s:property value="%{#lList.getReason()}" /></td>
							<td><s:property value="%{#lList.getState()}" /></td>
							<td><s:date name="%{#lList.getStopDate()}" format="yyyy-MM-dd"/></td>
							<td><s:property value="%{#lList.getNote()}" /></td>
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
	</table>
	  <input style="margin-left:45%;" type="button"  class="btn btn-success" name="btnSubmit" value="确认"onclick="yesToSubmit()" />
	</form>
	
	
	
	<hr />
	<div >
	<h2 style="margin-left:40.3%;">单个导入</h2>
	
	<form id="myform2" style="margin-left:34%; font-size:20px; font-weight:bold;">
		职工号 ：<input style="margin-left:2.3%;" type="text" name="eId" /><br /> 
		离校时间：<input type="text" name="leaveDate" /><br /> 
		离校原因：<input type="text" name="leaveReason" /><br /> 
		工资状态：<input type="text" name="salaryState" /><br /> 
		停发时间：<input type="text" name="stopDate" /><br />
		备注 ：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="remark" /><br /> 
		业务处理：<input type="radio" name="business" value="停薪" checked="checked" />&nbsp;停薪&nbsp;&nbsp;&nbsp;<input	type="radio" name="business" value="取消工资关系" />&nbsp;取消工资关系<br /> 
		<input style="margin-left:16%; margin-top:3%;" type="button" name="btnsubmit" value="确认" onclick="yestoSubmit()" class="btn btn-success" />
	</form>
	</div>
	
	<hr/>
	
	<form id="myform3" style="margin-left:43%; font-size:20px; font-weight:bold;">
	    <h2>查询</h2>
	    <div style="margin-left:-15%;">
		职工号：<input type="text" name="queryId" /><br />
		姓名：&nbsp;&nbsp;&nbsp;<input type="text" name="queryName" /><br />
		单位：&nbsp;&nbsp;&nbsp;<input type="text" name="queryDepartment" /><br />
		<input style="margin-left:15%;" type="button" name="btnsmit" onclick="Query()" value="查询" class="btn btn-success">
		</div>
	</form>
	
	<div id="div2" style="margin-left:10px; width:100%:">
	<hr/>
	<form class="form-horizontal" id="myform4">
	<table class="table table-bordered" width="100%" >
	<thead>
	<tr bgcolor="#CCFFFF">
		<td>姓名</td>
		<td>性别</td>
		<td>单位</td>
		<td>离校时间</td>
		<td>离校原因</td>
		<td>工资状态</td>
		<td>停薪时间</td>
		<td>备注</td>
	</tr>
	</thead>
	<tbody>
		<s:iterator id="queryList" value="#session.queryList">
			<tr bgcolor="#EEEEEE">
				<td><s:property value="%{#queryList.getName()}" /></td>
				<td><s:property value="%{#queryList.getGender()}" /></td>
				<td><s:property value="%{#queryList.getDepartment()}" /></td>
				<td><s:date name="%{#queryList.getLeaveDate()}" format="yyyy-MM-dd" /></td>
				<td><s:property value="%{#queryList.getReason()}" /></td>
				<td><s:property value="%{#queryList.getState()}" /></td>
				<td><s:date name="%{#queryList.getStopDate()}" format="yyyy-MM-dd"/></td>
				<td><s:property value="%{#queryList.getNote()}" /></td>
			</tr>
		</s:iterator>

	</tbody>
	</table>
	</form> 
	</div>
</body>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
$('input[type=file]').bootstrapFileInput();
$('.file-inputs').bootstrapFileInput();

</script>


</html>
