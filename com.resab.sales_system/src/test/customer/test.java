package test.customer;

import bean.Customer;
import server.service_implement.CustomerServiceImpl;
import tools.DbPub;

import java.sql.Connection;

public class test {

    public static void main(String[] args) {


        //插入测试

        Connection connection = DbPub.getConn();

        System.out.println("sldfdj");

        CustomerServiceImpl customerDao = new CustomerServiceImpl();


        Customer bean = new Customer();


        bean.setName("123");
        bean.setAddress("123");
        bean.setConstactPerson("slf");
        bean.setFax("e3rf");
        bean.setPostalCode("ldfdlf");
        bean.setPhone("fldsfalf");


        if (0 < customerDao.insert(bean)) {
            System.out.println("顺昌flsdkfj");

        }


    }
}
