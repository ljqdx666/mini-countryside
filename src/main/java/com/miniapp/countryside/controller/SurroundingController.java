package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.mapper.SurroundingMapper;
import com.miniapp.countryside.service.SurroundingService;
import com.miniapp.countryside.vo.SurroundingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/surrounding")
public class SurroundingController {
    SurroundingService surroundingService;
    SurroundingMapper surroundingMapper;

    @GetMapping("")
    List<SurroundingVo> list(){return surroundingService.list().stream().map(surroundingMapper::toVo).collect(Collectors.toList());}

    @GetMapping("/me/{creatorName}")
    List<SurroundingVo> findMine(@PathVariable String creatorName){return surroundingService.findMine(creatorName).stream().map(surroundingMapper::toVo).collect(Collectors.toList());}

    @PostMapping("")
    SurroundingVo create(@Validated @RequestBody SurroundingCreateRequest surroundingCreateRequest){
        return surroundingMapper.toVo(surroundingService.create(surroundingCreateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){surroundingService.delete(id);}

    @Autowired
    public void setSurroundingService(SurroundingService surroundingService) {
        this.surroundingService = surroundingService;
    }

    @Autowired
    public void setSurroundingMapper(SurroundingMapper surroundingMapper) {
        this.surroundingMapper = surroundingMapper;
    }
}
