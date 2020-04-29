package dao.dao_interface;

import bean.Supplier;

import java.util.List;

public interface

SupplierDao {

    Integer insert(Supplier bean);

    Integer update(Supplier bean);

    Integer delete(Integer id);

    List<Supplier> list();

}
