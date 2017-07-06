<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/datepicker.css">
<link rel="stylesheet" href="css/index.css">

<script type="text/javascript">
	function showError() {
		var salaryInfo = "<%=session.getAttribute("salaryInfo")%>";
		<%session.removeAttribute("salaryInfo");%>
		if (salaryInfo != "null" && salaryInfo != "" && salaryInfo != null) {			
				alert(salaryInfo);
			}
	}
	showError();
	//ar myfrom=document.getElementById("myform1");
	i = 0;
	j = 0;
	k = 0;
	l = 0;
	m = 0;

	function addSalaryInfo() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");

		
		var id = topWin.document.getElementById("f1").value;
		
		var level= topWin.document.getElementById("f2").value;
		
		var startSalaryTime = topWin.document.getElementById("f3").value;
		
		var startWorkTime = topWin.document.getElementById("f4").value;
	
		var paySeries = topWin.document.getElementById("f5").value;
		

		if (null == id || "" == id) {
			alert("职工号不能为空");
			topWin.document.getElementById("f1").focus();
			return false;
		} else if (id.length != 6) {
			alert("职工号长度必须为6位");
			topWin.document.getElementById("f1").focus();
			return false;
		} else if (null == level || "" == level) {
			alert("工资岗位级别不能为空");
			topWin.document.getElementById("f2").focus();
			return false;
		} else if (null == startSalaryTime|| "" == startSalaryTime) {
			alert("起薪时间不能为空");
			topWin.document.getElementById("f3").focus();
			return false;
		} else if (null == startWorkTime || "" == startWorkTime) {
			alert("起始工作时间不能为空");
			topWin.document.getElementById("f4").focus();
			return false;
		} else if (null == paySeries || "" == paySeries) {
			alert("工资系列不能为空");
			topWin.document.getElementById("f5").focus();
			return false;
		}

		myform.action = "newEmployee/importStaff_newWorkerSalary";
		myform.method = "post";
		myform.submit();
	}

	function modifySalaryInfo() {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var myform = topWin.document.getElementById("myform1");

		myform.action = "newEmployee/modifySalaryInfo_success";
		myform.method = "post";
		myform.submit();
	}

	function addManExperience() {

		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + i);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("manExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "manWorkDate" + i);
		a.setAttribute("id", "Title" + i);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职位&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "manExperience" + i);
		b.setAttribute("id", "Title" + i);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delManExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		i++;
		topWin.document.getElementById("i").value = i;
	}

	function delManExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("manExperience").removeChild(o.parentNode);

		
		i--;
        topWin.document.getElementById("i").value = i;
        var x = mainDocument.getElementById("manExperience").getElementsByTagName("label");
        for(var a = 0;a < i; a++)
        {
        	var y = x[a].getElementsByTagName("input");
        	y[0].setAttribute("name", "manWorkDate" + a);
        	y[1].setAttribute("name", "manExperience" + a);
        }

	}

	function addProExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + j);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("proExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "proWorkDate" + j);
		a.setAttribute("id", "Title" + j);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职称&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "proExperience" + j);
		b.setAttribute("id", "Title" + j);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delProExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		j++;
		topWin.document.getElementById("j").value = j;

	}


	function delProExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("proExperience").removeChild(o.parentNode);
		
		j--;
        topWin.document.getElementById("j").value = j;
        var x = mainDocument.getElementById("proExperience").getElementsByTagName("label");
        for(var a = 0;a < j; a++)
        {
        	var y = x[a].getElementsByTagName("input");
        	y[0].setAttribute("name", "proWorkDate" + a);
        	y[1].setAttribute("name", "proExperience" + a);
        }

		topWin.document.getElementById("j").value=j;

	}

	function addWorkerExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + m);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("workerExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "workerWorkDate" + m);
		a.setAttribute("id", "Title" + m);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp担任职称&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "workerExperience" + m);
		b.setAttribute("id", "Title" + m);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delWorkerExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		m++;
		topWin.document.getElementById("m").value = m;

	}

	function delWorkerExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("workerExperience").removeChild(
				o.parentNode);
								
		m--;
        topWin.document.getElementById("m").value = m;
        var x = mainDocument.getElementById("workerExperience").getElementsByTagName("label");
        for(var a = 0;a < m; a++)
        {
        	var y = x[a].getElementsByTagName("input");
        	y[0].setAttribute("name", "workerWorkDate" + a);
        	y[1].setAttribute("name", "workerExperience" + a);
        }
	}

	function addEduExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + k);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("eduExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">年份&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");
		a.setAttribute("name", "eduWorkDate" + k);
		a.setAttribute("id", "Title" + k);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp获得学位&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");
		b.setAttribute("name", "eduExperience" + k);
		b.setAttribute("id", "Title" + k);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delEduExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		k++;
		topWin.document.getElementById("k").value = k;

	}

	function delEduExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("eduExperience").removeChild(o.parentNode);
		
		k--;
        topWin.document.getElementById("k").value = k;
        var x = mainDocument.getElementById("eduExperience").getElementsByTagName("label");
        for(var a = 0;a < k; a++)
        {
        	var y = x[a].getElementsByTagName("input");
        	y[0].setAttribute("name", "eduWorkDate" + a);
        	y[1].setAttribute("name", "eduExperience" + a);
        }
	}

	function addBreakExperience() {
		label0 = document.createElement("label");
		label0.setAttribute("id", "label" + l);
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var experienceDiv = topWin.document.getElementById("breakExperience");

		var span1 = document.createElement("span");
		span1.innerHTML = '<span style="font-weight:bold;">起始时间&nbsp</span>';
		label0.appendChild(span1);

		var a = document.createElement("input");
		a.setAttribute("type", "text");

		a.setAttribute("class", "datepicker");

		a.setAttribute("name", "breakStartDate" + l);

		a.setAttribute("id", "Title" + l);
		label0.appendChild(a);

		var span2 = document.createElement("span");
		span2.innerHTML = '<span style="font-weight:bold;">&nbsp&nbsp结束时间&nbsp</span>';
		label0.appendChild(span2);

		var b = document.createElement("input");
		b.setAttribute("type", "text");

		b.setAttribute("class", "datepicker");
		b.setAttribute("name", "breakEndDate" + l);


		b.setAttribute("id", "Title" + l);
		label0.appendChild(b);

		var textField2 = document.createElement("input");
		textField2.setAttribute("type", "button");
		textField2.setAttribute("name", "button");
		textField2.setAttribute("style", "margin-top:-8px; margin-left:10px;");
		textField2.setAttribute("class", "btn btn-warning");
		textField2.setAttribute("value", "删除");

		textField2.onclick = function() {
			delBreakExperience(this);
		};
		label0.appendChild(textField2);

		var div = document.createElement("div");
		div.innerHTML = '';
		label0.appendChild(div);

		experienceDiv.appendChild(label0);
		l++;
		topWin.document.getElementById("l").value = l;
		
		
		$(".datepicker").datepicker({
			format : 'yyyy-mm-dd',			 
		});
	
	    
	}

	function delBreakExperience(o) {
		var topWin = window.top.document.getElementById("mainFrame").contentWindow;
		var mainDocument = window.top.document.getElementById("mainFrame").contentWindow.document;
		mainDocument.getElementById("breakExperience")
				.removeChild(o.parentNode);
				
		l--;
        topWin.document.getElementById("l").value = l;
        var x = mainDocument.getElementById("breakExperience").getElementsByTagName("label");
        for(var a = 0;a < l; a++)
        {
        	var y = x[a].getElementsByTagName("input");
        	y[0].setAttribute("name", "breakStartDate" + a);
        	y[1].setAttribute("name", "breakEndDate" + a);
        }
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

	<s:form id="myform" style="display:none; ">

	职工号：<s:property value="#session.addedEmployee.id" />
		<br />
	姓名:<s:property value="#session.addedEmployee.name" />
		<br />
	邮箱:<s:property value="#session.addedEmployee.email" />
		<br />

	性别：	<s:if test="%{#session.addedEmployee.gender == '男'}">男</s:if>

		<s:else>女</s:else>
		<br />
	出生日期：<s:property value="#session.addedEmployee.birthday" />
		<br />
	身份证号：<s:property value="#session.addedEmployee.uid" />
		<br />
	单位：<s:property value="#session.addedEmployee.department" />
		<br />
	岗位性质：<s:property value="#session.addedEmployee.jobType" />
		<br />
	人员身份：<s:property value="#session.addedEmployee.type" />
		<br />
	进校来源：<s:property value="#session.addedEmployee.source" />
		<br />
	入校报到时间：<s:property value="#session.addedEmployee.reachSchoolDate" />
		<br />
	最高学历：<s:property value="#session.addedEmployee.maxEducation" />
		<br />
	最高学历获得时间：<s:property value="#session.addedEmployee.maxEducationDate" />
		<br />
	最高学位：<s:property value="#session.addedEmployee.maxDegree" />
		<br />
	最高学位获得时间：<s:property value="#session.addedEmployee.maxDegreeDate" />
		<br />
	聘任职务：<s:property value="#session.addedEmployee.hireWork" />
		<br />
	职务级别：<s:property value="#session.addedEmployee.workLevel" />
		<br />
	任职时间：<s:property value="#session.addedEmployee.startWorkDate" />
		<br />
	聘任职称：<s:property value="#session.addedEmployee.hireTitle" />
		<br />
	职称级别：<s:property value="#session.addedEmployee.titleLevel" />
		<br />
	聘任时间：<s:property value="#session.addedEmployee.hireDate" />
		<br />
	（拟）聘任岗位：<s:property value="#session.addedEmployee.hireJob" />
		<br />
	聘岗级别：<s:property value="#session.addedEmployee.jobLevel" />
		<br />
	职工号	: <s:textfield name="startSalaryInfo.eid"
			value="%{#session.addedEmployee.id}" />
		<br />
	</s:form>

	<s:form id="myform1">
		<div class="addEmployeeSalary">增员起薪</div>
		<div class="container">
			<div class="row">
				<div class="span6" style="margin-left:65px;">
					<dl class="dl-horizontal">
						<dt>
							职工号<span style="color:red">*</span>
						</dt>
						<dd>
							<s:textfield id="f1" name="startSalaryInfo.eid"
								value="%{#session.addedEmployee.id}" maxlength="6" />

						</dd>
					</dl>


					<dl class="dl-horizontal" style="margin-bottom:20px; ">
						<dt style="margin-left:-35px; overflow:visible;">
							基本工资是否上调10%<span style="color:red ;">*</span>
						</dt>
						<dd>
							<input style="margin-top:-3px;" type="radio"
								name="startSalaryInfo.isRaised" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;<input
								style="margin-top:-3px;" type="radio"
								name="startSalaryInfo.isRaised" value="0" />否

						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>考核不合格次数</dt>
						<dd>

							<input type="text" name="failTime" size=20>
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>
							工资岗位级别<span style="color:red">*</span>
						</dt>
						<dd>
							<input id="f2" type="text" name="startSalaryInfo.positionLevel"
								size=20>
						</dd>
					</dl>
				</div>

				<div class="span6" style="margin-left:-40px;">
					<dl class="dl-horizontal">
						<dt>
							起薪时间<span style="color:red">*</span>
						</dt>
						<dd>
							<input type="text" id="f3" class="datepicker"
								name="startSalaryInfo.startSalaryDate">

						</dd>
					</dl>


					<dl class="dl-horizontal">
						<dt>
							起始工作时间<span style="color:red">*</span>
						</dt>
						<dd>
							<input type="text" id="f4" class="datepicker"
								name="startWorkYear">
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>
							工资系列<span style="color:red">*</span>
						</dt>
						<dd>
							<select id="f5" name="startSalaryInfo.salarySeries">
									<option value="管理">管理</option>
									<option value="专技">专技</option>
									<option value="工人">工人</option>
							</select>
							
						</dd>
					</dl>

					<dl class="dl-horizontal">
						<dt>备注</dt>
						<dd>
							<input type="text" name="startSalaryInfo.remarks" value="无"
								onfocus="if (value =='无'){value =''}"
								onblur="if (value ==''){value='无'}">
						</dd>
					</dl>
				</div>
			</div>
		</div>

		<div id="manExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">管理系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addManExperience()">增加</button>
			<s:textarea name="i" id="i" style="display:none;"></s:textarea>
			<br />
		</div>
		
		<div id="proExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">专技系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addProExperience()">增加</button>
			<s:textarea name="j" id="j" style="display:none;"></s:textarea>
		</div>
		
		<div id="workerExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">工人系列经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addWorkerExperience()">增加</button>
			<s:textarea name="m" id="m" style="display:none;"></s:textarea>
		</div>
		
		<div id="eduExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">教育经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addEduExperience()">增加</button>
			<s:textarea name="k" id="k" style="display:none;"></s:textarea>
		</div>
		
		<div id="breakExperience" style="text-align:center; margin-top:50px;">
			<span style="font-size:25px; font-weight:bold;">中断工作经历</span>
			<button type="button" style="margin-top:-5px; margin-left:5px;"
				class="btn btn-success" onclick="addBreakExperience()">增加</button>
			<s:textarea name="l" id="l" style="display:none;"></s:textarea>
		</div>
		

		<button type="button" style="margin-left: 45%; margin-top:50px; margin-bottom:300px;"

			class="btn btn-success" onclick="addSalaryInfo()">提交</button>

	</s:form>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/liveValidation.js"></script>
	<script type="text/javascript">
		$(".datepicker").datepicker({

			 ViewMode: 'years',
			format : 'yyyy-mm-dd',
	
			
		});

		for ( var y = 1; y < 6; y++) {
			var em = new LiveValidation("f" + y, {
				validMessage : " ",
				wait : 500
			}, {
				onlyOnSubmit : true
			});
			em.add(Validate.Presence, {
				failureMessage : "必填"
			});
		}

	</script>


</body>

</html>
