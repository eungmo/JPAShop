package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplication(member);    // 중복 회원 검증
        this.memberRepository.save(member);
        return member.getId();  //TODO 되는지 체크
    }

    private void validateDuplication(Member member) {
        List<Member> findMembers = this.memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return this.memberRepository.findOne(memberId);
    }


}
