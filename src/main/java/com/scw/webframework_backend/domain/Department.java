package com.scw.webframework_backend.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String departmentName;

    private String departmentNumCode;

    private String departmentCode;

    private Byte departmentStatus;

    private String departmentImgUrl;

    public Department(String departmentName, String departmentNumCode, String departmentCode, Byte departmentStatus, String departmentImgUrl) {
        this.departmentName = departmentName;
        this.departmentNumCode = departmentNumCode;
        this.departmentCode = departmentCode;
        this.departmentStatus = departmentStatus;
        this.departmentImgUrl = departmentImgUrl;
    }
}
