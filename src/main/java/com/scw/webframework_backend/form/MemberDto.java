package com.scw.webframework_backend.form;

import lombok.Data;

@Data
public class MemberDto {

    private String memberName;
    private Long memberNumber;
    private String password;
    private Byte memberStatus;
}