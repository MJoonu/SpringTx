package joonu.spring.store.vo;

public class ItemNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;
    private Integer itemId;

    public ItemNotFoundException(Integer itemId) {
        super("not found item : id = " + itemId);
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }
}
