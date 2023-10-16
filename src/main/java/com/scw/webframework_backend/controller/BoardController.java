package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.form.BoardAllDto;
import com.scw.webframework_backend.form.LoginDto;
import com.scw.webframework_backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping(value = {"/board/list/{name}", "/board/list"})
    public ResponseEntity<?> boardFindAll(@PathVariable(required = false) String name) {

        BoardAllDto board = boardService.findBoard(name);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    

}