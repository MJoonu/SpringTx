package joonu.spring.store.vo;

public class PaymentInfo {
    private int id;
    private int price;

    public PaymentInfo(){}

    public PaymentInfo(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
