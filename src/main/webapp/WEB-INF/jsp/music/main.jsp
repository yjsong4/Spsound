<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
	
		<div class="d-flex justify-content-between">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<nav class="menu mt-3 ml-5">
				<ul class="nav nav-fill">
					<li class="nav-item name"><a class="nav-link" href="#">Main</a></li>
					<li class="nav-item name"><a class="nav-link" href="#">Discover</a></li>
					<li class="nav-item name"><a class="nav-link" href="#">My Library</a></li>
				</ul>
			</nav>	
		</div>
		
		<div class="content-box d-flex justify-content-between">
			<img class="img bg-secondary" src="https://images.ctfassets.net/js6ap5wzepad/5r2jhT1LonYgfLVuB7UYoh/744f35dae83be88ba8239456345c924e/enterprise-image.png?w=700&fm=avif&q=80">
			
			<div>
				<div class="introduce">Experience new playlists in SPsound!</div>
				
				<nav class="search">
					<div>
						<form class="d-flex" action="/spsound/tracklist-view" method="get">
    						<input class="form-control mr-3 search-input" type="text" name="keyword">
    						<button class="btn search-btn" id="searchBtn" type="submit">Search</button>
  						</form>
					</div>
				</nav>

				<div class="music-box d-flex text-center">
					<div class="playlist">playlist1</div>
					<div class="playlist">playlist2</div>
					<div class="playlist">playlist3</div>
				</div>
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	
	$(document).ready(function() {
		

	});
	
</script>

</body>
</html>