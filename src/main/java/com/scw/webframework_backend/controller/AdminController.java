package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.form.DepartmentDto;
import com.scw.webframework_backend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final DepartmentService departmentService;

    @PostMapping("/department/add")
    public ResponseEntity<String> departmentAdd(@RequestBody DepartmentDto departmentDto) {

        departmentService.add(departmentDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
