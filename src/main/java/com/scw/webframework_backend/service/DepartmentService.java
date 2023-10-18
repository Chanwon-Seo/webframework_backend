package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.form.DepartmentDto;
import com.scw.webframework_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public void add(DepartmentDto departmentDto) {
        Department newDepartment = new Department(departmentDto.getDepartmentName(), departmentDto.getDepartmentCode(), (byte) 1, departmentDto.getDepartmentImgUrl());
        departmentRepository.save(newDepartment);
    }

    public Department findDepartment(String departmentName) {

        Department findDepartment = departmentRepository.findByDepartmentCode(departmentName).orElse(null);

        return findDepartment;
    }

}
