package com.tunercloud.music.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String artistName;
    @Column(name = "bio", nullable = true)
    private String bio;

    @ManyToMany(mappedBy = "artists")
    @JsonIgnoreProperties("artists")
    public List<Song> songs;

    public Artist() { }

    public Artist(String artistName, String bio) {
        this.artistName = artistName;
        this.bio = bio;
    }

    public Artist(String artistName, String bio, List<Song> songs) {
        this.artistName = artistName;
        this.bio = bio;
        this.songs = songs;
    }

    public Artist(int id, String artistName, String bio, List<Song> songs) {
        this.id = id;
        this.artistName = artistName;
        this.bio = bio;
        this.songs = songs;
    }

    //Song list methods
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) { songs.add(song); }

    public void removeSong(Song song) { songs.remove(song); }

    //Getters and Setters
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
