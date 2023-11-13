package com.scw.webframework_backend.form;

import com.scw.webframework_backend.domain.Department;
import lombok.Data;

@Data
public class DepartmentFormDto {

    private String departmentName;

    private String departmentCode;

    private String departmentImgUrl;

    private String departmentInfoCategoryBoardUrl;
    private String departmentDetailUrl;
    private String departmentDetailText;


    public DepartmentFormDto(Department department, String departmentInfoCategoryBoardUrl, String departmentDetailUrl) {
        this.departmentName = department.getDepartmentName();
        this.departmentCode = department.getDepartmentCode();
        this.departmentImgUrl = department.getDepartmentImgUrl();
        this.departmentInfoCategoryBoardUrl = departmentInfoCategoryBoardUrl;
        this.departmentDetailUrl = departmentDetailUrl;
        this.departmentDetailText = department.getDepartmentDetail();
    }
}
