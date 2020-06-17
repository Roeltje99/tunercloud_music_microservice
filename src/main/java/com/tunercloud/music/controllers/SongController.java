package com.tunercloud.music.controllers;

import com.tunercloud.music.data.IArtistRepository;
import com.tunercloud.music.data.ISongRepository;
import com.tunercloud.music.models.*;
import com.tunercloud.music.models.wrappers.SongCollab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class SongController {

    @Autowired
    private ISongRepository songRepository;
    @Autowired
    private IArtistRepository artistRepository;

    @RequestMapping(value = "/song", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Song postSong(@RequestBody SongCollab song) {
        System.out.println(song);
        List<Artist> artists = new ArrayList();
        for (int artistId : song.getArtistIds())
        {
            Artist artist = artistRepository.getById(artistId);
            artists.add(artist);
        }
        Song songToSave = new Song(song.getTitle(), song.getDuration());
        songToSave.setArtists(artists);
        return songRepository.save(songToSave);
    }

    @RequestMapping(value = "/song/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Song getSong(@PathVariable("id") int id) {
        return songRepository.getById(id);
    }

    @RequestMapping(value = "/song", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
