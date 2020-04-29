package server.service_implement;

import bean.Customer;
import dao.dao_Impl.CustomerDaoImpl;
import server.service_interface.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {


    CustomerDaoImpl customerDao = new CustomerDaoImpl();


    public Integer insert(Customer bean) {
        return customerDao.insert(bean);
    }

    public Integer update(Customer bean) {
        return customerDao.update(bean);
    }

    public Integer delete(Integer id) {
        return customerDao.delete(id);
    }

    public List<Customer> list() {
        return customerDao.list();
    }
}
