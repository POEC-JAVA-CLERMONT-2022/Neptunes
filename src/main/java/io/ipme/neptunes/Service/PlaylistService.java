package io.ipme.neptunes.Service;

import io.ipme.neptunes.Model.Playlist;
import io.ipme.neptunes.Model.Track;
import io.ipme.neptunes.Repository.PlaylistRepository;
import io.ipme.neptunes.Service.dto.PlaylistCreateUpdateDTO;
import io.ipme.neptunes.Service.dto.PlaylistDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<PlaylistDTO> findAll() {
        List<PlaylistDTO> playlistDtos = new ArrayList<>();
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

    public PlaylistDTO save(PlaylistCreateUpdateDTO playlistCreateUpdateDTO) {
        /*Playlist creation*/
        Playlist playlist = new Playlist(playlistCreateUpdateDTO.getName(), playlistCreateUpdateDTO.getRandom());
        playlistRepository.save(playlist);
        /*DTO send back*/
        PlaylistDTO playlistDTO = new PlaylistDTO();
        BeanUtils.copyProperties(playlist, playlistDTO);
        return playlistDTO;
    }

    public void remove(Integer id) {
        // TODO : la suppression doit supprimer dans la table track_playlist
        playlistRepository.deleteById(id);
    }

    public PlaylistDTO update(Integer id, PlaylistCreateUpdateDTO playlistUpdateDTO) {
        //TODO : gestion des exceptions
        /*Playlist update*/
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        if (playlistUpdateDTO.getName() != null) playlist.setName(playlistUpdateDTO.getName());
        if (playlistUpdateDTO.getRandom() != null) playlist.setRandom(playlistUpdateDTO.getRandom());

        playlistRepository.save(playlist);
        /*DTO send back*/
        PlaylistDTO playlistDTO = new PlaylistDTO();
        BeanUtils.copyProperties(playlist, playlistDTO);
        return playlistDTO;
    }

    public PlaylistDTO addTracks(Integer id, List<Integer> tracksId) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow();

        List<Track> tracksToSave = new ArrayList<>();

        for (Integer trackId : tracksId) {
            if (!playlist.getTracks().contains(new Track(trackId))) {
                tracksToSave.add(new Track(trackId));
            }
        }
        playlist.getTracks().addAll(tracksToSave);
        playlistRepository.save(playlist);
        /*DTO send back*/
        PlaylistDTO playlistDTO = new PlaylistDTO();
        BeanUtils.copyProperties(playlist, playlistDTO);
        return playlistDTO;
    }
}
