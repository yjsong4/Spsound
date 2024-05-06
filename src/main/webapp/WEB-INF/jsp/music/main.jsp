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
					<li class="nav-item name"><a class="nav-link" href="/spsound/main-view">Main</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/discover-view">Discover</a></li>
					<li class="nav-item name"><a class="nav-link" href="/spsound/playlist-view">My Library</a></li>
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

				<div class="d-flex text-center mt-3">
					<div class="d-flex">
						<div class="playlist">
							<a href="/spsound/artistTopTrack-view"><img src="https://images.ctfassets.net/ojtnytzl1djm/3PvcCJcvaQAfcq3XQ9dY8d/69ab8929d686cc7a7d175651c0914643/Voices.png?w=700&fm=webp&q=80" width="150px" height="150px"></a>
							<div class="track-info">Artists Top Track</div>		
						</div>
						<div class="playlist">
							<a href="/spsound/relatedArtists-view"><img src="https://images.ctfassets.net/ojtnytzl1djm/60TKcNg9WaRjOdf19ndYl3/5a7cde2eab022847ae2c7e759e646a7b/Whoosh.png?w=700&fm=webp&q=80" width="150px" height="150px"></a>
							<div class="track-info">Related Artists</div>
						</div>			
					</div>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
<script>
	

</script>

</body>
</html>