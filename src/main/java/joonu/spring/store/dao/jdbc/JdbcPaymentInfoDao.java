package joonu.spring.store.dao.jdbc;

import joonu.spring.store.dao.PaymentInfoDao;
import joonu.spring.store.vo.PaymentInfo;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JdbcPaymentInfoDao implements PaymentInfoDao {

    private SimpleJdbcInsert insert;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public JdbcPaymentInfoDao(SimpleJdbcInsert insert) {
        this.insert = insert;
        insert.withTableName("PAYMENT_INFO").usingColumns("PAYMENT_INFO_ID", "PRICE");
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public int nextVal() {
        return namedJdbcTemplate.queryForObject("select payment_seq.nextval from dual",
                Collections.<String, Object>emptyMap(), Integer.class);
    }

    @Override
    public void insert(PaymentInfo paymentInfo) {
        Map<String, Object> paramValueMap = new HashMap<>();
        paymentInfo.setId(nextVal());
        paramValueMap.put("PAYMENT_INFO_ID", paymentInfo.getId());
        paramValueMap.put("PRICE", paymentInfo.getPrice());
        insert.execute(paramValueMap);
    }
}
