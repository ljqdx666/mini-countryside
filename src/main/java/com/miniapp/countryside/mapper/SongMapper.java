package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.SongCreateRequest;
import com.miniapp.countryside.dto.SongDto;
import com.miniapp.countryside.entity.Song;
import com.miniapp.countryside.vo.SongVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SongMapper {
    SongDto toDto(Song song);

    SongVo toVo(SongDto songDto);

    Song createEntity(SongCreateRequest songCreateRequest);
}
