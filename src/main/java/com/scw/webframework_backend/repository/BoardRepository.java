package com.scw.webframework_backend.repository;

import com.scw.webframework_backend.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
