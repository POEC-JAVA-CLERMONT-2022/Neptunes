package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.Track;

import java.util.ArrayList;

public class PlaylistService {

    public Playlist create(String name, ArrayList<Track> tracks){
        return new Playlist(name, tracks,false);
    }

    public void put(Track track, Playlist playlistName){
        playlistName.getTracks().add(track);
    }

    public void removeTrack(Track track, Playlist playlistName) {
        try {
            playlistName.getTracks().remove(track);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void showAll(Playlist playlistName) {
        System.out.println(playlistName.toString());
    }

    public void show(Track track) {
        System.out.println(track.toString());
    }
}