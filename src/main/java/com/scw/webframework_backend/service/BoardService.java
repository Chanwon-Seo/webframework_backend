package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Board;
import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.domain.DepartmentBoard;
import com.scw.webframework_backend.form.BoardAllDto;
import com.scw.webframework_backend.repository.BoardRepository;
import com.scw.webframework_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final DepartmentRepository departmentRepository;

    private final BoardRepository boardRepository;

    public BoardAllDto findBoard(String name) {

        List<Board> boards = null;
        List<Board> boardList = new ArrayList<>();
        BoardAllDto boardAllDto = null;
        Department findDepartment;


        if (name == null) {
            boards = boardRepository.findAll();
            boardAllDto = new BoardAllDto(boardList);
        } else {
            findDepartment = departmentRepository.findByDepartmentCode(name).orElse(null);
            boards = boardRepository.findByDepartmentId(findDepartment.getId());
            boardAllDto = new BoardAllDto(boardList, findDepartment.getDepartmentName());
        }

        Collections.sort(boards, new Comparator<Board>() {
            @Override
            public int compare(Board t1, Board t2) {
                if (t1.getRegistrationDate().isAfter(t2.getRegistrationDate())) {
                    return -1;
                }
                return 0;
            }
        });

        Long i = 0L;
        for (Board board : boards) {
            i++;
            boardList.add(new Board(i, board.getBoardTitle(), board.getBoardDetail(), board.getRegistrationDate()));
        }


        return boardAllDto;
    }

}