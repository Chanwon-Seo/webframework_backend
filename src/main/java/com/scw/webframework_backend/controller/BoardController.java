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

    @GetMapping("/item/list")
    public ResponseEntity<?> boardFindAll() {

        BoardAllDto board = boardService.findBoard();

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping("/item/join")
    public ResponseEntity<?> itemSave(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) LoginDto loginMember) {

//        if (loginMember == null) {
//            return new ResponseEntity<>("로그인 되지 않은 회원입니다.", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<String>("게시글이 등록되었습니다.", HttpStatus.OK);
    }

}