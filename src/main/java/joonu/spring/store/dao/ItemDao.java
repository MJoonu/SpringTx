package joonu.spring.store.dao;

import joonu.spring.store.vo.Item;

public interface ItemDao {
    Item findById(Integer itemId);
}
