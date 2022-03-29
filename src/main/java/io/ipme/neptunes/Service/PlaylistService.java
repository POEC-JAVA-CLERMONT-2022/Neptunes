package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> findAll(){
        return playlistRepository.findAll();
    }

    public Optional<Playlist> findOne(Integer id){
        return playlistRepository.findById(id);
    }

    public void save(Playlist playlist){
        playlistRepository.saveAndFlush(playlist);
    }

    public void remove(Integer id){
        playlistRepository.deleteById(id);
    }

    public void update(Playlist playlist, Integer id){
        Playlist playlistToUpdate  = playlistRepository.getById(id);
        playlistToUpdate.setRandom(playlist.getRandom());

        if (playlist.getTracks() != null) {
            playlistToUpdate.setTracks(playlist.getTracks());
        }
        if (playlist.getGames() != null) {
            playlistToUpdate.setGames(playlist.getGames());
        }
        playlistRepository.save(playlistToUpdate);
    }
}
