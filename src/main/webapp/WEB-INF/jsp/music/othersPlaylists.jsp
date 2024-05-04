<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 플레이리스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
	
		<div class="d-flex justify-content-between">
			<c:import url="/WEB-INF/jsp/include/header.jsp" />
			<nav class="menu mt-3 ml-5">
				<ul class="nav nav-fill">
					<li class="nav-item name"><a class="nav-link" href="/spsound/main-view">Main</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/discover-view">Discover</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/playlist-view">My Library</a></li>
				</ul>
			</nav>	
		</div>
		
		<table class="table text-center mt-5">
			<thead>
				<tr>
					<th><i class="bi bi-music-player"></i></th>
					<th>Title</th>
					<th>Album</th>
					<th>Artist</th>
					<th><i class="bi bi-music-note-list"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="others" items="${userIdListExceptMe }">
				<tr>
					<td></td>
					<td class="pt-4"></td>
					<td class="pt-4">${others.userId}</td>
					<td class="pt-4">${others.count}</td>
					<td class="pt-4">
						<form class="d-flex" action="/spsound/othersPlaylists-view" method="get">
							<button type="submit" class="btn btn-block move" data-user-id="${others.userId}">보러가기</button>
	  					</form>
					</td>
										
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>	
<script>
	$(document).ready(function() {
		
		$(".move").on("click", function() {
			
			let userId = $(this).data("user-id");

			
			
			
		});
		
		
	});



</script>


</body>
</html>