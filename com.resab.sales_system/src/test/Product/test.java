package test.Product;

import bean.Product;
import dao.dao_Impl.ProductDaoImlp;

import java.util.List;

public class test {

    public static void main(String[] args) {


        ProductDaoImlp customerDao = new ProductDaoImlp();
//  查
        List<Product> para = customerDao.list();

        for (Product bean :
                para) {
            System.out.print(bean.getProductId() + "      ");
            System.out.println(bean.getName());

        }
        System.out.println("dfjldssd ");


        Product bean=new Product();
        bean.setUserId(12);
        bean.setName("asdf");
        bean.setPrice(2134);
        bean.setProductId(1233);
        bean.setProductId(12);

        customerDao.insert(bean);

        System.out.println("insert ");

        para = customerDao.list();

        for (Product bean1 :
                para) {
            System.out.print(bean1.getProductId() + "      ");
            System.out.println(bean1.getName());

        }


        bean.setName("we35323");
        bean.setProductId(4);
        customerDao.update(bean);
        para = customerDao.list();

        for (Product bean2 :
                para) {
            System.out.print(bean2.getProductId() + "      ");
            System.out.println(bean2.getName());

        }
        System.out.println("dfjldssd ");

        customerDao.delete(5);




        para = customerDao.list();

        for (Product bean2 :
                para) {
            System.out.print(bean2.getProductId() + "      ");
            System.out.println(bean2.getName());

        }
        System.out.println("dfjldssd ");




    }

}
