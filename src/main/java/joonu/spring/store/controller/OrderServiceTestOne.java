package joonu.spring.store.controller;

import joonu.spring.store.service.PlaceOrderService;
import joonu.spring.store.vo.PurchaseOrderRequest;
import joonu.spring.store.vo.PurchaseOrderResult;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderServiceTestOne {
    private PlaceOrderService placeOrderService;
    private AbstractApplicationContext context;

    public OrderServiceTestOne(){
        String[] configLocations = new String[]{"transactionOne.xml"};
        context = new ClassPathXmlApplicationContext(configLocations);
        placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
    }

    public void order(){
        PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
        orderRequest.setItemId(1);
        orderRequest.setAddress("서울 종로구");

        PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);

        System.out.println("주문 상태 정보");
        System.out.println("아이템 : " + orderResult.getItem().getId());
        System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
    }

    public void close(){
        context.close();
    }

    public static void main(String[] args) {
        OrderServiceTestOne test = new OrderServiceTestOne();
        test.order();
        test.close();
    }
}
