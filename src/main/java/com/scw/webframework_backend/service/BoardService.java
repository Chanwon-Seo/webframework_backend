package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Board;
import com.scw.webframework_backend.form.BoardAllDto;
import com.scw.webframework_backend.repository.BoardRepository;
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
public class BoardService {

    private final BoardRepository boardRepository;


    public BoardAllDto findBoard() {

        List<Board> boards = boardRepository.findAll();

        List<Board> boardList = new ArrayList<>();

        Long i = 0L;
        for (Board board : boards) {
            i++;
            boardList.add(new Board(i, board.getBoardTitle(), board.getBoardDetail(), board.getRegistrationDate()));
        }

        BoardAllDto boardAllDto = new BoardAllDto(boardList);

        return boardAllDto;
    }
}
