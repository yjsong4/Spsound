package com.syj.spsound.spotify.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;

import com.syj.spsound.music.dto.SearchResult;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

@Service
public class SpotifyService {

    private static final String CLIENT_ID = "153f64de7d1d4018b5245050eaf8bf9a";
    private static final String CLIENT_SECRET = "38ceb3923c414ca6ae5a00ea6fc15fb3";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENT_ID).setClientSecret(CLIENT_SECRET).build();

    public static String accesstoken() {
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            return spotifyApi.getAccessToken();

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            
            return "error";
        }
    }
    
	public List<SearchResult> searchByKeyword(String keyword) throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();
						
		SearchTracksRequest searchTrackRequest = spotifyApi.searchTracks(keyword)
                .limit(10)
                .build();
		
		List<SearchResult> searchResultList = new ArrayList<>();
		
		Paging<Track> searchResult = searchTrackRequest.execute();
		
		Track[] tracks = searchResult.getItems();
		
		for(Track track:tracks) {
			
			SearchResult result = new SearchResult();
			
			String songTitle = track.getName();
			
			AlbumSimplified album = track.getAlbum();
			ArtistSimplified[] artists = album.getArtists();
			
			ArrayList<String> aritstInfoUrlList = new ArrayList<>();
			ArrayList<String> artistNameList = new ArrayList<>();
			
			String aritstInfoUrl = "";
			String artistName = "";

			for(ArtistSimplified artist:artists) {
				aritstInfoUrl = artist.getExternalUrls().getExternalUrls().get("spotify");
				artistName = artist.getName();
				
				aritstInfoUrlList.add(aritstInfoUrl);
				artistNameList.add(artistName);
			}
		
			String albumName = album.getName();
			
			result.setAlbumName(albumName);
			result.setArtistNameList(artistNameList);
			result.setAritstInfoUrlList(aritstInfoUrlList);
			result.setSongTitle(songTitle);
			
			searchResultList.add(result);
			
			result.setArtistNameList(artistNameList);
		}
		
		 return searchResultList;
	}
    
}
