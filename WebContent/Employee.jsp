<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>高校教职工工资系统</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/datepicker.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";	
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
			alert("请先登录！");
		}
	}

	function showInfo() {
		var info = "<%=session.getAttribute("alertInfo")%>";
		<%session.removeAttribute("alertInfo");%>
		if(info != "null" && info != "") {
			alert(info);
		}
	}
	showInfo();
</script>
</head>
<body onload="checkLogin()">
		<div class="employeeinfo">职工信息录入</div>
		<form id="infoinput" enctype="multipart/form-data">
			<div class="container">
				<div class="row">
					<div class="span6">
						<dl class="dl-horizontal">
							<dt>
								职工号<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f1" type="text" name="employee.id" maxLength="6">
							</dd>
						</dl>


						<dl class="dl-horizontal">
							<dt>
								姓名<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f2" type="text" name="employee.name" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								身份证号<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f3" type="text" name="employee.uid" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								单位<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f4" type="text" name="employee.department" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								最高学历<span style="color:red">*</span>
							</dt>
							<dd>
								<select id="maxeducation" name="employee.maxEducation">
									<option value="无">无</option>
									<option value="博士研究生">博士研究生</option>
									<option value="硕士研究生">硕士研究生</option>
									<option value="本科">本科</option>
									<option value="大专(高职)">大专(高职)</option>
									<option value="高中(中专)">高中(中专)</option>
									<option value="初中">初中</option>
									<option value="小学">小学</option>
								</select>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								最高学位<span style="color:red">*</span>
							</dt>
							<dd>
								<select id="maxdegree" name="employee.maxDegree">

									<option value="无">无</option>
									<option value="学士">学士</option>
									<option value="硕士">硕士</option>
									<option value="博士">博士</option>


								</select>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								人员身份<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f5" type="text" name="employee.type" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								入校报到时间<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f6" type="text" class="datepicker"
									name="employee.reachSchoolDate" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>职务级别</dt>
							<dd>
								<select id="worklevel" name="employee.workLevel"
									onchange="showB(this.selectedIndex)">

									<option value="">无</option>
									<option value="1">一级</option>
									<option value="2">二级</option>
									<option value="3">三级</option>
									<option value="4">四级</option>
									<option value="5">五级</option>
									<option value="6">六级</option>
									<option value="7">七级</option>
									<option value="8">八级</option>
									<option value="9">九级</option>
									<option value="10">十级</option>
								</select>
							</dd>
						</dl>



						<dl class="dl-horizontal">
							<dt>聘任职称</dt>
							<dd>

								<select id="hiretitle" name="employee.hireTitle"
									onchange="showC(this.selectedIndex)">

									<option value="无">无</option>
									<option value="正高级">正高级</option>
									<option value="副高级">副高级</option>
									<option value="中级">中级</option>
									<option value="助理级">助理级</option>
									<option value="员级">员级</option>

								</select>

							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>聘任时间</dt>
							<dd>
								<input type="text" class="datepicker" name="employee.hireDate"
									size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>聘岗级别</dt>
							<dd>

								<select id="joblevel" name="employee.jobLevel"
									onchange="showF(this.selectedIndex)">

									<option value="">无</option>
									<option value="1">技术工一级</option>
									<option value="2">技术工二级</option>
									<option value="3">技术工三级</option>
									<option value="4">技术工四级</option>
									<option value="5">技术工五级</option>
									<option value="6">普通工</option>

								</select>
							</dd>
						</dl>

					</div>

					<div class="span6">

						<dl class="dl-horizontal">
							<dt>
								性别<span style="color:red">*</span>
							</dt>
							<dd>
								<select id="gender" name="employee.gender">
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								出生日期<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f7" type="text" class="datepicker"
									name="employee.birthday" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								邮箱<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="email" type="text" name="employee.email" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								岗位性质<span style="color:red">*</span>
							</dt>
							<dd>
								<select id="f8" name="employee.jobType">
									<option value="管理">管理</option>
									<option value="专技">专技</option>
									<option value="工人">工人</option>
									<option value="其它" selected>其它</option>
								</select>
<!-- 								<input id="f8" type="text" name="employee.jobType" size=20> -->
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								最高学历获得时间<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f9" type="text" class="datepicker"
									name="employee.maxEducationDate" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>
								最高学位获得时间<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f10" type="text" class="datepicker"
									name="employee.maxDegreeDate" size=20>
							</dd>
						</dl>


						<dl class="dl-horizontal">
							<dt>
								入校来源<span style="color:red">*</span>
							</dt>
							<dd>
								<input id="f11" type="text" name="employee.source" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>聘任职务</dt>
							<dd>
								<select id="hirework" name="employee.hireWork"
									onchange="showA(this.selectedIndex)">

									<option value="无">无</option>
									<option value="正部级">正部级</option>
									<option value="副部级">副部级</option>
									<option value="正厅级">正厅级</option>
									<option value="副厅级">副厅级</option>
									<option value="正处级">正处级</option>
									<option value="副处级">副处级</option>
									<option value="正科级">正科级</option>
									<option value="副科级">副科级</option>
									<option value="科员">科员</option>
									<option value="办事员">办事员</option>
								</select>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>任职时间</dt>
							<dd>
								<input type="text" class="datepicker"
									name="employee.startWorkDate" size=20>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>职称级别</dt>
							<dd>
								<select id="titlelevel" name="employee.titleLevel"
									onchange="showD(this.selectedIndex)">
									<option value="">无</option>
									<option value="1">一级</option>
									<option value="2">二级</option>
									<option value="3">三级</option>
									<option value="4">四级</option>
									<option value="5">五级</option>
									<option value="6">六级</option>
									<option value="7">七级</option>
									<option value="8">八级</option>
									<option value="9">九级</option>
									<option value="10">十级</option>
									<option value="11">十一级</option>
									<option value="12">十二级</option>
									<option value="13">十三级</option>
								</select>
							</dd>
						</dl>

						<dl class="dl-horizontal">
							<dt>(拟)聘任岗位</dt>
							<dd>

								<select id="hirejob" name="employee.hireJob"
									onchange="showE(this.selectedIndex)">

									<option value="无">无</option>
									<option value="高级技工">高级技工</option>
									<option value="技师">技师</option>
									<option value="高级工">高级工</option>
									<option value="中级工">中级工</option>
									<option value="初级工">初级工</option>
									<option value="普通工">普通工</option>

								</select>
							</dd>
						</dl>

					</div>
				</div>

			</div>
			<div style="margin-top:30px; margin-bottom:250px;" class="center">
				<div class="btn-group">
					<button type="button" class="btn btn-success" onclick="addEmployee()">增加</button>

					<input class="btn btn-success" type="RESET" value="重置">
				</div>
			</div>
			</form>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/liveValidation.js"></script>
<script type="text/javascript" src="js/employee.js"></script>
</body>
</html>
