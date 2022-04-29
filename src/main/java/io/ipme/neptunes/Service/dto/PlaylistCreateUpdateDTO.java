package io.ipme.neptunes.Service.dto;

public class PlaylistCreateUpdateDTO {

    private String name;

    private Boolean isRandom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRandom() {
        return isRandom;
    }

    public void setRandom(Boolean random) {
        isRandom = random;
    }

}
