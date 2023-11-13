package com.scw.webframework_backend.form;

import lombok.Data;

@Data
public class SessionDto {

    private Long memberNumber;

    private String memberName;

    private Boolean loggedIn = false;
    private String departmentCode;
    private Byte memberStatus;


    public SessionDto() {
    }

    public SessionDto(Long memberNumber, String memberName, Byte memberStatus, String departmentCode) {
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.memberStatus = memberStatus;
        this.departmentCode = departmentCode;
    }

}
