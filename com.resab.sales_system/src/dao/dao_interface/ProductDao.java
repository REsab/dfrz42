package dao.dao_interface;

import bean.Product;

import java.util.List;

public interface ProductDao {

    Integer insert(Product bean);

    Integer update(Product bean);

    Integer delete(Integer id);

    List<Product> list();
}
