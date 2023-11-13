package com.scw.webframework_backend.repository;


import com.scw.webframework_backend.domain.Member;
import com.scw.webframework_backend.repository.dao.MemberFindInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public MemberFindInfo findMnAndPwByMemberNumber(Long memberNumber);

    public Member findByMemberNumber(Long memberNumber);
}
