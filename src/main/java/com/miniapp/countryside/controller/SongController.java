package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.SongCreateRequest;
import com.miniapp.countryside.mapper.SongMapper;
import com.miniapp.countryside.service.SongService;
import com.miniapp.countryside.vo.SongVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/song")
public class SongController {
    SongService songService;

    SongMapper songMapper;

    @GetMapping("")
    List<SongVo>list(){return songService.list().stream().map(songMapper::toVo).collect(Collectors.toList());}

    @PostMapping("")
    SongVo create(@Validated @RequestBody SongCreateRequest songCreateRequest){
        return songMapper.toVo(songService.create(songCreateRequest));
    }

    @Autowired
    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }
}