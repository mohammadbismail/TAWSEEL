<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/register.css" />
<body>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-lg-6 ">
				<div class="card">
					<h1>
						<span style="color: rgba(43, 171, 217, 1);">TAWSEEL</span>
						<div class="scroller">
							<span> ORDER<br /> FOOD<br /> ANYWHERE<br /> IN
								PALESTINE
							</span>
						</div>

					</h1>
					<p class="note"></p>
				</div>
			</div>
			<div class="col-12 col-lg-4">
				<div class="cont">
					<div class="forms">
						<div class="form login">
							<span class="title">Login</span>

							<form action="/login">
								<div class="input-field">
									<input type="text" placeholder="Enter your email" required>
									<i class="uil uil-envelope icon"></i>
								</div>
								<div class="input-field">
									<input type="password" class="password"
										placeholder="Enter your password" required> <i
										class="uil uil-lock icon"></i> <i
										class="uil uil-eye-slash showHidePw"></i>
								</div>

								<div class="checkbox-text">
									<div class="checkbox-content">
										<input type="checkbox" id="logCheck"> <label
											for="logCheck" class="text">Remember me</label>
									</div>

									<a href="#" class="text">Forgot password?</a>
								</div>

								<div class="input-field button">
									<input type="submit" value="Login">
								</div>
							</form>

							<div class="login-signup">
								<span class="text">Not a member? <a href="#"
									class="text signup-link">Signup Now</a>
								</span>
							</div>
						</div>

						<!-- Registration Form -->
						<div class="form signup">
							<span class="title">Registration</span>

							<form action="/register">
								<div class="input-field">
									<input type="text" placeholder="Enter your name" required>
									<i class="uil uil-user"></i>
								</div>
								<div class="input-field">
									<input type="text" placeholder="Enter your email" required>
									<i class="uil uil-envelope icon"></i>
								</div>
								<div class="input-field">
									<input type="tel" placeholder="Enter your mobile" required>
									<i class="uil uil-phone"></i>
								</div>
								<div class="input-field">
									<input type="password" class="password"
										placeholder="Create a password" required> <i
										class="uil uil-lock icon"></i>
								</div>
								<div class="input-field">
									<input type="password" class="password"
										placeholder="Confirm a password" required> <i
										class="uil uil-lock icon"></i> <i
										class="uil uil-eye-slash showHidePw"></i>
								</div>
								<div class="input-field button">
									<input type="button" value="Signup">
								</div>
							</form>

							<div class="login-signup">
								<span class="text">Already a member? <a href="#"
									class="text login-link">Login Now</a>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="/js/register.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>