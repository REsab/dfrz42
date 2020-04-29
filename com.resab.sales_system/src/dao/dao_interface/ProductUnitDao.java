package dao.dao_interface;


import bean.ProductUnit;

import java.util.List;



public interface ProductUnitDao {


    Integer insert(ProductUnit bean);

    Integer update(ProductUnit bean);

    Integer delete(Integer id);

    List<ProductUnit> list();
}
