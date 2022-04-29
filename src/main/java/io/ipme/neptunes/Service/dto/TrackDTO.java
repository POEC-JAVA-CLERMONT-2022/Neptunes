package io.ipme.neptunes.Service.dto;

public class TrackDTO {

    private Integer id;

    private String trackName;

    private String trackAuthor;

    private Integer trackReleaseYear;

    private String trackURL;

    public Integer getId() { return id; }

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

    public void setId(Integer id) { this.id = id; }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackAuthor(String trackAuthor) {
        this.trackAuthor = trackAuthor;
    }

    public void setTrackReleaseYear(Integer trackReleaseYear) { this.trackReleaseYear = trackReleaseYear; }

    public void setTrackURL(String trackURL) {
        this.trackURL = trackURL;
    }

}
