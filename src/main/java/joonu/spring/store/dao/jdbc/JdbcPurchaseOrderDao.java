package joonu.spring.store.dao.jdbc;

import joonu.spring.store.dao.PurchaseOrderDao;
import joonu.spring.store.vo.PurchaseOrder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

public class JdbcPurchaseOrderDao implements PurchaseOrderDao {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public JdbcPurchaseOrderDao(SimpleJdbcInsert insert) {
        this.simpleJdbcInsert = insert;
        insert.withTableName("PURCHASE_ORDER").usingColumns(
                "PURCHASE_ORDER_ID", "ITEM_ID", "PAYMENT_INFO_ID", "ADDRESS"
        );
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public int nextVal(){
        Map<String, Object> emptyMap = new HashMap<>();
        return namedJdbcTemplate.queryForObject("select purchase_seq.nextval from dual", emptyMap, Integer.class);
    }

    @Override
    public void insert(PurchaseOrder order) {
        Map<String, Object> args = new HashMap<>();
        order.setId(nextVal());
        args.put("PURCHASE_ORDER_ID", order.getId());
        args.put("ITEM_ID", order.getItemId());
        args.put("PAYMENT_INFO_ID", order.getPaymentInfoId());
        args.put("ADDRESS", order.getAddress());
        simpleJdbcInsert.execute(args);
    }
}
