package com.tunercloud.music.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tunercloud.music.data.*;
import com.tunercloud.music.models.Artist;
import com.tunercloud.music.models.Song;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RabbitReceiver
{
    @Autowired
    private IArtistRepository artistRepository;

    @Autowired
    private ISongRepository songRepository;

    @RabbitListener(queues = "account.update")
    public void receiveUpdate(Message event) throws JsonProcessingException
    {
        System.out.println(event);

        //Object mapping
        ObjectMapper objectMapper = new ObjectMapper();
        ArtistWrapper receivedArtist = objectMapper.readValue(new String(event.getBody()), ArtistWrapper.class);

        Artist oldArtist = artistRepository.getById(receivedArtist.getId());
        oldArtist.setArtistName(receivedArtist.getArtistName());
        oldArtist.setBio(receivedArtist.getBio());

        artistRepository.save(oldArtist);
    }

    @Transactional
    @RabbitListener(queues = "account.delete")
    public void receiveDelete(Message event) throws JsonProcessingException
    {
        System.out.println(event);

        //Object mapping
        ObjectMapper objectMapper = new ObjectMapper();
        ArtistWrapper receivedArtist = objectMapper.readValue(new String(event.getBody()), ArtistWrapper.class);

        Artist artist = artistRepository.getById(receivedArtist.getId());
        for (Song song: artist.songs) {
            Song tempSong = songRepository.getById(song.getId());
            tempSong.removeArtist(artist);
            tempSong = songRepository.save(tempSong);
            if (tempSong.getArtists().size() == 0) {
                songRepository.delete(tempSong);
            }
        }
        Artist removableArtist = artistRepository.getById(artist.getId());
        artistRepository.delete(removableArtist);
    }

    @RabbitListener(queues = "account.add")
    public void receiveAdd(Message event) throws JsonProcessingException
    {
        System.out.println(event);

        //Object mapping
        ObjectMapper objectMapper = new ObjectMapper();
        ArtistWrapper receivedArtist = objectMapper.readValue(new String(event.getBody()), ArtistWrapper.class);

        Artist newArtist = new Artist(receivedArtist.getId(),receivedArtist.getArtistName(),receivedArtist.getBio(),null);
        artistRepository.save(newArtist);
    }
}
