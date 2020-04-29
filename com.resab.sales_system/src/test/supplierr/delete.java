package test.supplierr;

import bean.Supplier;
import dao.dao_Impl.SupplieDaoImpl;

import java.util.List;

public class delete {
    public static void main(String[] args) {


        SupplieDaoImpl customerDao = new SupplieDaoImpl();

        if (0 < customerDao.delete(2)) {
            System.out.println("sussess");
        }


        List<Supplier> para = customerDao.list();

        for (Supplier bean :
                para) {
            System.out.print(bean.getSupplierId() + "   ");
            System.out.println(bean.getName());

        }


    }
}
