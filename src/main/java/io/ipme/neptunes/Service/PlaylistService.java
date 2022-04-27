package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Repository.PlaylistRepository;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<PlaylistDTO> findAll() {
        ArrayList<PlaylistDTO> playlistDtos = new ArrayList<>();
        for (Playlist playlist : playlistRepository.findAll()) {
            PlaylistDTO playlistDto = new PlaylistDTO();
            BeanUtils.copyProperties(playlist, playlistDto);
            playlistDtos.add(playlistDto);
        }
        return playlistDtos;
    }

    public PlaylistDTO findOne(Integer id) {

        PlaylistDTO playlistDto = new PlaylistDTO();
        BeanUtils.copyProperties(playlistRepository.findById(id).orElseThrow(), playlistDto);
        return playlistDto;
    }

    public void save(Playlist playlist) {
        playlistRepository.saveAndFlush(playlist);
    }

    public void remove(Integer id) {
        playlistRepository.deleteById(id);
    }

    public void update(Playlist playlist, Integer id) {
        //TODO : gestion des exceptions
        Playlist playlistToUpdate = playlistRepository.getById(id);
        playlistToUpdate.setRandom(playlist.getRandom());

        if (playlist.getTracks() != null) {
            playlistToUpdate.setTracks(playlist.getTracks());
        }
        playlistRepository.save(playlistToUpdate);
    }
}
