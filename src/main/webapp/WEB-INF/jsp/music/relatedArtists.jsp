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
					<li class="nav-item name"><a class="nav-link" href="/spsound/playlist-view">My Library</a></li>
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
				</tr>
			</thead>
			<tbody>
				<c:forEach var="related" items="${relatedArtistsList }">
				<tr>
					<td><img src="${related.image }" width="64px" height="64px"></td>
					<td class="pt-4"><a href="${related.aritstInfoUrl }">${related.albumName }</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>

</body>
</html>