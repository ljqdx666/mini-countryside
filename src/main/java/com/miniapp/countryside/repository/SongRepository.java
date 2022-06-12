package com.miniapp.countryside.repository;

import com.miniapp.countryside.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,String> {
    Optional<Song> findBySongNameAndSingerName(String songName,String singerName);

    Song getById(String id);

//    Page<Song> findAll(Pageable pageable);

    List<Song> findAll();

    List<Song> findBySongNameLikeOrSingerNameLike(String songName, String singerName);
}
