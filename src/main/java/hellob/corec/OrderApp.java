package hellob.corec;

import hellob.corec.member.Grade;
import hellob.corec.member.Member;
import hellob.corec.member.MemberService;
import hellob.corec.member.MemberServiceImpl;
import hellob.corec.order.AppConfig;
import hellob.corec.order.Order;
import hellob.corec.order.OrderService;
import hellob.corec.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig =new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " +order);
    }
}
