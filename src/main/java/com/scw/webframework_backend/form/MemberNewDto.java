package com.scw.webframework_backend.form;

import lombok.Data;

@Data
public class MemberNewDto {
    private String name;
    private String department;
    private Long firstSSN;
    private Long lastSSN;
}
