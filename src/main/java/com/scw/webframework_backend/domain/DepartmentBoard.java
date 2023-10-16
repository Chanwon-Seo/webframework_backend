package com.scw.webframework_backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Data
public class DepartmentBoard {

    @Id
    @GeneratedValue
    @Column(name = "department_board_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "department_id")
    private Long departmentId;

    private String boardTitle;

    private String boardDetail;

    private LocalDateTime registrationDate; //등록날짜

    private LocalDateTime modificationDate; //수정날짜

    private Byte boardStatus;

    public DepartmentBoard(String boardTitle, Member member, Department department, String boardDetail, LocalDateTime registrationDate, LocalDateTime modificationDate) {
        this.boardTitle = boardTitle;
        this.member = member;
        this.departmentId = department.getId();
        this.boardDetail = boardDetail;
        this.registrationDate = registrationDate;
        this.modificationDate = modificationDate;
        this.boardStatus = 1;
    }

    public DepartmentBoard(Long id, String boardTitle, String boardDetail, LocalDateTime registrationDate) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardDetail = boardDetail;
        this.registrationDate = registrationDate;
    }

}
