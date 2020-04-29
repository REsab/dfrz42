package server.service_interface;

import bean.ProductUnit;

import java.util.List;

public interface ProductUnitService {

    public Integer insert(ProductUnit bean);


    public Integer update(ProductUnit bean);

    public Integer delete(Integer id);

    public List<ProductUnit> list();

}
