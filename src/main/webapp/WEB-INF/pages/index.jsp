
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="/media/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/media/css/bootstrap.css" rel="stylesheet" />
<link href="/media/css/main.css" rel="stylesheet" />
<link href="/media/css/custombootstrap.css" rel="stylesheet" />


<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<link type="text/css" rel="stylesheet"
	href="https://fast.fonts.net/cssapi/81267cf7-f76c-4108-91da-f40c1f61836f.css" />
<title>SMTP - Home</title>
</head>
<body>

	<div id="top"></div>
	<div id="state-header" class="display-block">
		<div class="container">
			<div class="row">
				<nav class="navbar-static-top" role="navigation">
					<div id="div_NavHeader"
						class="clearfix logo-container navbar-header">
						<a href="index.htm">
						 <img id="header-logo" src="/media/Images/thehartford.jpg">
						</img>
						</a>
					</div>
				</nav>
			</div>
		</div>

	</div>

	<!--CONTENT SECTION-->
	<div id="CFPB" class="container">
		<div class="col-xs-12 blue nexa-light">
			<br />
			<div class="jumbotron">
				<p style="text-align: center">Welcome to SMTP</p>
				<p style="text-align: center">Sending Email using Spring 4 with FreeMarker template !!!</p>
			</div>
		</div>
		<div class="col-xs-12 blue nexa-bold ">
			<form class="form-horizontal " action="/smtp/email" method="post">

				<div class="form-group">
					<label for="email" class="col-sm-3 control-label">From*</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" title="From Address"
							name="fromAddress" id="fromAddress"
							value="nrkreddy94@gmail.com" readonly="readonly" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-3 control-label">To*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" title="To Address"
							name="email" id="email" required="required">

					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-3 control-label">Subject*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" title="Subject"
							id="subject" name="subject"  required="required"/>
					</div>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-3 control-label">First
						Name*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" title="First Name"
							id="firstName" name="firstName" required="required" />
					</div>
				</div>

				<div class="form-group">
					<label for="phone" class="col-sm-3 control-label">Last
						Name*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" title="Last Name"
							id="lastName" name="lastName" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="extension" class="col-sm-3 control-label">Company*</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" title="Company"
							id="company" name="company" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label for="titleWaveOTP" class="col-sm-3 control-label">User
						Name*</label>
					<div class="col-sm-7">
						<input type="text" id="username" class="form-control"
							name="username" required="required"/>
					</div>
				</div>

				<div class="form-group col-sm-12 center">
					<button type="submit"
						class="btn btn-primary btn-md  form_next_button">Submit</button>

				</div>
			</form>
		</div>
	</div>


	<!-- Footer Container -->
	<div class="col-xs-12 fix-padding-left-right">
		<div id="Footer1" class="display-block">
			<div class="container" style="margin-top: 50px">
				<div class="col-xs-12 copyright">
					<br /> <br />Copyright &copy; 2017 The hartford.
					All rights reserved. | <a href="#"
						class="bold-on-hover" target="_blank"> Privacy Statement</a><br />
					<br />
				</div>
			</div>
		</div>
	</div>
	<!-- Close Footer Container -->



</body>

</html>


