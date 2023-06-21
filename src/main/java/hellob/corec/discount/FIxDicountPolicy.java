package hellob.corec.discount;

import hellob.corec.member.Grade;
import hellob.corec.member.Member;

public class FIxDicountPolicy implements  DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
