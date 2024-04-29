package com.syj.spsound.music.dto;

import java.util.List;

import se.michaelthelin.spotify.model_objects.specification.Image;

public class SearchResult {
	
	private String songTitle;
	private String albumName;
	private String musicId;
	private Image[] image;
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
	public String getMusicId() {
		return musicId;
	}
	public void setMusicId(String musicId) {
		this.musicId = musicId;
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
	public Image[] getImage() {
		return image;
	}
	public void setImage(Image[] image) {
		this.image = image;
	}

}
