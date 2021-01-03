package jpabook.jpashop.noncomponentscan;

import jpabook.jpashop.TestDescription;
import jpabook.jpashop.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class NonAutowiredBeanTest {

    @Autowired(required = false)
    private NonAutowiredBean nonAutowiredBean;

    @Autowired(required = false)
    private MemberService memberService;

    @Test
    @TestDescription("주입되지 않은 빈 테스트")
    public void nonAutowiredBeanTest() {

        assertNull(this.nonAutowiredBean);

        assertNotNull(this.memberService);

    }

}