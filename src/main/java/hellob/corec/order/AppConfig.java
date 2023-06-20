package hellob.corec.order;

import hellob.corec.discount.FIxDicountPolicy;
import hellob.corec.member.MemberService;
import hellob.corec.member.MemberServiceImpl;
import hellob.corec.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FIxDicountPolicy()
        );
    }
}
