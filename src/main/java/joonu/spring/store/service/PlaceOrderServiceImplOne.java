package joonu.spring.store.service;

import joonu.spring.store.dao.ItemDao;
import joonu.spring.store.dao.PaymentInfoDao;
import joonu.spring.store.dao.PurchaseOrderDao;
import joonu.spring.store.vo.*;

public class PlaceOrderServiceImplOne implements PlaceOrderService {
    private ItemDao itemDao;
    private PaymentInfoDao paymentInfoDao;
    private PurchaseOrderDao purchaseOrderDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void setPaymentInfoDao(PaymentInfoDao paymentInfoDao) {
        this.paymentInfoDao = paymentInfoDao;
    }

    public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }


    @Override
    public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
        Item item = itemDao.findById(orderRequest.getItemId());

        if (item == null) throw new ItemNotFoundException(orderRequest.getItemId());

        PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
        paymentInfoDao.insert(paymentInfo);

        PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest.getAddress(), paymentInfo.getId());
        purchaseOrderDao.insert(order);

        return new PurchaseOrderResult(item, paymentInfo, order);
    }
}
