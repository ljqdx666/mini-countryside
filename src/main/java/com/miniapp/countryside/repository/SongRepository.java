package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,String> {
    Optional<Song> findBySongNameAndSingerName(String songName,String singerName);
}
