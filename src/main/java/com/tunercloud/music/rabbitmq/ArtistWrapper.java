package com.tunercloud.music.rabbitmq;

import com.tunercloud.music.models.Artist;

public class ArtistWrapper {
    private int id;
    private String artistName;
    private String bio;

    public ArtistWrapper() { }

    public ArtistWrapper(Artist artist) {
        this.id = artist.getId();
        this.artistName = artist.getArtistName();
        this.bio = artist.getBio();
    }

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
