package joonu.spring.store.dao.jdbc;

import joonu.spring.store.dao.ItemDao;
import joonu.spring.store.vo.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcItemDao implements ItemDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Item findById(Integer itemId) {
        return jdbcTemplate.queryForObject("select * from ITEM where ITEM_ID=?", new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                item.setId(rs.getInt("ITEM_ID"));
                item.setPrice(rs.getInt("PRICE"));
                return item;
            }
        }, new Object[]{itemId});
    }
}
