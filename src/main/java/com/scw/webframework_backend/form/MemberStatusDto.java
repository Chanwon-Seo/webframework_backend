package com.scw.webframework_backend.form;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberStatusDto {

    private List<String> labels;
    private List<Integer> data;
}
