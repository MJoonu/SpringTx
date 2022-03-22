package joonu.spring.store.service;

import joonu.spring.store.dao.ItemDao;
import joonu.spring.store.dao.PaymentInfoDao;
import joonu.spring.store.dao.PurchaseOrderDao;
import joonu.spring.store.service.PlaceOrderService;
import joonu.spring.store.vo.*;
import org.springframework.transaction.annotation.Transactional;

public class PlaceOrderServiceImplThree implements PlaceOrderService {
    private ItemDao itemDao;
    private PaymentInfoDao paymentInfoDao;
    private PurchaseOrderDao purchaseOrderDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public void setPaymentInfoDao(PaymentInfoDao paymentInformationDao) {
        this.paymentInfoDao = paymentInformationDao;
    }

    public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }

    @Override
    @Transactional
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
