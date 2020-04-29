package test.customer;

import bean.Customer;
import dao.dao_Impl.CustomerDaoImpl;

import java.util.List;

public class delete {
    public static void main(String[] args) {


        CustomerDaoImpl customerDao = new CustomerDaoImpl();

        customerDao.delete(1);





        List<Customer> para = customerDao.list();

        int i = 0;
        for (Customer bean :
                para) {
            System.out.print(bean.getName()+"   ");
            System.out.println(bean.getCustomerId());

        }


    }
}
