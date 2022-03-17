package io.ipme.neptunes.Model;

public class Track {
	/*
	 * 	Attributes
	 */
	private String trackName;
	private String trackAuthor;
	private Integer trackReleaseYear;
	private String trackURL;
	
	/*
	 * 	Constructors
	 */
	public Track(String trackName, String trackAuthor, Integer trackReleaseYear, String trackURL) {
		this.trackName = trackName;
		this.trackAuthor = trackAuthor;
		this.trackReleaseYear = trackReleaseYear;
		this.trackURL = trackURL;
	}

	/*
	 * 	Getters
	 */
	public String getTrackName() {
		return trackName;
	}

	public String getTrackAuthor() {
		return trackAuthor;
	}

	public Integer getTrackReleaseYear() {
		return trackReleaseYear;
	}

	public String getTrackURL() {
		return trackURL;
	}
	
	
}
