package com.scw.webframework_backend.service;

import com.scw.webframework_backend.domain.Department;
import com.scw.webframework_backend.domain.Member;
import com.scw.webframework_backend.form.LoginDto;
import com.scw.webframework_backend.form.MemberDto;
import com.scw.webframework_backend.form.MemberNewDto;
import com.scw.webframework_backend.form.SessionDto;
import com.scw.webframework_backend.repository.DepartmentRepository;
import com.scw.webframework_backend.repository.MemberRepository;
import com.scw.webframework_backend.repository.dao.MemberFindInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;


    public SessionDto login(LoginDto loginDto) {

        MemberFindInfo findMember = memberRepository.findMnAndPwByMemberNumber(loginDto.getMemberNumber());

        if (findMember == null) {
            throw new NullPointerException("존재하지 않는 아이디입니다.");
        }
        Member findByMember = memberRepository.findByMemberNumber(findMember.getMemberNumber());
        if (!findMember.getPassword().equals(loginDto.getPassword())) {
            throw new NullPointerException("비밀번호를 다시 입력해 주세요");
        }

        SessionDto sessionDto = new SessionDto(findMember.getMemberNumber(), findMember.getMemberName(), findMember.getMemberStatus(), findByMember.getDepartment().getDepartmentCode());

        return sessionDto;
    }

    @Transactional
    public void memberAdd(MemberDto memberDto) {
        memberDto.setMemberStatus((byte) 2);
        Department department = departmentRepository.findByDepartmentName(memberDto.getDepartmentName()).orElse(null);
        Member member = new Member(memberDto.getMemberNumber(), memberDto.getFirstSSN(), memberDto.getLastSSN(), memberDto.getMemberName(), memberDto.getPassword(), memberDto.getMemberStatus(), department);
        memberRepository.save(member);
    }

    @Transactional
    public void memberAddNew(List<MemberNewDto> memberNewDtos) {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear());

        for (int i = 0; i < memberNewDtos.size(); i++) {
            String str = year;


            Department department = departmentRepository.findByDepartmentName(memberNewDtos.get(i).getDepartment()).orElse(null);
            str += department.getDepartmentNumCode();
            str += String.format("%03d", i);
            String password = year + memberNewDtos.get(i).getFirstSSN() + String.format("%03d", i);
            memberRepository.save(new Member(Long.parseLong(str), memberNewDtos.get(i).getFirstSSN(), memberNewDtos.get(i).getLastSSN(), memberNewDtos.get(i).getName(), password, (byte) 3, department));
        }
    }

    public Boolean findMember(Long sessionUser) {
        MemberFindInfo byMemberNumber = memberRepository.findMnAndPwByMemberNumber(sessionUser);

        if (sessionUser != null && byMemberNumber.getMemberStatus() == 1) {
            log.info("해당 유저는 관리자 입니다.");
            return true;

        }

        return false;
    }

    public MemberDto memberFind(Long memberNumber) {

        Member findMember = memberRepository.findByMemberNumber(memberNumber);

        if (findMember == null) {
            throw new NullPointerException("존재하지 않는 아이디입니다.");
        } else {
            MemberDto memberDto = new MemberDto();
            memberDto.setMemberName(findMember.getMemberName());
            memberDto.setMemberNumber(findMember.getMemberNumber());
            memberDto.setDepartmentName(findMember.getDepartment().getDepartmentName());
            memberDto.setFirstSSN(findMember.getFirstSSN());
            memberDto.setLastSSN(findMember.getLastSSN());
            return memberDto;
        }
    }
}
