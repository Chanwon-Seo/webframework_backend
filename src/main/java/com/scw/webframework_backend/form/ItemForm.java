package com.scw.webframework_backend.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
public class ItemForm {
    @NotEmpty(message = "내용을 입력해주세요")
    private String boardDetail;
}
