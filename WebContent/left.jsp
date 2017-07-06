<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>高校教职工工资系统</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery-3.2.1.slim.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script type="text/javascript">
	function checkLogin() {
		var nid = "<%=session.getAttribute("user.id")%>";
		
		if (nid == "null" || nid == "") {			
			window.location.href="login.jsp";
		
		}
	}
</script>
	</head>
	<body >
		<div class="body">
		    <div class="span3 well">
		      <!--LeftSidebar content-->
		      	<fieldset style="border:2px">
<legend style="border:1px;color:red">工资管理</legend>

<div id="pNode3" onclick="showList(this.id);" style="cursor:pointer;">+ 职工信息获取</div> 
<div id="pNode3_ljf" style="display:none;">
<div id="pNode3_sub1" style="padding-left:20px; cursor:pointer;">·<a  href="Employee.jsp" target="mainFrame">职工信息录入</a></div>   
<div id="pNode3_sub2" style="padding-left:20px; cursor:pointer;">·<a  href="DisplayEmployeeInfo.jsp" target="mainFrame">查找职工</a></div>
<div id="pNode3_sub3" style="padding-left:20px; cursor:pointer;">·<a  href="ImportEmployeeInfo.jsp" target="mainFrame">批量导入</a></div>      
</div> 

<div id="pNode2" onclick="showList(this.id);" style="cursor:pointer;"> + 基本工资体系</div> 
<div id="pNode2_ljf" style="display:none;"> 
<div id="pNode2_sub1" style="padding-left:20px; cursor:pointer;">·<a  href="getData" target="mainFrame">基本工资标准</a></div>  
<div id="pNode2_sub2" style="padding-left:20px; cursor:pointer;">·<a href="salaryComputeFormula.jsp" target="mainFrame">工资计算公式</a></div> 
</div> 

<div id="pNode1" onclick="showList(this.id);" style="cursor:pointer;">+ 基本工资（津补贴）管理</div> 
<div id="pNode1_ljf" style="display:none;"> 
<div id="pNode1_sub1" onclick="showList(this.id);" style="padding-left:20px; cursor:pointer;">+ 工资普调处理</div> 
<div id="pNode1_sub1_ljf" style="display:none;">  
<div id="pNode1_sub1_s3" style="padding-left:40px;">·<a href="AnnualBonus.jsp" target="mainFrame">年终一次性奖金</a></div> 

<div id="pNode1_sub1_s4" style="padding-left:40px;">·<a href="AnnualEvaluation.jsp" target="mainFrame">年终考核优秀奖金</a></div>

</div> 
<div id="pNode1_sub2" onclick="showList(this.id);" style="padding-left:20px; cursor:pointer;">+ 日常工资处理</div> 
<div id="pNode1_sub2_ljf" style="display:none;"> 
<div id="pNode1_sub2_s1" style="padding-left:40px;">·<a href="newWorkerSalary.jsp" target="mainFrame">增员起薪</a></div>
<div id="pNode1_sub2_s2" style="padding-left:40px;">·<a href="remove.jsp" target="mainFrame">减员停薪、取消工资关系</a></div>
   <div id="pNodel_sub3" onclick="showList(this.id)" style="padding-left:40px; cursor:pointer">+常规工资变动</div>
      <div id="pNodel_sub3_ljf" style="display:none;"> 
      <div id="pNode1_sub3_s1" style="padding-left:60px;">·<a href="campusmobilization.jsp" target="mainFrame">校内调动</a></div> 
      <div id="pNode1_sub3_s2" style="padding-left:60px;">·<a href="academictitlechange.jsp" target="mainFrame">职称变动</a></div> 
	  <div id="pNode1_sub3_s3" style="padding-left:60px;">·<a href="positionchange.jsp" target="mainFrame">职务变动</a></div> 
        </div>
	  <div id="pNodel_sub4" onclick="showList(this.id)" style="padding-left:40px; cursor:pointer;">.<a href="specialSalaryFunChoose.jsp" target="mainFrame" style="font-size:18px; color:#333;">特殊情况工资变动</a></div>
     
</div> 
 <div id="pNode1_sub3" onclick="showList(this.id);" style="padding-left:20px; cursor:pointer;">+ 工资发放管理</div> 
<div id="pNode1_sub3_ljf" style="display:none;"> 
<div id="pNode1_sub3_s1" style="padding-left:40px;">·<a href="autoSalary" target="mainFrame">每月工资生成</a></div> 
<div id="pNode1_sub3_s2" style="padding-left:40px;">·<a href="Querystatistics.jsp" target="mainFrame">历月工资查询统计</a></div> 
</div>    
</div> 

</fieldset>
	 </div>
	 </div>       		
	</body>
</html>
