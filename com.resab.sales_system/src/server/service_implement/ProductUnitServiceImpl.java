package server.service_implement;

import bean.ProductUnit;
import dao.dao_Impl.ProductUnitDaoImpl;
import dao.dao_interface.ProductUnitDao;
import server.service_interface.ProductUnitService;

import java.util.List;

public class ProductUnitServiceImpl implements ProductUnitService {

    ProductUnitDao productUnitDao = new ProductUnitDaoImpl();

    @Override
    public Integer insert(ProductUnit bean) {
        return productUnitDao.insert(bean);

    }

    @Override
    public Integer update(ProductUnit bean) {
        return productUnitDao.update(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return productUnitDao.delete(id);
    }

    @Override
    public List<ProductUnit> list() {
        return productUnitDao.list();
    }
}
