<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>高校职工工资管理系统</title>
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
	<s:form name="professionalPositionForm">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:30px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0" >
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1"  bgcolor="#000000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center" 
														style="font-size:16px; ">专业技术人员岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>
												
												<s:iterator id="proList" value="#session.proList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#proList.position" /></td>
														<td><s:property value="#proList.level" /></td>
														<td><s:property value="#proList.salaryStandard" /></td>
														<td><s:property value="#proList.startPayLevel"/></td>
														<td ><a href="
														<s:url action="salaryStandard/getChangeInfo_posSalaryChange"> 
														<s:param name="tableName"> posSalary</s:param>
														<s:param name="type">pro</s:param>
														<s:param name="position" value= "#proList.position" />
														<s:param name="level" value= "#proList.level" />
														<s:param name="salaryStandard" value= "#proList.salaryStandard" />
														<s:param name="startPayLevel" value= "#proList.startPayLevel" />
														</s:url>">修改</a></td>
													</tr>
												</s:iterator>
												
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />


	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#000000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">专业技术人员薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>

													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>
												
												<s:iterator id="proPayLevelList"
													value="#session.proPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#proPayLevelList.payLevel" /></td>
														<td><s:property
																value="#proPayLevelList.salaryStandard" /></td>
																<td ><a href="
																<s:url action="salaryStandard/getChangeInfo_payLevelSalaryChange"> 
														<s:param name="tableName"> payLevel</s:param>
														<s:param name="type">pro</s:param>
														<s:param name="payLevel" value= "#proPayLevelList.payLevel" />
														<s:param name="payLevelSalaryStandard" value= "#proPayLevelList.salaryStandard" />
														</s:url>">修改</a></td>
													</tr>
															
												</s:iterator>
								


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#000000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF" >
													<td height="22" colspan="7" align="center"
														style="font-size:16px;">管理人员岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>
												<s:iterator id="manList" value="#session.manList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#manList.position" /></td>
														<td><s:property value="#manList.level" /></td>
														<td><s:property value="#manList.salaryStandard" /></td>
														<td><s:property value="#manList.startPayLevel" /></td>
														<td ><a href="
														<s:url action="salaryStandard/getChangeInfo_posSalaryChange"> 
														<s:param name="tableName"> posSalary</s:param>
														<s:param name="type">man</s:param>
														<s:param name="position" value= "#manList.position" />
														<s:param name="level" value= "#manList.level" />
														<s:param name="salaryStandard" value= "#manList.salaryStandard" />
														<s:param name="startPayLevel" value= "#manList.startPayLevel" />
														</s:url>">修改</a></td>
													</tr>
												</s:iterator>


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />


	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#00000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center"
														style="font-size:16px">管理人员薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>
													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="manPayLevelList"
													value="#session.manPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#manPayLevelList.payLevel" /></td>
														<td><s:property
																value="#manPayLevelList.salaryStandard" /></td>
																<td ><a href="
																<s:url action="salaryStandard/getChangeInfo_payLevelSalaryChange"> 
														<s:param name="tableName"> payLevel</s:param>
														<s:param name="type">man</s:param>
														<s:param name="payLevel" value= "#proPayLevelList.payLevel" />
														<s:param name="payLevelSalaryStandard" value= "#proPayLevelList.salaryStandard" />
														</s:url>">修改</a></td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">


			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#000000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center"
														style="font-size:16px;">工人岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="workerList" value="#session.workerList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#workerList.position" /></td>
														<td><s:property value="#workerList.level" /></td>
														<td><s:property value="#workerList.salaryStandard" /></td>
														<td><s:property value="#workerList.startPayLevel" /></td>
														<td ><a href="
														<s:url action="salaryStandard/getChangeInfo_posSalaryChange"> 
														<s:param name="tableName"> posSalary</s:param>
														<s:param name="type">pro</s:param>
														<s:param name="position" value= "#workerList.position" />
														<s:param name="level" value= "#workerList.level" />
														<s:param name="salaryStandard" value= "#workerList.salaryStandard" />
														<s:param name="startPayLevel" value= "#workerList.startPayLevel" />
														</s:url>">修改</a></td>
													</tr>
												</s:iterator>


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
	<br />

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">


			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="85%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#000000" class="newfont03">
												<tr class="CTitle" bgcolor="#CAE1FF">
													<td height="22" colspan="7" align="center"
														style="font-size:16px;">工人薪级工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="20%">薪级</td>

													<td width="20%">工资标准</td>
													<td width="10%">操作</td>
												</tr>

												<s:iterator id="workerPayLevelList"
													value="#session.workerPayLevelList">
													<tr bgcolor="#FFFFFF">
														<td><s:property value="#workerPayLevelList.payLevel" /></td>
														<td><s:property
																value="#workerPayLevelList.salaryStandard" /></td>
														<td ><a href="
																<s:url action="salaryStandard/getChangeInfo_payLevelSalaryChange"> 
														<s:param name="tableName"> payLevel</s:param>
														<s:param name="type">worker</s:param>
														<s:param name="payLevel" value= "#proPayLevelList.payLevel" />
														<s:param name="payLevelSalaryStandard" value= "#proPayLevelList.salaryStandard" />
														</s:url>">修改</a></td>
													</tr>
												</s:iterator>



											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
