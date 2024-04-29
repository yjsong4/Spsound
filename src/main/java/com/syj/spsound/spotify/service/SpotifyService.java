package com.syj.spsound.spotify.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syj.spsound.music.domain.Playlist;
import com.syj.spsound.music.dto.SearchResult;
import com.syj.spsound.music.service.MusicService;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

@Service
public class SpotifyService {

    private static final String CLIENT_ID = "153f64de7d1d4018b5245050eaf8bf9a";
    private static final String CLIENT_SECRET = "38ceb3923c414ca6ae5a00ea6fc15fb3";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENT_ID).setClientSecret(CLIENT_SECRET).build();

    @Autowired
    private MusicService musicService;
    
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
			String musicId = track.getId();
			
			
			AlbumSimplified album = track.getAlbum();
			
//			Image[] images = album.getImages();
//			
//			for(Image image:images) {
//				image.getUrl();
//			}
			
			ArtistSimplified[] artists = album.getArtists();
			String albumName = album.getName();

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
		
			result.setAlbumName(albumName);
			result.setArtistNameList(artistNameList);
			result.setAritstInfoUrlList(aritstInfoUrlList);
			result.setSongTitle(songTitle);
			result.setMusicId(musicId);
			
			searchResultList.add(result);
		}
		
		 return searchResultList;
	}
	
	public List<SearchResult> getPlaylist(int userId, String musicId) throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();
		
		List<Playlist> musicIdList = musicService.musicId(userId);
		
		for(Playlist musicIds:musicIdList) {
			musicId = musicIds.getMusicId();
		}
					
		GetTrackRequest getTrackRequest = spotifyApi.getTrack(musicId)
                .build();
		
		List<SearchResult> playlist = new ArrayList<>();
		
		Track track = getTrackRequest.execute();
		
		for(SearchResult trackResult:playlist) {
			
			String songTitle = track.getName();
			AlbumSimplified albums = track.getAlbum();
			String albumName = albums.getName();
			
			ArtistSimplified[] artists = track.getArtists();		
			
			ArrayList<String> artistNameList = new ArrayList<>();
			
			for(ArtistSimplified artist:artists) {
				String artistName = artist.getName();
				artistNameList.add(artistName);
			}
			
			trackResult.setSongTitle(songTitle);
			trackResult.setArtistNameList(artistNameList);
			trackResult.setAlbumName(albumName);
			
			playlist.add(trackResult);
		}
		
		return playlist;
	}
	
}
