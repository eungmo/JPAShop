package jpabook.jpashop.service;

import jpabook.jpashop.TestDescription;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

// SpringRunner.class의 별칭
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @TestDescription("회원가입")
    public void registration() throws Exception {

        // Given
        Member member = new Member();
        member.setName("Kim");

        // When
        Long savedId = this.memberService.join(member);

        // Then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

//    @Test(expected = IllegalStateException.class)
    @Test
    @TestDescription("중복 회원 예외")
    public void duplicationCheck() throws Exception {

        // Expected
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("이미 존재하는 회원입니다.");

        // Given
        Member member = new Member();
        member.setName("Choi");

        // When
        Long savedId = this.memberService.join(member);
        this.memberService.join(member);

        // Then
        fail("예외가 발생해야 한다.");
    }

}