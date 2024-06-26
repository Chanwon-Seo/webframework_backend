package com.scw.webframework_backend.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    private Long memberNumber;
    private String password;
    private String memberName;

    private Long firstSSN;

    private Long lastSSN;

    private Long phoneNumber;

    private Long grade;

    private String studentClass;

    private String academicRecord;

    private Byte memberStatus;


    public Member(Long memberNumber, String memberName, String password, Byte memberStatus) {

        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.password = password;
        this.memberStatus = memberStatus;
    }

    public Member(Long memberNumber, Long firstSSN, Long lastSSN, String memberName, String password, Byte memberStatus, Department department) {
        this.memberNumber = memberNumber;
        this.firstSSN = firstSSN;
        this.lastSSN = lastSSN;
        this.memberName = memberName;
        this.password = password;
        this.memberStatus = memberStatus;
        this.department = department;
    }
}
