package com.tunercloud.music.data;

import com.tunercloud.music.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Integer> {
    Artist getById(int id);
    List<Artist> getAllByArtistName(String artistName);
}
