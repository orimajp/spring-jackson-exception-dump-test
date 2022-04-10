package com.example.springjacksonexceptiondumptest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
public class TestRestController {

    @PostMapping("test")
    public ResponseEntity<Object> test(@RequestBody @Validated TestRequest testRequest) {
        log.info("request value={}", testRequest);
        return ResponseEntity.ok("");
    }

    @PostMapping("test2")
    public ResponseEntity<Object> test(@RequestBody @Validated Test2Request test2Request) {
        log.info("request value={}", test2Request);
        return ResponseEntity.ok("");
    }

}
