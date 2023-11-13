package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.domain.DepartmentBoard;
import com.scw.webframework_backend.domain.Member;
import com.scw.webframework_backend.form.DepartmentBoardDto;
import com.scw.webframework_backend.form.DepartmentBoardFormDto;
import com.scw.webframework_backend.form.MemberDto;
import com.scw.webframework_backend.form.SessionDto;
import com.scw.webframework_backend.repository.DepartmentBoardRepository;
import com.scw.webframework_backend.repository.DepartmentRepository;
import com.scw.webframework_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class DepartmentBoardService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentBoardRepository departmentBoardRepository;

    private final MemberRepository memberRepository;

    public DepartmentBoardDto findBoard(String name) {

        Department findDepartment = departmentRepository.findByDepartmentCode(name).orElse(null);

        List<DepartmentBoard> boards = departmentBoardRepository.findByDepartmentId(findDepartment.getId());

        Collections.sort(boards, new Comparator<DepartmentBoard>() {
            @Override
            public int compare(DepartmentBoard t1, DepartmentBoard t2) {
                if (t1.getRegistrationDate().isAfter(t2.getRegistrationDate())) {
                    return -1;
                }
                return 0;
            }
        });

        List<DepartmentBoard> boardList = new ArrayList<>();
        DepartmentBoardDto departmentBoardDto = new DepartmentBoardDto(boardList, findDepartment.getDepartmentName());

        Long i = 0L;
        for (DepartmentBoard board : boards) {
            i++;
            boardList.add(new DepartmentBoard(i, board.getBoardTitle(), board.getBoardDetail(), board.getRegistrationDate()));
        }

        return departmentBoardDto;
    }

    @Transactional
    public void join(DepartmentBoardFormDto departmentBoardFormDto, SessionDto sessionDto) {

        Member findByMember = memberRepository.findByMemberNumber(sessionDto.getMemberNumber());
        Department findDepartment = departmentRepository.findById(findByMember.getDepartment().getId()).orElse(null);
        DepartmentBoard departmentBoard = new DepartmentBoard(departmentBoardFormDto.getBoardTitle(), findByMember, findDepartment, departmentBoardFormDto.getBoardDetail(), LocalDateTime.now(), LocalDateTime.now());
        departmentBoardRepository.save(departmentBoard);
    }
}
