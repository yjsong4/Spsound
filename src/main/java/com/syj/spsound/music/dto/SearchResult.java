package com.syj.spsound.music.dto;

import java.util.List;

public class SearchResult {

	private String songTitle;
	private String albumName;
	private String musicId;
	private String image;
	private String aritstInfoUrl;
	private int popularity;
	private List<String> artistGenre;
	private List<String> artistNameList;
	
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getMusicId() {
		return musicId;
	}
	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAritstInfoUrl() {
		return aritstInfoUrl;
	}
	public void setAritstInfoUrl(String aritstInfoUrl) {
		this.aritstInfoUrl = aritstInfoUrl;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public List<String> getArtistGenre() {
		return artistGenre;
	}
	public void setArtistGenre(List<String> artistGenre) {
		this.artistGenre = artistGenre;
	}
	public List<String> getArtistNameList() {
		return artistNameList;
	}
	public void setArtistNameList(List<String> artistNameList) {
		this.artistNameList = artistNameList;
	}
	
}
