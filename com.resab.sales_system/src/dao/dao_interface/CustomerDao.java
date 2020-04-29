package dao.dao_interface;

import bean.Customer;

import java.util.List;

public interface CustomerDao {

    Integer insert(Customer bean);

    Integer update(Customer bean);

    Integer delete(Integer id);

    List<Customer> list();




}




