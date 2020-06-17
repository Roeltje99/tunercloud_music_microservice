package com.tunercloud.music.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "duration", nullable = false)
    private double duration;
    @Column(name = "releaseDate", nullable = false)
    private Date releaseDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "artist_Song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    @JsonIgnoreProperties("songs")
    public List<Artist> artists;

    public Song() { releaseDate = new Date();}

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
        this.artists = artists;
        releaseDate = new Date();
    }

    public Song(int id, String title, double duration, List<Artist> artists) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artists = artists;
        releaseDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) { this.artists = artists; }

    public void removeArtist(Artist artist) { artists.remove(artist); }
}
