package com.paulina.dvd.dto;

public class Dvd {
	
	private String title;
	private String date;
	private String rating;
	private String directorsName;
	private String studio;
	private String userNote;
	
	
	public Dvd() {
		
	}


	public Dvd(String title, String date, String rating, String directorsName, String studio, String userNote) {
		super();
		this.title = title;
		this.date = date;
		this.rating = rating;
		this.directorsName = directorsName;
		this.studio = studio;
		this.userNote = userNote;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getDirectorsName() {
		return directorsName;
	}


	public void setDirectorsName(String directorsName) {
		this.directorsName = directorsName;
	}


	public String getStudio() {
		return studio;
	}


	public void setStudio(String studio) {
		this.studio = studio;
	}


	public String getUserNote() {
		return userNote;
	}


	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}


	@Override
	public String toString() {
		return "DvdLib [title=" + title + ", date=" + date + ", rating=" + rating + ", directorsName=" + directorsName
				+ ", studio=" + studio + ", userNote=" + userNote + "]";
	}
	
	

}
