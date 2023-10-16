package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.form.DepartmentBoardDto;
import com.scw.webframework_backend.service.DepartmentBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DepartmentBoardController {

    private final DepartmentBoardService departmentBoardService;

    @GetMapping("/department/board/list/{name}")
    public ResponseEntity<?> boardFindAll(@PathVariable String name) {

        DepartmentBoardDto board = departmentBoardService.findBoard(name);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
