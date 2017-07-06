<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>高校职工工资管理系统</title>
<script language="JavaScript">
function sousuo(){
	  window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function selectAll(){
	  var obj = document.fom.elements;
	  for (var i=0;i<obj.length;i++){
	    if (obj[i].name == "delid"){
	      obj[i].checked = true;
	    }
	  }
	}

	function unselectAll(){
	  var obj = document.fom.elements;
	  for (var i=0;i<obj.length;i++){
	    if (obj[i].name == "delid"){
	      if (obj[i].checked==true) obj[i].checked = false;
	      else obj[i].checked = true;
	    }
	  }
	}

	function link(){
	    document.getElementById("fom").action="addrenwu.htm";
	   document.getElementById("fom").submit();
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
<!-- <SCRIPT language=JavaScript>

</SCRIPT> -->

<body onload="checkLogin()">
	<form name="fom" id="fom" method="post" action="">
		<table width="60%" border="0" cellspacing="0" cellpadding="0">


			<tr>
				<td><table id="subtree1" style="DISPLAY:" width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr class="CTitle">
													<td height="22" colspan="7" align="center"
														style="font-size: 16px bgcolor= #FFFFFF">专业技术人员岗位工资表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
													<td width="4%" align="center" height="30">选择</td>
													<td width="10%">岗位</td>
													<td width="10%">级数</td>
													<td width="10%">工资标准</td>
													<td width="10%">起点薪级</td>

													<td width="11%">操作</td>
												</tr>

												<tr bgcolor="#FFFFFF">
													<td height="20"><input type="checkbox" name="delid" /></td>
													<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
													<td></td>
													<td></td>
													<td></td>

													<td><a href="listrenwumingxi.htm">编辑</a></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20"><input type="checkbox" name="delid" /></td>
													<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
													<td></td>
													<td></td>
													<td></td>

													<td><a href="listrenwumingxi.htm">编辑</a></td>
												</tr>
												<tr bgcolor="#FFFFFF">
													<td height="20"><input type="checkbox" name="delid" /></td>
													<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
													<td></td>
													<td></td>
													<td></td>

													<td><a href="listrenwumingxi.htm">编辑</a></td>
												</tr>


											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table>
		</table>
	</form>
	<br>


		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">


				<tr>
					<td><table id="subtree1" style="DISPLAY:" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><table width="95%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" bgcolor="#464646" class="newfont03">
													<tr class="CTitle">
														<td height="22" colspan="7" align="center"
															style="font-size: 16px bgcolor= #FFFFFF">专业技术人员薪级工资表</td>
													</tr>
													<tr bgcolor="#EEEEEE">
														<td width="4%" align="center" height="30">选择</td>
														<td width="20%">薪级</td>

														<td width="20%">工资标准</td>


														<td width="11%">操作</td>
													</tr>

													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>


												</table>
											</td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
		</form>
	<br>

		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">


				<tr>
					<td><table id="subtree1" style="DISPLAY:" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><table width="95%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" bgcolor="#464646" class="newfont03">
													<tr class="CTitle">
														<td height="22" colspan="7" align="center"
															style="font-size: 16px bgcolor= #FFFFFF">管理人员岗位工资表</td>
													</tr>
													<tr bgcolor="#EEEEEE">
														<td width="4%" align="center" height="30">选择</td>
														<td width="10%">岗位</td>
														<td width="10%">级数</td>
														<td width="10%">工资标准</td>
														<td width="10%">起点薪级</td>

														<td width="11%">操作</td>
													</tr>

													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>


												</table>
											</td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
		</form>
	<br>


		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">


				<tr>
					<td><table id="subtree1" style="DISPLAY:" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><table width="95%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" bgcolor="#464646" class="newfont03">
													<tr class="CTitle">
														<td height="22" colspan="7" align="center"
															style="font-size: 16px bgcolor= #FFFFFF">管理人员薪级工资表</td>
													</tr>
													<tr bgcolor="#EEEEEE">
														<td width="4%" align="center" height="30">选择</td>
														<td width="20%">薪级</td>

														<td width="20%">工资标准</td>


														<td width="11%">操作</td>
													</tr>

													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>


												</table>
											</td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
		</form>
	<br>

		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table id="subtree1" style="DISPLAY:" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><table width="95%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" bgcolor="#464646" class="newfont03">
													<tr class="CTitle">
														<td height="22" colspan="7" align="center"
															style="font-size: 16px bgcolor= #FFFFFF">工人岗位工资表</td>
													</tr>
													<tr bgcolor="#EEEEEE">
														<td width="4%" align="center" height="30">选择</td>
														<td width="10%">岗位</td>
														<td width="10%">级数</td>
														<td width="10%">工资标准</td>
														<td width="10%">起点薪级</td>

														<td width="11%">操作</td>
													</tr>

													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>
														<td></td>
														<td></td>

														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>


												</table>
											</td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
		</form>
	<br>

		<form name="fom" id="fom" method="post" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">


				<tr>
					<td><table id="subtree1" style="DISPLAY:" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><table width="95%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td height="40" class="font42">
												<table width="100%" border="0" cellpadding="4"
													cellspacing="1" bgcolor="#464646" class="newfont03">
													<tr class="CTitle">
														<td height="22" colspan="7" align="center"
															style="font-size: 16px bgcolor= #FFFFFF">工人薪级工资表</td>
													</tr>
													<tr bgcolor="#EEEEEE">
														<td width="4%" align="center" height="30">选择</td>
														<td width="20%">薪级</td>

														<td width="20%">工资标准</td>


														<td width="11%">操作</td>
													</tr>

													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>
													<tr bgcolor="#FFFFFF">
														<td height="20"><input type="checkbox" name="delid" /></td>
														<td><a href="listmokuaimingxi.htm" onclick=""></a></td>
														<td></td>


														<td><a href="listrenwumingxi.htm">编辑</a></td>
													</tr>


												</table>
											</td>
										</tr>
									</table></td>
							</tr>
						</table>
			</table>
		</form>


</body>
</html>
