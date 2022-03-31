package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.Theme;
import io.ipme.neptunes.Repository.PlaylistRepository;
import io.ipme.neptunes.Service.dto.PlaylistDto;
import io.ipme.neptunes.Service.dto.ThemeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<PlaylistDto> findAll(){
        ArrayList<PlaylistDto> playlistDtos = new ArrayList<>();
        for (Playlist playlist : playlistRepository.findAll()){
            PlaylistDto playlistDto = new PlaylistDto();
            BeanUtils.copyProperties(playlist, playlistDto);
            playlistDtos.add(playlistDto);
        }
        return playlistDtos;
    }

    public PlaylistDto findOne(Integer id){

        PlaylistDto playlistDto = new PlaylistDto();
        BeanUtils.copyProperties(playlistRepository.findById(id), playlistDto);
        return playlistDto;
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
        playlistRepository.save(playlistToUpdate);
    }
}
