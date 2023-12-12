package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.form.DepartmentDto;
import com.scw.webframework_backend.form.MemberDto;
import com.scw.webframework_backend.form.MemberNewDto;
import com.scw.webframework_backend.form.MemberStatusDto;
import com.scw.webframework_backend.service.DepartmentService;
import com.scw.webframework_backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final DepartmentService departmentService;
    private final MemberService memberService;

    @PostMapping("/department/add")
    public ResponseEntity<String> departmentAdd(@RequestBody DepartmentDto departmentDto) {
        departmentService.add(departmentDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/member/add")
    public ResponseEntity<String> memberAdd(@RequestBody MemberDto memberDto) {
        memberService.memberAdd(memberDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/member/add/new")
    public ResponseEntity<String> memberAddNew(@RequestBody List<MemberNewDto> memberNewDtos) {
        memberService.memberAddNew(memberNewDtos);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/member/find")
    public ResponseEntity<?> memberFind(@RequestBody MemberDto memberDto) {
        MemberDto findMember = memberService.memberFind(memberDto.getMemberNumber());

        return new ResponseEntity<>(findMember, HttpStatus.OK);
    }

    @PostMapping("/member/status")
    public ResponseEntity<?> memberStatus() {
        MemberStatusDto findMemberStatus = memberService.findAllMember();

        return new ResponseEntity<>(findMemberStatus, HttpStatus.OK);
    }

}
