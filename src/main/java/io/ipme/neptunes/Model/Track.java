package io.ipme.neptunes.Model;

public class Track {
    /*
     * 	Attributes
     */
    private String trackName;
    private String trackAuthor;
    private Integer trackReleaseYear;
    private String trackURL;
    private Integer id;

    /*
     * 	Constructors
     */
    public Track(String trackName, String trackAuthor, Integer trackReleaseYear, String trackURL) {
        this.trackName = trackName;
        this.trackAuthor = trackAuthor;
        this.trackReleaseYear = trackReleaseYear;
        this.trackURL = trackURL;
    }

    public Track(String trackName) {
        this.trackName = trackName;
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


    @Override
    public String toString() {
        return "Track{" +
                "trackName='" + trackName + '\'' +
                "| trackAuthor='" + trackAuthor + '\'' +
                "| trackReleaseYear=" + trackReleaseYear +
                "| trackURL='" + trackURL + '\'' +'\n'+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;

        Track track = (Track) o;

        return trackName != null ? trackName.equals(track.trackName) : track.trackName == null;
    }
}