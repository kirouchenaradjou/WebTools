
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Insurance | User Registration Form</title>

<!-- Loading third party fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700|"
	rel="stylesheet" type="text/css">
<link href="${contextPath}/fonts/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="${contextPath}/fonts/lineo-icon/style.css" rel="stylesheet"
	type="text/css">

<!-- Loading main css file -->
<link rel="stylesheet" href="${contextPath}/style.css">
</head>
<body>
	<div id="site-content">
		<header class="site-header">
			<div class="top-header">
				<div class="container">
					<a href="${contextPath}/insurance/login.htm" id="branding"> <img
						src="${contextPath}/images/logo.png"
						alt="Assurance Insurance Group" class="logo">
						<div class="logo-text">
							<h1 class="site-title">Assurance Company Group</h1>
							<small class="description">Welcome to my Page!</small>
						</div>
					</a>
					<!-- #branding -->

					<div class="right-section pull-right">
						<a href="#" class="phone"><img src="images/icon-phone.png"
							class="icon">+1 823 424 9134</a>

						<form action="#" class="search-form">
							<input type="text" placeholder="Search...">
							<button type="submit">
								<img src="${contextPath}/images/icon-search.png" alt="">
							</button>
						</form>
					</div>
				</div>
				<!-- .container -->
			</div>
			<!-- .top-header -->


			<div class="bottom-header">
				<div class="container">
					<div class="main-navigation">
						<button type="button" class="menu-toggle">
							<i class="fa fa-bars"></i>
						</button>
						<ul class="menu">
							<li class="menu-item"><a
								href="${contextPath}/insurance/forgotpassword.htm">Forgot
									User Name?</a></li>
							<li class="menu-item"><a href="insurance.html">Insurance
									plans</a></li>
							<li class="menu-item"><a
								href="${contextPath}/insurance/userCreate.htm">Register New
									User</a></li>
							<li class="menu-item current-menu-item"><a
								href="contact.html">Contact</a></li>
						</ul>
						<!-- .menu -->
					</div>
					<!-- .main-navigation -->

					<div class="social-links">
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-google-plus"></i></a> <a href="#"><i
							class="fa fa-pinterest"></i></a>
					</div>

					<div class="mobile-navigation"></div>
				</div>
			</div>

		</header>
		<!-- .site-header -->

		<main class="main-content">
		<div class="breadcrumbs">
			<div class="container">
				<a href="${contextPath}/insurance/login.htm">Home</a> <span>Register New User</span>
			</div>
		</div>

		<div class="page">
			<div class="container">

				<div class="row">
					<div class="col-md-3">
						
					</div>
					<div class="col-md-9">
						<h2 class="section-title text-left">User Login Form</h2>
						<font color="red">${errorMessage}</font>
						<form:form action="${contextPath}/insurance/userCreate.htm"
							commandName="user" method="post">
							<table>
								<tr>
									<td>User Email:</td>
									<td><form:input path="person.userEmail" size="30"
											type="email" required="required" /> <font color="red"><form:errors
												path="person.userEmail" /></font></td>
								</tr>

								<tr>
									<td>Password:</td>
									<td><form:password path="person.password" size="30"
											required="required" /> <font color="red"><form:errors
												path="person.password" /></font></td>
								</tr>
								<tr>
									<td>First Name:</td>
									<td><form:input path="firstName" size="30"
											required="required" /> <font color="red"><form:errors
												path="firstName" /></font></td>
								</tr>
								<tr>
									<td>Last Name:</td>
									<td><form:input path="lastName" size="30"
											required="required" /> <font color="red"><form:errors
												path="lastName" /></font></td>
								</tr>
								<tr>
									<td>Contact Number:</td>
									<td><form:input path="phoneNumber" size="40"
											required="required" /> <font color="red"><form:errors
												path="phoneNumber" /></font></td>
								</tr>
								<tr>
									<td>Date Of Birth:</td>
									<td><form:input type="date" path="dob" size="30"
											required="required" /> <font color="red"><form:errors
												path="dob" /></font></td>
								</tr>
								<tr>
									<td>Address :</td>
									<td><form:input path="address" size="30"
											required="required" /> <font color="red"><form:errors
												path="address" /></font></td>
								</tr>
								<tr>
									<td>Company Name - If an Employee :</td>
									<td><form:input path="company_name" size="30"
											required="required" /> <font color="red"><form:errors
												path="company_name" /></font></td>
								</tr>

								<tr>
									<td>Credit Card Numnber:</td>
									<td><form:input path="creditCardNum" size="30"
											required="required" /> <font color="red"><form:errors
												path="creditCardNum" /></font></td>
								</tr>

								<tr>
									<td colspan="2"><label for="captchaCode" class="prompt">Retype
											the characters from the picture:</label> <%
 									// Adding BotDetect Captcha to the page
 							Captcha captcha = Captcha.load(request, "CaptchaObject");
 		captcha.setUserInputID("captchaCode");

 		String captchaHtml = captcha.getHtml();
 		out.write(captchaHtml);
 %> <input id="captchaCode" type="text" name="captchaCode"
										required="required" /></td>
								</tr>

								<tr>
									<td colspan="2"><input type="submit" value="Register" /></td>
								</tr>

							</table>
						</form:form>

					</div>
				</div>
			</div>
		</div>
		<!-- .page --> </main>

		<div class="site-footer">
			<div class="widget-area">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Contact</h3>
								<address>Company Name INC. 523 Burt Street, Omaha</address>
								<a href="#">Phone: +1 823 424 9134</a> <a
									href="mailto:info@company.com">info@company.com</a>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Company</h3>
								<ul class="no-bullet">
									<li><a href="#">About us</a></li>
									<li><a href="#">Infoline</a></li>
									<li><a href="#">Team</a></li>
									<li><a href="#">Join us</a></li>
									<li><a href="#">Cooperation</a></li>
								</ul>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Products</h3>
								<ul class="no-bullet">
									<li><a href="#">Life insurance</a></li>
									<li><a href="#">Home insurance</a></li>
									<li><a href="#">Car insurance</a></li>
									<li><a href="#">Business insurance</a></li>
									<li><a href="#">Investment insurance</a></li>
								</ul>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Our Solutions</h3>
								<ul class="no-bullet">
									<li><a href="#">Presentation</a></li>
									<li><a href="#">Testimonials</a></li>
									<li><a href="#">Examples</a></li>
									<li><a href="#">Our experts</a></li>
									<li><a href="#">Resources</a></li>
								</ul>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Press Room</h3>
								<ul class="no-bullet">
									<li><a href="#">Advertisement</a></li>
									<li><a href="#">Interviews</a></li>
									<li><a href="#">Hot news</a></li>
									<li><a href="#">Photos</a></li>
									<li><a href="#">Marketing</a></li>
								</ul>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-2">
							<div class="widget">
								<h3 class="widget-title">Resources</h3>
								<ul class="no-bullet">
									<li><a href="#">Sed imperdiet magna</a></li>
									<li><a href="#">Pellentesque molestie</a></li>
									<li><a href="#">Nulla luctus cursus</a></li>
									<li><a href="#">Ligula vel lacinia</a></li>
									<li><a href="#">Mauris scelerisque</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="bottom-footer">
				<div class="container">
					<nav class="footer-navigation">
						<a href="#">Home</a> <a href="#">About us</a> <a href="#">Insurance
							plans</a> <a href="#">Resources</a> <a href="#">Contact</a>
					</nav>

					<div class="colophon">Copyright 2014 Company name. Designed
						by Themezy. All rights reserved.</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${contextPath}/js/jquery-1.11.1.min.js"></script>
	<script
		src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
	<script src="${contextPath}/js/plugins.js"></script>
	<script src="${contextPath}/js/app.js"></script>
</body>
</html>