package com.scw.webframework_backend.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SessionDto {

    private Long memberNumber;

    private String memberName;

    private Boolean loggedIn = false;
    private Byte memberStatus;


    public SessionDto() {
    }

    public SessionDto(Long memberNumber, String memberName, Byte memberStatus) {
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.memberStatus = memberStatus;
    }

}
