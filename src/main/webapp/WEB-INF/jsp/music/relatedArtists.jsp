<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연관 아티스트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
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
					<li class="nav-item name"><a class="nav-link" href="/spsound/playlist-view?userId=${userId }">My Library</a></li>
				</ul>
			</nav>	
		</div>
		
		<div class="d-flex justify-content-between mt-5">
			<div class="d-flex align-items-center playlist-box3">
				<div class="flex-column ml-5">
					<div class="playtext1">ARTISTS</div>
					<div class="playtext2">Similar to a Given Artist!</div>
				</div>
			</div>
			<div><img src="https://cdn.epidemicsound.com/curation-assets/playlist-cover-images/e3e20af7-02ff-459d-89ba-0facd5f13580/400x400.jpeg" width="300px" height="300px"></div>
		</div>
		
		<table class="table text-center mt-5">
			<thead>
				<tr>
					<th><i class="bi bi-music-player"></i></th>
					<th>Artist</th>
					<th>Genre</th>
					<th>Popularity</th>
					<th><i class="bi bi-music-note-list"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="related" items="${relatedArtistsList }">
				<tr>
					<td><img src="${related.image }" width="64px" height="64px"></td>
					<td class="pt-4"><a id="related" href="${related.aritstInfoUrl }">${related.artistName }</a></td>
					<td class="pt-4">${related.artistGenre }</td>
					<td class="pt-4">${related.popularity }</td>
					<td class="pt-4 d-flex">			
						<button type="button" class="btn btn-block add-btn" data-artist-id="${related.artistId }" data-name-id="${related.artistName }"><i class="bi bi-plus-lg"></i></button>
						<button type="button" class="btn btn-block delete-btn" data-name-id="${related.artistName }"><i class="bi bi-dash-lg bi-type-bold"></i></button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
			
		
		$(".add-btn").on("click", function() {
			
		let artist = $(this).data("name-id");
		let artistId = $(this).data("artist-id");
			
			$.ajax({
				type:"post"
				, url:"/music/select/artist"
				, data:{"artist":artist, "artistId":artistId}
				, success:function(data) {
					
					if(data.result == "success") {
						alert("관심 아티스트 목록에 저장되었습니다.");
					} else {
						alert("음악가 저장 실패");
					}
				}
				, error:function() {
					alert("이미 저장된 아티스트입니다.");
				}
			});
			
		});
		
		$(".delete-btn").on("click", function() {
			
			let artist = $(this).data("name-id");
			
			$.ajax({
				type:"delete"
				, url:"/music/delete/artist"
				, data:{"artist":artist}
				, success:function(data) {
					
					if(data.result == "success") {
						alert("관심 아티스트 목록에서 삭제되었습니다.");
					} else {
						alert("음악가 삭제 실패");
					}
				}
				, error:function() {
					alert("음악가 삭제 에러");
				}
			});
			
		});
	});
</script>
</body>
</html>