<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
	<% // String path=r equest.getContextPath(); // String basePath=r equest.getScheme()+"://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>
		<%@taglib prefix="s" uri="/struts-tags" %>
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="utf-8">
					<title>
						高校职工基本工资管理系统
					</title>
					<link href="css/login.css" rel="stylesheet" type="text/css"
					media="all" />
					<link href="css/demo.css" rel="stylesheet" rel="stylesheet" type="text/css"
					media="all" />
					<link href="css/bootstrap.min.css" rel="stylesheet">
					<script type="text/javascript" src="js/jquery-1.8.3.js">
					</script>
					<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js">
					</script>
						<script type="text/javascript" src="js/Validform_v5.3.2_min.js">
					</script>
					<script type="text/javascript">	
					/* 验证码刷新 */
						function initCaptcha() {
							var verifyObj = document.getElementById("Verify");
							verifyObj.onclick = function() {
								this.src = "initCaptcha?timestamp=" + new Date().getTime();
							};
						}
					/* 错误信息提示框 */
						function showError() {
							var errorInfo = "<%=session.getAttribute("loginErrorInfo")%>";
							<%session.removeAttribute("loginErrorInfo");%>
							if (errorInfo != "null" && errorInfo != "" && errorInfo != null) {			
									alert(errorInfo);
								}

						}

						showError();
					</script>
				</head>
				<body onload="initCaptcha()">
					<div class="header" style="width:900px;">
						<h1 class="headerLogo">
							<a title="" target="_blank" >
								<!-- <img alt="logo" src="img/logo.gif" style="margin-top:-3.6%;"> -->
							</a>
							<label id="header">高校职工基本工资管理系统</label>
						</h1>
					</div>
					<div class="banner">
						<div class="login-aside">
							<div id="o-box-up" style="margin-left:-15.4%;">
							</div>
							<div id="o-box-down" style="table-layout:fixed; margin-left:-10.4%;">
								<div class="error-box">
								</div>
								<form class="registerform" action="login" method="post">
									<div class="fm-item">
										<label for="logonId" class="form-label">
											账号
										</label>
										<input type="text" maxlength="6" name="user.id" class="i-text" placeholder="请输入6位职工号"
										/>
									</div>
									<div class="fm-item">
										<label for="logonId" class="form-label">
											密码
										</label>
										<input type="password" maxlength="10" name="user.password" class="i-text"
										 />
									</div>
									<div class="fm-item pos-r">
										<label for="logonId" class="form-label">
											验证码
										</label>
										<div style="float:left;">
											<input type="text" value="输入验证码" maxlength="10" size="8
											" name="inputCaptcha" id="yzm" class="i-text yzm" onfocus="javascript:if(this.value='输入验证码')this.value='';"
											/>
										</div>
										<div style="float:left;margin-left:2px;">
											<img src="initCaptcha" id="Verify" class="i-text yzm" style="cursor:hand;"
											alt="看不清，换一张" />
										</div>
									</div>
									<div class="fm-item">
										<div class="span12" style="margin-left:20%; margin-top:30%;">
											<button class="btn btn-info btn-block btn-large" type="submit">
												登陆
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="bd">
						</div>
					</div>
					<div class="banner-shadow">
					</div>
					<div class="footer">
						<p>
							<label>&copy;&nbsp;&nbsp;2017-2020&nbsp;&nbsp;</label>
							<label>版权所有&nbsp;&nbsp;翻版必究</label>
							
						</p>
					</div>
				</body>
			</html>