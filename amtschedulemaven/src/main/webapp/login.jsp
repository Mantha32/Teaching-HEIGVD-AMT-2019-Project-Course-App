<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	HttpSession ses = request.getSession();
	ses.invalidate();
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Connection</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta
			content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
			name="viewport">
	<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet"
		  href="bower_components/bootstrap/dist/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet"
		  href="bower_components/font-awesome/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet"
		  href="bower_components/Ionicons/css/ionicons.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="dist/css/AdminLTE.min.css">

	<link rel="stylesheet" href="css/index.css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	<!-- Google Font -->
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition login-page">
<div class="login-box">
	<div class="login-logo">
		<a><strong>Planing</strong></a>
	</div>
	<!-- /.login-logo -->
	<div class="login-box-body">
		<p class="login-box-msg">Connection</p>
		<button class="btn-error"></button>
		<form method="" action="#">
			<div class="form-group has-feedback">
				<input type="text" class="form-control input-field" placeholder="username"
					   required id="username"> <span
					class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control input-field"
					   placeholder="mot de passe" required id="pass">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<select class="form-control" id="type">
				</select>
			</div>
			<div class="row">
				<div class="col-xs-4 pull-right">
					<button type="button" class="btn btn-primary btn-block btn-flat "
							id="con">Connecter</button>
				</div>
				<!-- /.col -->
			</div>
		</form>
		<a href="#">mot de passe oublié</a><br>
	</div>
	<!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
	(function($) {
		function populate_types() {
			$.get('roles', function(data) {
				var val = data.split(',');
				$('#type').find($('option')).remove();
				for ( var i = 0; i < val.length; i++) {
					if (val[i] != "\r\n") {
						$('#type').append(
								$('<option></option>').val(val[i]).html(
										val[i]));
					}
				}
			});
			$('#con').on('click', function(){
				$('.err').removeClass('err');
				$.post('Authentication', {
					username: $('#username').val(),
					pass: $('#pass').val(),
					role: $('#type').val()
				}, function(page){
					window.location = page;
				}).fail(function(err){
					var xmlResp = $.parseXML(err.responseText);
					var field = $(xmlResp).find("err").find("field");
					if (field.text() == 'all') {
						$('.input-field').addClass('err');
					} else {
						$('#'+field.text()+'').addClass('err');
					}
				});
			});
		}

		setTimeout(populate_types, 5000);
	})(jQuery);
</script>
</body>

</html>