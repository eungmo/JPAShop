package jpabook.jpashop.noncomponentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NonAutowiredBean {

    public String text = "테스트 스트링입니다.";
}
