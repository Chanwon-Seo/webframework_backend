package com.scw.webframework_backend.controller;

import com.scw.webframework_backend.form.LoginDto;
import com.scw.webframework_backend.form.SessionDto;
import com.scw.webframework_backend.service.DepartmentService;
import com.scw.webframework_backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final DepartmentService departmentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletRequest httpServletRequest) {


        SessionDto findMember = memberService.login(loginDto);
        findMember.setLoggedIn(true);

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        // Session이 없으면 생성
        HttpSession session = httpServletRequest.getSession(true);

        // 세션에 userId를 넣어줌
        session.setAttribute(SessionConst.LOGIN_MEMBER, findMember);

        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {

        //세션을 삭제한다.
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return false;
    }

    @GetMapping("/api/checkLoginStatus")
    public ResponseEntity<?> checkLoginStatus(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) SessionDto sessionDto) {
        
        // loginDto에 세션에서 바인딩된 값이 저장됨
        if (sessionDto != null) {
            // 사용자가 로그인한 상태이면 true 반환
            return new ResponseEntity<>(sessionDto, HttpStatus.OK);
        }

        // 사용자가 로그인하지 않은 상태이면 false 반환
        return new ResponseEntity<>(new SessionDto(), HttpStatus.OK);
    }

}
