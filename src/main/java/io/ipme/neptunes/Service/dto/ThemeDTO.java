package io.ipme.neptunes.Service.dto;

public class ThemeDTO {

    private String theme;

    public ThemeDTO(String theme){
        this.theme = theme;
    }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }
}
