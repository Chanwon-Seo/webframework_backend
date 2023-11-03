package com.scw.webframework_backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/all")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Spring에서 넘어온 데이터 입니다", HttpStatus.OK);
    }

}
