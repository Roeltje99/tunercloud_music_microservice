package com.tunercloud.music.data;

import com.tunercloud.music.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
    Song getById(int id);
    List<Song> getAllByTitle(String title);
}
