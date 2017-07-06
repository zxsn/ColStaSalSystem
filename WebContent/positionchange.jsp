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

			function search(){			
			    var myform = document.getElementById("changeInfo");
			    myform.action = "change/search2_positionchange";
				myform.method = "post";
				myform.submit();
			}
			
			function levelChange(){
				var myform = document.getElementById("changeInfo");
				myform.action = "change/PosChange_positionchange";
				myform.method = "post";
				myform.submit();
			}
			
			function showError() {
				var tipInfo = "<%=session.getAttribute("tipInfo")%>";
				<%session.removeAttribute("tipInfo");%>
				if (tipInfo != "null" && tipInfo != "" && tipInfo != null) {			
					alert(tipInfo);
				}
			}

			showError();
</script>
</head>
<body onload="checkLogin()">
	<div class="container">
		<h2 style="text-align:center;">职务变动人员名单</h2>
	</div>
	<hr/>
	
	<div class="container" style="margin-left:23%;">

		<form class="form-horizontal" id="changeInfo">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="workerid">职工号：</label>
					<div class="controls">
						<s:textfield id="workerid" name="workerid" value="%{#session.queryEmployee2.id}"/>
						<input type="button" class="btn btn-success" value="查询" onclick="search()"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="name">姓名：</label>
					<div class="controls">
						<s:textfield id="name" readonly="true" value="%{#session.queryEmployee2.name}"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="mail">邮箱：</label>
					<div class="controls">
						<s:textfield id="email" readonly="true" value="%{#session.queryEmployee2.email}"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="sex">性别：</label>
					<div class="controls">
						<s:textfield id="sex" readonly="true" value="%{#session.queryEmployee2.gender}"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="birthday">出生日期：</label>
					<div class="controls">
						<s:textfield id="birthday" readonly="true" value="%{#session.queryEmployee2.birthday}"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="identity">身份证号：</label>
					<div class="controls">
						<s:textfield id="uid" readonly="true" value="%{#session.queryEmployee2.uid}"/>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="apartment">单位：</label>
					<div class="controls">
						<s:textfield id="department" readonly="true" value="%{#session.queryEmployee2.department}"/>
					</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="popro">岗位性质：</label>
						<div class="controls">
							<s:textfield id="jobType" readonly="true" value="%{#session.queryEmployee2.jobType}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="capacity">人员身份：</label>
						<div class="controls">
							<s:textfield id="type" readonly="true" value="%{#session.queryEmployee2.type}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="camefrom">进校来源：</label>
						<div class="controls">
							<s:textfield id="source" readonly="true" value="%{#session.queryEmployee2.source}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="entrytime">入校报到时间：</label>
						<div class="controls">
							<s:textfield id="reachSchoolDate" readonly="true" value="%{#session.queryEmployee2.reachSchoolDate}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="hteduexp">最高学历：</label>
						<div class="controls">
							<s:textfield id="maxEducation" readonly="true" value="%{#session.queryEmployee2.maxEducation}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="gaintime">最高学历获得时间：</label>
						<div class="controls">
							<s:textfield id="maxEducationDate" readonly="true" value="%{#session.queryEmployee2.maxEducationDate}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="htedupos">最高学位：</label>
						<div class="controls">
							<s:textfield id="maxDegree" readonly="true" value="%{#session.queryEmployee2.maxDegree}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="gaintime2">最高学位获得时间：</label>
						<div class="controls">
							<s:textfield id="maxDegreeDate" readonly="true" value="%{#session.queryEmployee2.maxDegreeDate}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="position">聘任职称：</label>
						<div class="controls">
							<s:textfield id="hireWork" readonly="true" value="%{#session.queryEmployee2.hireTitle}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="poslabel">职称级别：</label>
						<div class="controls">
							<s:textfield id="workLevel" readonly="true" value="%{#session.queryEmployee2.titleLevel}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="assumetime">任职时间：</label>
						<div class="controls">
							<s:textfield id="startWorkDate" readonly="true" value="%{#session.queryEmployee2.hireDate}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="originaltitle">原聘任职务：</label>
						<div class="controls">
							<s:textfield id="hireTitle" readonly="true" value="%{#session.queryEmployee2.hireWork}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="originallabel">原职务级别：</label>
						<div class="controls">
							<s:textfield id="titleLevel" readonly="true" value="%{#session.queryEmployee2.workLevel}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="originaltime">原聘任时间：</label>
						<div class="controls">
							<s:textfield id="hireDate" readonly="true" value="%{#session.queryEmployee2.startWorkDate}"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="currenttitle">现聘任职务：</label>
						<div class="controls">
							<input id="currenttitle" type="text" name="newPosName"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="currentlabel">现职务级别：</label>
						<div class="controls">
							<input id="currentlabel" type="text" name="newPosRank"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="titlechangetime">职务变动时间：</label>
						<div class="controls">
							<input id="titlechangetime" type="text" class="datepicker" name="posChangeTime"/>
						</div>
					</div>
									
					<div class="control-group">
						<label class="control-label" for="chansaltime">变动起薪时间：</label>
						<div class="controls">
							<input id="chansaltime" type="text" class="datepicker" name="changeTime"/>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="chansaltime">起始工作时间：</label>
						<div class="controls">
							<input id="starttime" type="text" class="datepicker" name="startTime"/>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="currentlabel">考核不合格次数：</label>
						<div class="controls">
							<input id="currentlabel" type="text" name="failTimes"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="according">变更依据：</label>
						<div class="controls">
							<input type="text" name="accordings"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="remark">备注：</label>
						<div class="controls">
							<input id="remark" type="text" name="remarks"/>
						</div>
					</div>

					<div class="form-actions">
						<input type="button" class="btn btn-success" value="提交" onclick="levelChange()"/> 
					</div>
			</fieldset>
		</form>
		<%session.removeAttribute("queryEmployee2");%>
	</div>
<script type="text/javascript" src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
		$(".datepicker").datepicker({

			 ViewMode: 'years',
			format : 'yyyy-mm-dd',
	
			
		});
	
</script>
</body>
</html>