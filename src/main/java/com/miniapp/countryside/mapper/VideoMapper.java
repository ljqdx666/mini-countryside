package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.dto.VideoDto;
import com.miniapp.countryside.entity.Video;
import com.miniapp.countryside.vo.VideoVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface VideoMapper {
    VideoDto toDto(Video video);

    VideoVo toVo(VideoDto videoDto);

    Video createEntity(VideoCreateRequest videoCreateRequest);
}
