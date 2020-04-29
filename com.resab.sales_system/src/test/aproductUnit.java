package test;

import bean.ProductUnit;
import dao.dao_Impl.ProductUnitDaoImpl;

import java.util.List;

public class aproductUnit {


    public static void main(String[] args) {


        ProductUnitDaoImpl customerDao = new ProductUnitDaoImpl();
//  查
        List<ProductUnit> para = customerDao.list();

        for (ProductUnit bean :
                para) {
            System.out.print(bean.getUnitId() + "      ");
            System.out.println(bean.getName());

        }
        System.out.println("dfjldssd ");


        ProductUnit bean = new ProductUnit();
        bean.setUnitId(12);
        bean.setName("asdf");
        bean.setRemark("123");

        customerDao.insert(bean);

        System.out.println("insert ");

        para = customerDao.list();

        for (ProductUnit bean1 :
                para) {
            System.out.print(bean1.getUnitId() + "      ");
            System.out.println(bean1.getName());

        }


        bean.setName("we35323");
        bean.setUnitId(4);
        customerDao.update(bean);
        para = customerDao.list();

        for (ProductUnit bean2 :
                para) {
            System.out.print(bean2.getUnitId() + "      ");
            System.out.println(bean2.getName());

        }
        System.out.println("dfjldssd ");

        customerDao.delete(6);


        para = customerDao.list();

        for (ProductUnit bean2 :
                para) {
            System.out.print(bean2.getUnitId() + "      ");
            System.out.println(bean2.getName());

        }
        System.out.println("dfjldssd ");


    }


}
