package server.service_implement;

import bean.Supplier;
import dao.dao_Impl.SupplieDaoImpl;
import dao.dao_interface.SupplierDao;
import server.service_interface.SupplierService;

import java.util.List;

public class SupplierServiceImlp implements SupplierService {
    SupplierDao supplierDao = new SupplieDaoImpl();

    @Override
    public Integer insert(Supplier bean) {
        return supplierDao.insert(bean);
    }

    @Override
    public Integer update(Supplier bean) {
        return supplierDao.update(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return supplierDao.delete(id);
    }

    @Override
    public List<Supplier> list() {
        return supplierDao.list();
    }
}
