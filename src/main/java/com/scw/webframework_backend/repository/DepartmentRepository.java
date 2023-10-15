package com.scw.webframework_backend.repository;

import com.scw.webframework_backend.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Optional<Department> findByDepartmentCode(String email);
}
