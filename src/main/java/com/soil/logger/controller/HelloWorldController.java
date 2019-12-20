package com.soil.logger.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LianSong
 * @Date 2019/12/17 18:56
 */
@Slf4j
@RestController
public class HelloWorldController {
    @PostMapping("/hello")
    public String hello() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<>(2);
        map.put("name", "lian song");
        map.put("money", "10");
        String s = objectMapper.writeValueAsString(map);
        log.debug(s);
        return s;
    }

}
