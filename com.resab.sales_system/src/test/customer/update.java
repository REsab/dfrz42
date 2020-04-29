package test.customer;

import bean.Customer;
import dao.dao_Impl.CustomerDaoImpl;

import java.util.List;

public class update {
    public static void main(String[] args) {

        CustomerDaoImpl co = new CustomerDaoImpl();

        Customer bean = new Customer();
        bean.setName("dlf");
        bean.setAddress("dlfsa");
        bean.setPhone("dlf");
        bean.setFax("dlf");
        bean.setPostalCode("dlfs");
        bean.setConstactPerson("dfd");
        bean.setCustomerId(582);
        co.update(bean);

        List<Customer> para = co.list();
        int i = 0;
        for (Customer bean1 :
                para) {
            System.out.print(bean1.getName() + "   ");
            System.out.println(bean1.getCustomerId());
        }


    }
}
