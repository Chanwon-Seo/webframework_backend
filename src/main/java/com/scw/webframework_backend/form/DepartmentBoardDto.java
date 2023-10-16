package com.scw.webframework_backend.form;

import com.scw.webframework_backend.domain.DepartmentBoard;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentBoardDto {

    private Long pageno = 0L;
    private int pagesize = 0;
    private int totalcount;
    private String titleName;
    private List<DepartmentBoard> contacts;

    public DepartmentBoardDto(List<DepartmentBoard> boards) {
        this.totalcount = boards.size();
        this.contacts = boards;
        this.titleName = "공지사항";
    }

    public DepartmentBoardDto(List<DepartmentBoard> boards, String titleName) {
        this.totalcount = boards.size();
        this.contacts = boards;
        this.titleName = titleName;
    }
}
