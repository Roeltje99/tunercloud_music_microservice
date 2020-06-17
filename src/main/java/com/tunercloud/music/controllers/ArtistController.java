package com.tunercloud.music.controllers;

import com.tunercloud.music.data.IArtistRepository;
import com.tunercloud.music.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private IArtistRepository artistRepository;

    @RequestMapping(value = "/artist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Artist postArtist(@RequestBody Artist artist) {
        System.out.println(artist);
        return artistRepository.save(artist);
    }

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Artist getArtist(@PathVariable("id") int id) {
        return artistRepository.getById(id);
    }

    @RequestMapping(value = "/artist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
}
