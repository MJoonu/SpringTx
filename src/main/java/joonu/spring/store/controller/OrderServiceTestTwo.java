package joonu.spring.store.controller;

import joonu.spring.store.service.PlaceOrderService;
import joonu.spring.store.vo.PurchaseOrderRequest;
import joonu.spring.store.vo.PurchaseOrderResult;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderServiceTestTwo {
    private PlaceOrderService placeOrderService;
    private AbstractApplicationContext context;

    public OrderServiceTestTwo() {
        String[] configLocations = new String[]{"applicationContext.xml", "transactionTwo.xml"};
        context = new ClassPathXmlApplicationContext(configLocations);
        placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
    }

    public void order() {
        PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
        orderRequest.setItemId(2);
        orderRequest.setAddress("서울 강남구");
        PurchaseOrderResult orderResult = placeOrderService.order(orderRequest); System.out.println("주문상태 정보");
        System.out.println("아이템 : " + orderResult.getItem().getId());
        System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
    }
    public void close() {
        context.close();
    }

    public static void main(String[] args) {
        OrderServiceTestTwo test = new OrderServiceTestTwo();
        test.order();
        test.close();
    }
}
