package hellob.corec.order;

import hellob.corec.discount.DiscountPolicy;
import hellob.corec.discount.FIxDicountPolicy;
import hellob.corec.member.MemberService;
import hellob.corec.member.MemberServiceImpl;
import hellob.corec.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FIxDicountPolicy();
    }
}
