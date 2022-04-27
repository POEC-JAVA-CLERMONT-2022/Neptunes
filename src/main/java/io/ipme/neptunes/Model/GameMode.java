package io.ipme.neptunes.Model;

public enum GameMode {

    Normal("Normal"), Random("Random"), Faster("Faster");

    private String value;

    GameMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GameMode getMode(String value){
        for(GameMode mode : GameMode.values()){
            if(mode.value.equals(value)) {
                return mode;
            }
        }
        return Normal;
    }
}

