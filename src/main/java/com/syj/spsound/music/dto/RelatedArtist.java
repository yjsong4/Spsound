package com.syj.spsound.music.dto;

import java.util.List;

public class RelatedArtist implements Comparable<RelatedArtist> {
	
	private String image;
	private String artistId;
	private String artistName;
	private String aritstInfoUrl;
	private List<String> artistGenre;
	private int popularity;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getArtistId() {
		return artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAritstInfoUrl() {
		return aritstInfoUrl;
	}
	public void setAritstInfoUrl(String aritstInfoUrl) {
		this.aritstInfoUrl = aritstInfoUrl;
	}
	public List<String> getArtistGenre() {
		return artistGenre;
	}
	public void setArtistGenre(List<String> artistGenre) {
		this.artistGenre = artistGenre;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	@Override
	public int compareTo(RelatedArtist RelatedArtist) {
		return RelatedArtist.popularity - popularity;
		}
	
}
