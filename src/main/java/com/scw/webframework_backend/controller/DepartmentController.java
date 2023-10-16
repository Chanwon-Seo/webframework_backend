package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.form.DepartmentFormDto;
import com.scw.webframework_backend.service.DepartmentService;
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
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/department/{name}")
    public ResponseEntity<?> departmentInfo(@PathVariable String name) {

        Department findDepartment = departmentService.findDepartment(name);

        DepartmentFormDto departmentFormDto = new DepartmentFormDto(findDepartment, "/department/board/list/" + name);

        return new ResponseEntity<>(departmentFormDto, HttpStatus.OK);
    }

}
