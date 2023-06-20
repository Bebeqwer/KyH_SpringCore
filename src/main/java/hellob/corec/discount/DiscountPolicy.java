package hellob.corec.discount;

import hellob.corec.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
