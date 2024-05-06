<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
	
		<div class="d-flex justify-content-between">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<nav class="menu mt-4 ml-5">
				<ul class="nav nav-fill">
					<li class="nav-item name"><a class="nav-link" href="/spsound/main-view">Main</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/discover-view">Discover</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/playlist-view">My Library</a></li>
				</ul>
			</nav>	
		</div>

		<div class="music-box d-flex text-center justify-content-center align-items-center">
		
			<div class="playlist">
				<c:forEach var="others" items="${userIdListExceptMe }" varStatus="status">
				<div>${status.count} - userId : ${others.userId }</div>
				<a href="/spsound/othersPlaylists-view?userId=${others.userId }">이동</a>
				</c:forEach>
			</div>
			
			<div class="playlist">아티스트 3개 이상 같은 유저</div>
			
			<div class="playlist">
				<div>change selected contents</div>
				<a href="/spsound/select-genre-view"><img src="https://images.ctfassets.net/ojtnytzl1djm/66P7mcRleXxzLBOrMNNDmz/b1671e7dc2bf241b206125eed1020ad5/Whistle.png?w=700&fm=webp&q=80" width="64px" height="64px"></a>
				<div>genre</div>
				<a href="/spsound/select-artist-view"><img src="https://images.ctfassets.net/ojtnytzl1djm/66P7mcRleXxzLBOrMNNDmz/b1671e7dc2bf241b206125eed1020ad5/Whistle.png?w=700&fm=webp&q=80" width="64px" height="64px"></a>
				<div>artist</div>
			</div>
			
		</div>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

</body>
</html>