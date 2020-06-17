package com.tunercloud.music.models.wrappers;


import com.tunercloud.music.models.Artist;

import java.util.List;

public class SongCollab {
    private String title;
    private double duration;
    private int[] artistIds;

    public SongCollab() { }

    public SongCollab(String title, double duration, int[] artistIds) {
        this.title = title;
        this.duration = duration;
        this.artistIds = artistIds;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public int[] getArtistIds() {
        return artistIds;
    }
}
