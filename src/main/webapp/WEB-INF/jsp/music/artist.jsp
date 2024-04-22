<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음악가선택</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<div id="wrap">
	
		<div class="circle-box position-relative">
			<c:forEach var="artist" items="${artistList }" varStatus="status">
				<c:choose>
					<c:when test="${artist.checked eq true }">
						<div class="circle text-white" id="floating${status.count }">${artist.name }</div>
						<c:set var="genreCount" value="${genreCount + 1 }" />
					</c:when>
					<c:otherwise>
						<div class="circle" id="floating${status.count }">${artist.name }</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		
		
		<div class="d-flex justify-content-between dd">
			<div>
				<i class="bi bi-chevron-left next-btn" onclick="location.href='/spsound/select-genre-view'"></i>
			</div>
		
			<div>
				<c:choose>
					<c:when test="${genreCount >= 3 }">
						<i class="bi bi-chevron-right next-btn" onclick="location.href='/spsound/main-view'"></i>
					</c:when>
					<c:otherwise>
						<i class="bi bi-chevron-right next-btn d-none" onclick="location.href='/spsound/main-view'"></i>
					</c:otherwise>
				</c:choose>	
			</div>
		</div>
		
	</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js" integrity="sha512-IQLehpLoVS4fNzl7IfH8Iowfm5+RiMGtHykgZJl9AWMgqx0AmJ6cRWcB+GaGVtIsnC4voMfm8f2vwtY+6oPjpQ==" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/ScrollToPlugin.min.js" integrity="sha512-nTHzMQK7lwWt8nL4KF6DhwLHluv6dVq/hNnj2PBN0xMl2KaMm1PM02csx57mmToPAodHmPsipoERRNn4pG7f+Q==" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	
	$(document).ready(function() {
		
		var clickCount = 0;
		
		$(".circle").on("click", function() {
			
			let artist = $(this).text();
			let check = $(this).data("checked");
			
			if(check == true) {
				
				$(this).data("checked", false);
				
				$.ajax({
					type:"delete"
					, url:"/music/delete/artist"
					, data:{"artist":artist}
					, success:function(data) {
						
						if(data.result == "success") {
							location.reload();
						} else {
							alert("음악가 삭제 실패");
						}
					}
					, error:function() {
						alert("음악가 삭제 에러");
					}
				});
				
			} else {
				
				$(this).data("checked", true);
				
				$.ajax({
					type:"post"
					, url:"/music/select/artist"
					, data:{"artist":artist}
					, success:function(data) {
						
						if(data.result == "success") {
							
							clickCount ++;
							alert(artist + " 선택");
							
							if(clickCount >= 3) {
								$(".next-btn").removeClass("d-none");
							}
						} else {
							alert("음악가 저장 실패");
						}
					}
					, error:function() {
						alert("음악가 선택 에러");
					}
				});
			}
			
		});
		
	});

	//범위 랜덤 함수(소수점 2자리까지)
	function random(min, max) {
	  // `.toFixed()`를 통해 반환된 문자 데이터를,
	  // `parseFloat()`을 통해 소수점을 가지는 숫자 데이터로 변환
	  return parseFloat((Math.random() * (max - min) + min).toFixed(2))
	}
	
	function floatingObject(selector,delay,size){
	  // gsap.to(요소, 시간, 옵션)
	  gsap.to(selector, random(1.5,2.5), {
	    y: size,
	    repeat: -1, // -1 무한반복
	    yoyo: true, // 애니메이션 되돌아오기(설정안할 시 끈킴)
	    ease: Power1.easeInOut, // 타이밍함수
	    delay: random(0,delay) // 지연시간
	  })
	}
	
	floatingObject('#floating1',1,15)
	floatingObject('#floating2',.5,15)
	floatingObject('#floating3',1.5,20)
	floatingObject('#floating4',1.5,20)
	floatingObject('#floating5',.2,15)
	floatingObject('#floating6',.2,15)
	floatingObject('#floating7',.2,15)
	floatingObject('#floating8',.2,15)
	floatingObject('#floating9',.2,15)
	floatingObject('#floating10',.2,15)
</script>

</body>
</html>