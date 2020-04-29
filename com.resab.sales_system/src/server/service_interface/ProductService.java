package server.service_interface;

import bean.Product;

import java.util.List;

public interface ProductService {

    public Integer insert(Product bean);

    public Integer update(Product bean);

    public Integer delete(Integer id);

    public List<Product> list();


}
