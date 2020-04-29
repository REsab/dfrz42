package test.customer;

import bean.Customer;
import server.service_implement.CustomerServiceImpl;

import java.util.List;

public class select {
    public static void main(String[] args) {

         CustomerServiceImpl customerDao = new CustomerServiceImpl();

        List<Customer> para = customerDao.list();

        int i = 0;
        for (Customer bean :
                para) {
            System.out.print(bean.getName()+"   ");
            System.out.println(bean.getCustomerId());

        }


//        System.out.println(customerDao.list());
//
//        List<Grade> list = gradeService.LIST();
//        System.out.println("\t");
//        System.out.print("序号\t");
//        System.out.print("年级id\t");
//        System.out.print("年级名称\t");
//        System.out.println("");
//
//        int i = 0;
//        for (Grade bean :
//                list) {
//            System.out.println("\t");
//
//            System.out.print(bean.getGradeId() + "\t");
//            System.out.print(bean.getGradeName() + "\t");
//
//
//        }
//        System.out.println();

    }
}
