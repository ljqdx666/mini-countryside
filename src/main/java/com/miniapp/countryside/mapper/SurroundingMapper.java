package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.dto.SurroundingDto;
import com.miniapp.countryside.entity.Surrounding;
import com.miniapp.countryside.vo.SurroundingVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SurroundingMapper {
    SurroundingDto toDto(Surrounding surrounding);

    SurroundingVo toVo(SurroundingDto surroundingDto);

    Surrounding createEntity(SurroundingCreateRequest surroundingCreateRequest);
}
