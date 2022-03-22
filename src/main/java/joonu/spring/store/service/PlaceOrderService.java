package joonu.spring.store.service;

import joonu.spring.store.vo.ItemNotFoundException;
import joonu.spring.store.vo.PurchaseOrderRequest;
import joonu.spring.store.vo.PurchaseOrderResult;

public interface PlaceOrderService {
    public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException;
}
