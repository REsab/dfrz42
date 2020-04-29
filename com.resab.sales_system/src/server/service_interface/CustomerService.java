package server.service_interface;

import bean.Customer;

import java.util.List;

public interface CustomerService {



    public Integer insert(Customer bean);


    public Integer update(Customer bean);

    public Integer delete(Integer id);

    public List<Customer> list() ;

}
