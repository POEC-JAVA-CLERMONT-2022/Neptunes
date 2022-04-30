package io.ipme.neptunes.Service.dto;

public class TrackCreateUpdateDTO {

    private String trackName;

    private String trackAuthor;

    private Integer trackReleaseYear;

    private String trackURL;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackAuthor() {
        return trackAuthor;
    }

    public void setTrackAuthor(String trackAuthor) {
        this.trackAuthor = trackAuthor;
    }

    public Integer getTrackReleaseYear() {
        return trackReleaseYear;
    }

    public void setTrackReleaseYear(Integer trackReleaseYear) {
        this.trackReleaseYear = trackReleaseYear;
    }

    public String getTrackURL() {
        return trackURL;
    }

    public void setTrackURL(String trackURL) {
        this.trackURL = trackURL;
    }

}
