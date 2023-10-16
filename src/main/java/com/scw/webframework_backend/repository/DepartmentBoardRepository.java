package com.scw.webframework_backend.repository;

import com.scw.webframework_backend.domain.DepartmentBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentBoardRepository extends JpaRepository<DepartmentBoard, Long> {
    List<DepartmentBoard> findByDepartmentId(Long departmentId);

}
