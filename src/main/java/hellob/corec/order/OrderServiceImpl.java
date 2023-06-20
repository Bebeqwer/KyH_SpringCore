package hellob.corec.order;

import hellob.corec.discount.DiscountPolicy;
import hellob.corec.discount.FIxDicountPolicy;
import hellob.corec.member.Member;
import hellob.corec.member.MemberRepository;
import hellob.corec.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDicountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
