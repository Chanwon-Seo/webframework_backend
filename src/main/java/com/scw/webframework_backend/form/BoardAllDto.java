package com.scw.webframework_backend.form;

import com.scw.webframework_backend.domain.Board;
import com.scw.webframework_backend.domain.DepartmentBoard;
import com.scw.webframework_backend.domain.Member;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardAllDto {

    private Long pageno = 0L;
    private int pagesize = 0;
    private int totalcount;
    private String titleName;
    private List<Board> contacts;

    public BoardAllDto(List<Board> boards) {
        this.totalcount = boards.size();
        this.contacts = boards;
        this.titleName = "공지사항";
    }

    public BoardAllDto(List<Board> boards, String titleName) {
        this.totalcount = boards.size();
        this.contacts = boards;
        this.titleName = titleName;
    }
}
