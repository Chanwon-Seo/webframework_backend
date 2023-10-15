package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department findAll(String departmentName) {
        Department findDepartment = departmentRepository.findByDepartmentCode(departmentName).orElse(null);

        return findDepartment;
    }

    public void add() {

    }
}
