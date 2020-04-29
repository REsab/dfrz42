package server.service_implement;

import bean.Product;
import dao.dao_Impl.ProductDaoImlp;
import dao.dao_interface.ProductDao;
import server.service_interface.ProductService;

import java.util.List;

public class ProductServiceImlp implements ProductService {

    ProductDao productDao = new ProductDaoImlp();

    @Override
    public Integer insert(Product bean) {
        return productDao.insert(bean);
    }

    @Override
    public Integer update(Product bean) {
        return productDao.update(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public List<Product> list() {
        return productDao.list();
    }
}
