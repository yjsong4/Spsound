package com.syj.spsound.spotify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syj.spsound.spotify.service.SpotifyService;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.requests.data.search.simplified.SearchArtistsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

@Controller
public class SpotifyController {
	
	private static final String accessToken = "BQDcSFF1JUi3-lWhBkr2wsAMBHQxsPTGr7U7a0fHPJ1j6S8C6Lszp8vz61fRPodN29VvH9oGrm7nbVJwxA1qQTKmiSYK09Oe_7iZaHIyyFJY3xxV3i0";
	private static final String q = "Taylor Swift";
	private static SpotifyApi spotifyApi;
	private static SearchArtistsRequest searchArtistsRequest;
	
	@Autowired
	private SpotifyService spotifyService;
	
	
	@GetMapping("/spotify/token")
	@ResponseBody
	public String token() {
		
//		String accessToken = SpotifyToken.accesstoken();
//				
//      RestTemplate rest = new RestTemplate();
//      HttpHeaders headers = new HttpHeaders();
//      headers.add("Authorization", "Bearer " + accessToken);
//      headers.add("Host", "api.spotify.com");
//      headers.add("Content-type", "application/json");
//      String body = "";
//
//      HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
//      ResponseEntity<String> responseEntity = rest.exchange("https://api.spotify.com/v1/search?type=track&q=" + "peaches", HttpMethod.GET, requestEntity, String.class);
//      HttpStatus httpStatus = (HttpStatus) responseEntity.getStatusCode();
//      int status = httpStatus.value(); //상태 코드가 들어갈 status 변수
//      String response = responseEntity.getBody();
//
//      return response;
		
		return SpotifyService.accesstoken();	
	}
	
	public String search() {
		
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken()) //accessToken()은 앞선 포스팅 참고
	            .build();
		
//		spotifyApi.setAccessToken(accesstoken());
		spotifyApi.setAccessToken(accessToken);
		
		spotifyService.GetSpotifyApi();
		
		SearchTracksRequest searchTrackRequest = spotifyApi.searchTracks(q)
                .limit(10)
                .build();
		

	}
	
}
