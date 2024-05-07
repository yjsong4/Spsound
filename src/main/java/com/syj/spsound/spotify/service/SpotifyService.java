package com.syj.spsound.spotify.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neovisionaries.i18n.CountryCode;
import com.syj.spsound.music.domain.Artist;
import com.syj.spsound.music.dto.SearchResult;
import com.syj.spsound.music.repository.MusicRepository;
import com.syj.spsound.music.service.MusicService;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.ExternalUrl;
import se.michaelthelin.spotify.model_objects.specification.Image;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsRelatedArtistsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistsTopTracksRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetSeveralTracksRequest;

@Service
public class SpotifyService {

    private static final String CLIENT_ID = "153f64de7d1d4018b5245050eaf8bf9a";
    private static final String CLIENT_SECRET = "38ceb3923c414ca6ae5a00ea6fc15fb3";
    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENT_ID).setClientSecret(CLIENT_SECRET).build();

    @Autowired
    private MusicService musicService;
    
    @Autowired
    private MusicRepository musicRepository;
    
//	@Autowired
//	private UserService userService;
    
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
                .limit(50)
                .build();
		
		List<SearchResult> searchResultList = new ArrayList<>();
		
		Paging<Track> searchResult = searchTrackRequest.execute();
		
		Track[] tracks = searchResult.getItems();
		
		for(Track track:tracks) {
			
			SearchResult result = new SearchResult();
			
			String songTitle = track.getName();
			String musicId = track.getId();
			
			AlbumSimplified album = track.getAlbum();
			
			Image[] images = album.getImages();
			
			for(Image image:images) {
				String imageUrl = image.getUrl();
				result.setImage(imageUrl);
			}
			
			ArtistSimplified[] artists = album.getArtists();
			String albumName = album.getName();

//			ArrayList<String> aritstInfoUrlList = new ArrayList<>();
			ArrayList<String> artistNameList = new ArrayList<>();
			
//			String aritstInfoUrl = "";
			String artistName = "";

			for(ArtistSimplified artist:artists) {
//				aritstInfoUrl = artist.getExternalUrls().getExternalUrls().get("spotify");
				artistName = artist.getName();
				
//				aritstInfoUrlList.add(aritstInfoUrl);
				artistNameList.add(artistName);
			}
		
			result.setAlbumName(albumName);
			result.setArtistNameList(artistNameList);
//			result.setAritstInfoUrlList(aritstInfoUrlList);
			result.setSongTitle(songTitle);
			result.setMusicId(musicId);
			
			searchResultList.add(result);
		}
		
		 return searchResultList;
	}
	
	public List<SearchResult> getPlaylist(int userId) throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();

		List<SearchResult> playlist = new ArrayList<>();
		
		List<String> musicIdList = musicService.musicIdList(userId);
		
		String[] arr = new String[musicIdList.size()];
		musicIdList.toArray(arr);
		
		GetSeveralTracksRequest getTrackRequest = spotifyApi.getSeveralTracks(arr)
				.build();
		
		Track[] tracks = getTrackRequest.execute();
		
		for(Track track:tracks) {
			
			SearchResult trackResult = new SearchResult();
			
			String songTitle = track.getName();
			
			AlbumSimplified albums = track.getAlbum();
			String albumName = albums.getName();
			Image[] images = albums.getImages();
			
			for(Image image:images) {
				String imageUrl = image.getUrl();
				trackResult.setImage(imageUrl);
			}
			
			ArtistSimplified[] artists = track.getArtists();		
			
			ArrayList<String> artistNameList = new ArrayList<>();
			
			for(ArtistSimplified artist:artists) {
				String artistName = artist.getName();
				artistNameList.add(artistName);
			}
			
			trackResult.setMusicId(track.getId());
			trackResult.setSongTitle(songTitle);
			trackResult.setArtistNameList(artistNameList);
			trackResult.setAlbumName(albumName);
			
			playlist.add(trackResult);
		}
	
		return playlist;
	}
		
	public List<SearchResult> getArtistTopTrack(int userId) throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();
	
		List<Artist> userArtistList = musicRepository.selectArtistList(userId);
		List<SearchResult> artistTopTrackList = new ArrayList<>();

		String artistId ="";
		for(Artist artist:userArtistList) {
			
			artistId = artist.getArtistId();
			GetArtistsTopTracksRequest getArtistsTopTracksRequest = spotifyApi.getArtistsTopTracks(artistId, CountryCode.US)
					.build();
			
			Track[] tracks = getArtistsTopTracksRequest.execute();
			
			for(Track track:tracks) {
				
				SearchResult trackResult = new SearchResult();
				
				String songTitle = track.getName();
				String albumName = track.getAlbum().getName();
				
				Image[] images = track.getAlbum().getImages();
				for(Image image:images) {
					String imageUrl = image.getUrl();
					trackResult.setImage(imageUrl);
				}
				
				ArtistSimplified[] artists = track.getArtists();
				ArrayList<String> artistNameList = new ArrayList<>();
				for(ArtistSimplified artist1:artists) {
					String artistName = artist1.getName();
					artistNameList.add(artistName);
				}
				
				trackResult.setMusicId(track.getId());
				trackResult.setAlbumName(albumName);
				trackResult.setArtistNameList(artistNameList);
				trackResult.setSongTitle(songTitle);
				
				artistTopTrackList.add(trackResult);
			}
		}
		
		return artistTopTrackList;
	}
	
	public List<SearchResult> getRelatedArtists(int userId) throws ParseException, SpotifyWebApiException, IOException {
		
		SpotifyApi spotifyApi = new SpotifyApi.Builder()
	            .setAccessToken(SpotifyService.accesstoken())
	            .build();
	
		List<Artist> userArtistList = musicRepository.selectArtistList(userId);
		List<SearchResult> relateArtistList = new ArrayList<>(); 
		
		String artistId ="";
		
		for(Artist artist:userArtistList) {
			
			artistId = artist.getArtistId();
			
			GetArtistsRelatedArtistsRequest getArtistsRelatedArtistsRequest = spotifyApi.getArtistsRelatedArtists(artistId)
					.build();
		
			se.michaelthelin.spotify.model_objects.specification.Artist[] artists = getArtistsRelatedArtistsRequest.execute();
		
			for(se.michaelthelin.spotify.model_objects.specification.Artist related:artists) {
				
				SearchResult artistResult = new SearchResult();

				String artistName = related.getName();
				ExternalUrl externalUrl = related.getExternalUrls();
				// ExternalUrl(externalUrls={spotify=https://open.spotify.com/artist/1mcTU81TzQhprhouKaTkpq})
				String urls = externalUrl.toString().substring(34, 88);

				String[] arr = related.getGenres();
				List<String> genreList = Arrays.asList(arr);
				
				Image[] images = related.getImages();
				for(Image image:images) {
					String imageUrl = image.getUrl();
					artistResult.setImage(imageUrl);
				}
			
				artistResult.setArtistGenre(genreList);
				artistResult.setAlbumName(artistName);
				artistResult.setAritstInfoUrl(urls);
				artistResult.setPopularity(related.getPopularity());
				relateArtistList.add(artistResult);
			}
		}
		
		return relateArtistList;
	}
		
}