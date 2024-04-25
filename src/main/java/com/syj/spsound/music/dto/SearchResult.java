package com.syj.spsound.music.dto;

public class SearchResult {
	
	private String songTitle;
	private String artistName;
	private String artistInfoUrl;
	private String albumName;
	
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistInfoUrl() {
		return artistInfoUrl;
	}
	public void setArtistInfoUrl(String artistInfoUrl) {
		this.artistInfoUrl = artistInfoUrl;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

}
