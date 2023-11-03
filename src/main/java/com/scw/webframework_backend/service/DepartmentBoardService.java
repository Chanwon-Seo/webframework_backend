package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.domain.DepartmentBoard;
import com.scw.webframework_backend.form.DepartmentBoardDto;
import com.scw.webframework_backend.repository.DepartmentBoardRepository;
import com.scw.webframework_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class DepartmentBoardService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentBoardRepository departmentBoardRepository;

    public DepartmentBoardDto findBoard(String name) {

        Department findDepartment = departmentRepository.findByDepartmentCode(name).orElse(null);

        List<DepartmentBoard> boards = departmentBoardRepository.findByDepartmentId(findDepartment.getId());

        List<DepartmentBoard> boardList = new ArrayList<>();
        DepartmentBoardDto departmentBoardDto = new DepartmentBoardDto(boardList, findDepartment.getDepartmentName());


        Long i = 0L;
        for (DepartmentBoard board : boards) {
            i++;
            boardList.add(new DepartmentBoard(i, board.getBoardTitle(), board.getBoardDetail(), board.getRegistrationDate()));
        }

        return departmentBoardDto;
    }
}
