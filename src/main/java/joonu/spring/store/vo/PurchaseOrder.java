package joonu.spring.store.vo;

public class PurchaseOrder {
    private int id;
    private int itemId;
    private String address;
    private int paymentInfoId;

    public PurchaseOrder(){}

    public PurchaseOrder(int itemId, String address, int paymentInfoId) {
        this.itemId = itemId;
        this.address = address;
        this.paymentInfoId = paymentInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPaymentInfoId() {
        return paymentInfoId;
    }

    public void setPaymentInfoId(int paymentInfoId) {
        this.paymentInfoId = paymentInfoId;
    }
}
