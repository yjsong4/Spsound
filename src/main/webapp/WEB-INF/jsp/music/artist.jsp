<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음악가선택</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<div class="circle-box position-relative">
			<div class="circle" id="floating1">Pop</div>
			<div class="circle" id="floating2">Hip Hop</div>
			<div class="circle" id="floating3">Classical</div>
			<div class="circle" id="floating4">Latin</div>
			<div class="circle" id="floating5">Jazz</div>		
		</div>
	</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js" integrity="sha512-IQLehpLoVS4fNzl7IfH8Iowfm5+RiMGtHykgZJl9AWMgqx0AmJ6cRWcB+GaGVtIsnC4voMfm8f2vwtY+6oPjpQ==" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/ScrollToPlugin.min.js" integrity="sha512-nTHzMQK7lwWt8nL4KF6DhwLHluv6dVq/hNnj2PBN0xMl2KaMm1PM02csx57mmToPAodHmPsipoERRNn4pG7f+Q==" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>

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

</script>

</body>
</html>