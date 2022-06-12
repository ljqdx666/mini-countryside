package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.SongCreateRequest;
import com.miniapp.countryside.dto.SongDto;
import com.miniapp.countryside.entity.Song;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.SongMapper;
import com.miniapp.countryside.repository.SongRepository;
import com.miniapp.countryside.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl extends BaseService implements SongService {

    SongRepository songRepository;
    SongMapper songMapper;

    @Override
    public List<SongDto> list() {
        return songRepository.findAll().stream().map(songMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SongDto create(SongCreateRequest songCreateRequest) {
        Song song=songMapper.createEntity(songCreateRequest);
        checkSongUnique(songCreateRequest.getSongName(),songCreateRequest.getSingerName());
        if (song.getSongPicUrl()=="")
            song.setSongPicUrl("cloud://prod-6gkeef8j8c880a59.7072-prod-6gkeef8j8c880a59-1312196033/yinle.png");
        return songMapper.toDto(songRepository.save(song));
    }

    @Override
    public void delete(String id) { songRepository.delete(getById(id));}

    @Override
    public List<SongDto> search(String searchContent) {
        List<Song> songs=songRepository.findBySongNameLikeOrSingerNameLike("%"+searchContent+"%","%"+searchContent+"%");
        if (songs.size()==0)
            throw new BizException(ExceptionType.SEARCH_SONG_NOT_FOUND);
        return songs.stream().map(songMapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public Page<SongDto> search(Pageable pageable) {
//        return songRepository.findAll(pageable).map(songMapper::toDto);
//    }

    private void checkSongUnique(String songName,String singerName){
        Optional<Song> song=songRepository.findBySongNameAndSingerName(songName,singerName);
        if (song.isPresent()){
            throw new BizException(ExceptionType.SONG_DUPLICATE);
        }
    }

    private Song getById(String id){
        Optional<Song> song=songRepository.findById(id);
        if(!song.isPresent()){
            throw new BizException(ExceptionType.SONG_NOT_FOUND);
        }
        return song.get();
    }

    @Autowired
    public void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }
}
