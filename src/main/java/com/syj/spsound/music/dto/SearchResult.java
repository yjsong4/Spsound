package com.syj.spsound.music.dto;

import java.util.List;

public class SearchResult {
	
	private String songTitle;
	private String albumName;
	private List<String> artistNameList;
	private List<String> aritstInfoUrlList;
	
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
	public List<String> getArtistNameList() {
		return artistNameList;
	}
	public void setArtistNameList(List<String> artistNameList) {
		this.artistNameList = artistNameList;
	}
	public List<String> getAritstInfoUrlList() {
		return aritstInfoUrlList;
	}
	public void setAritstInfoUrlList(List<String> aritstInfoUrlList) {
		this.aritstInfoUrlList = aritstInfoUrlList;
	}	

}
