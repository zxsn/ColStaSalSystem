<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	Integer i = 1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校教职工工资系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="bootstrap/css/datepicker.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</head>
<body>

	<s:form name="fom" id="fom" method="post" action="">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="margin-top: 20px;">
			<tr>
				<td><table id="subtree1" style="DISPLAY:" width="100%"
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
														style="font-size: 16px;">查询结果</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="10%"></td>
													<td width="10%">职工号</td>
													<td width="10%">岗位工资</td>
													<td width="10%">薪级工资</td>
													<td width="10%">本月工资总额</td>
													<td width="10%">发放日期</td>
												</tr>
												<s:iterator value="#session.salaryList" id="salary">
													<tr bgcolor="#EEEEEE">
														<td>
															<%
																out.print(i++);
															%>
														</td>
														<td><s:property value="#salary.eid" /></td>
														<td><s:property value="#salary.positionSalary" /></td>
														<td><s:property value="#salary.levelSalary" /></td>
														<td><s:property value="#salary.totleSalary" /></td>
														<td><s:date name="#salary.time" format="yyyy-MM-dd" /></td>
													</tr>
												</s:iterator>
												<tr bgcolor="#EEEEEE">
													<td>总额</td>
													<td></td>
													<td><s:property value="#session.totalPosition" /></td>
													<td><s:property value="#session.totalLevel" /></td>
													<td><s:property value="#session.totalAmount" /></td>
													<td></td>
												</tr>

												<tr bgcolor="#EEEEEE">
													<td>平均额</td>
													<td></td>
													<td><s:property value="#session.averagePosition" /></td>
													<td><s:property value="#session.averageLevel" /></td>
													<td><s:property value="#session.averageAmount" /></td>
													<td></td>
												</tr>
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