package server.service_interface;

import bean.Supplier;

import java.util.List;

public interface SupplierService {
    public Integer insert(Supplier bean);


    public Integer update(Supplier bean) ;


    public Integer delete(Integer id) ;



    public List<Supplier> list() ;
}
