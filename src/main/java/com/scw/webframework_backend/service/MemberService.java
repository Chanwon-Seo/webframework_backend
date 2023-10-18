package com.scw.webframework_backend.service;

import com.scw.webframework_backend.form.LoginDto;
import com.scw.webframework_backend.form.SessionDto;
import com.scw.webframework_backend.repository.MemberRepository;
import com.scw.webframework_backend.repository.dao.MemberFindInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;


    public SessionDto login(LoginDto loginDto) {

        MemberFindInfo findMember = memberRepository.findByMemberNumber(loginDto.getMemberNumber());

        if (findMember == null) {
            throw new NullPointerException("아이디를 다시 입력해 주세요");
        } else if (!findMember.getPassword().equals(loginDto.getPassword())) {
            throw new NullPointerException("비밀번호를 다시 입력해 주세요");
        }

        SessionDto sessionDto = new SessionDto(findMember.getMemberNumber(), findMember.getMemberName(), findMember.getMemberStatus());

        return sessionDto;
    }
}
