<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="input-box d-flex justify-content-center align-items-center">
			<div>
				<h1 class="text-center font-weight-bold main-text">Join</h1>
				<form>
					<input type="email" placeholder="email" size="36" class="form-control my-4" id="emailInput">
					<input type="password" placeholder="password" class="form-control my-4" id="passwordInput">
					<input type="password" placeholder="Confirm password" class="form-control" id="confirmPasswordInput">
					<button type="submit" class="btn btn-block text-white main-btn" id="joinBtn">JOIN</button>
				</form>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		
		$("#joinBtn").on("click", function() {
			
			let email = $("#emailInput").val();
			let password = $("#passwordInput").val();
			let confirmPassword = $("#confirmPasswordInput").val();
			const pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;

			if(email == "") {
				alert("이메일을 입력하세요.");
				return;
			}
		    if(pattern.test(email) == false) {
		    	alert("이메일 형식이 올바르지 않습니다");
		    	return;
		    }
			if(password == "") {
				alert("비밀번호를 입력하세요.");
				return;
			}
			if(password != confirmPassword) {
				alert("비밀번호가 일치하지 않습니다");
				return;			
			}
			
			$.ajax({
				type:"post"
				, url:"/user/join"
				, data:{"email":email, "password":password}
				, success:function(data) {
					if(data.result == "success") {
						location.href = "/user/login-view";
					} else {
						alert("가입 실패");
					}
				}
				, error:function() {
					alert("가입 에러");
				}
			
			});
			
		});
		
	});

</script>
</body>
</html>