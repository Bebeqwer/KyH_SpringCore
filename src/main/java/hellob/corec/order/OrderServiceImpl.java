package hellob.corec.order;

import hellob.corec.discount.DiscountPolicy;
import hellob.corec.discount.FIxDicountPolicy;
import hellob.corec.member.Member;
import hellob.corec.member.MemberRepository;
import hellob.corec.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
