package jpabook.jpashop.web;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
public class AppRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private MemberService memberService;

    @Autowired
    private ItemService itemService;

    @PostConstruct
    public void init() {
        Member member = Member.builder()
                .name("Simon")
                .address(new Address("서울", "독서당로", "123"))
                .build();
        memberService.join(member);

        Book book = Book.builder()
                .name("JPA 기본")
                .price(25000)
                .stockQuantity(10)
                .author("김땡땡")
                .isbn("ABC123412341234")
                .build();
        itemService.saveItem(book);

        System.out.println("초기 작업 완료!");


    }
}
