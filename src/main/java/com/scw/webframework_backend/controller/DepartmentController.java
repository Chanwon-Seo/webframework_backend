package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{name}")
    public ResponseEntity<Object> departmentNameHome(@PathVariable String name) {

        Department findDepartment = departmentService.findAll(name);
        return new ResponseEntity<>(findDepartment, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<String> departmentAdd() {
        log.info("학과 추가");
        departmentService.add();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}