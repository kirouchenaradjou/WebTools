<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>Insurance | User Dashboard</title>

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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
	.planStyle
	{
	color:black;
	font-weight: bold;
	font-family: cursive;
	font-size: 15px;
	background-color: white;
	}
	</style>
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
						<h1 class="site-title">Assurance Insurance Group</h1>
						<small class="description">You are at the right place!</small>
					</div>
				</a>
				<!-- #branding -->

				<div class="right-section pull-right">
					<a href="#" class="phone"><img src="${contextPath}/images/icon-phone.png"
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
								plans - Register for one</a></li>
						<li class="menu-item"><a
							href="${contextPath}/insurance/userCreate.htm">Dashboard</a></li>
						<li class="menu-item current-menu-item"><a
							href="${contextPath}/insurance/logOff.htm">Log Out</a></li>
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
				<a href="${contextPath}/insurance/login.htm">Home</a> <span>Dashboard</span>
			</div>
		</div>
<div class="page">
					<div class="container">
						<h3 class="entry-title">Choose your own insurance plan</h3>
						<p>Nam posuere purus vitae est sollicitudin placerat. Praesent posuere porta dignissim. Phasellus viverra, urna a convallis tincidunt, ante mi tempor turpis, nec tempor mauris ligula ut sapien. Etiam euismod mi eu ante mollis commodo. Suspendisse porta nisi vitae dui hendrerit, eget ornare orci semper. Phasellus pharetra, erat sit amet rutrum porttitor, est eros consectetur elit, molestie consequat erat tellus in dui. Vestibulum a vehicula sem. Nullam commodo quis purus in volutpat. Integer semper lacus a lorem efficitur auctor curabitur tincidunt ligula non.</p>

						<div class="filter-links filterable-nav">
							<select class="mobile-filter">
								<option value="*">Show all</option>
								<option value=".skyscraper">skyscraper</option>
								<option value=".shopping-center">shopping-center</option>
								<option value=".apartment">apartment</option>
							</select>
							<strong>Select Category: </strong>
							<a href="#" class="current wow fadeInRight" data-filter="*">Show all</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".2s" data-filter=".skyscraper">skyscraper</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".4s" data-filter=".shopping-center">shopping-center</a>
							<a href="#" class="wow fadeInRight" data-wow-delay=".6s" data-filter=".apartment">apartment</a>
						</div>

						<div class="filterable-items">
							<div class="insurance-item filterable-item shopping-center">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-sofa"></i></div>
									<h3 class="insurance-title">Safe Hourse</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>
						

							<div class="insurance-item filterable-item skyscraper">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-pool"></i></div>
									<h3 class="insurance-title">Happy Holiday</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-nurse"></i></div>
									<h3 class="insurance-title">Medical 24</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item shopping-center">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-weigher"></i></div>
									<h3 class="insurance-title">Financial Balance</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item apartment">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-car"></i></div>
									<h3 class="insurance-title">Car Protect</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>

							<div class="insurance-item filterable-item skyscraper">
								<div class="insurance-content">
									<div class="insurance-icon"><i class="icon-shirt"></i></div>
									<h3 class="insurance-title">Bussiness Insurance</h3>
									<p>Etiam aliquam ante in mattis molestie. Vivamus in laoreet eros. Proin tempus velit dui lobortis justo laoreet nes phasellus luctus neque.</p>
									<a href="#" class="button">See details</a>
								</div>
							</div>
						</div>

						<div class="pagination">
							<span class="current">1</span>
							<a href="#">2</a>
							<a href="#">3</a>
						</div>
					</div>
				</div> <!-- .page -->
		<div class="page">
			<div class="container">

				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-9">
						<h2 class="section-title text-left">See the plan details below</h2>

						<form action="${contextPath}/insurance/confirmPlan.htm"
							method="POST">
							Select a plan : <select id="planSelection" name="planSelection">
								<option>..Select..</option>
								<option value="1">Platinum</option>
								<option value="2">Gold</option>
								<option value="3">Silver</option>
								<option value="4">Bronze</option>
							</select> <br />
							<div id="divToDisplayPlans">..Plan details is displayed
								here..</div>
								<br>
							<input type="submit" id="confirmPlan" style="display: none"
								value="Confirm the Plan" />
						</form>
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
					<nav class="footer-navigation"> <a href="#">Home</a> <a
						href="#">About us</a> <a href="#">Insurance plans</a> <a href="#">Resources</a>
					<a href="#">Contact</a> </nav>

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
<script>
	$('select').on('change', function() {
		var planID = $(this).val();
		$.ajax({
			url : "getPlanDetails.htm",
			type : 'POST',
			data : {
				planID : planID
			},
			success : function(data) {
				$('#divToDisplayPlans').html(data);
				$('#confirmPlan').show();
			},
			error : function(request, error) {
				alert("Request Error: " + JSON.stringify(request));
			}
		});
	});
</script>
</html>