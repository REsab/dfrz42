package test.supplierr;

import bean.Supplier;
import dao.dao_Impl.SupplieDaoImpl;

import java.util.List;

public class update {
    public static void main(String[] args) {

        SupplieDaoImpl co = new SupplieDaoImpl();

        Supplier bean = new Supplier();

        bean.setName("dlf");
        bean.setAddress("dfdf");
        bean.setPhone("dlsf");
        bean.setConstactPerson("dlfddlf");


        co.update(bean);

        List<Supplier> para = co.list();
        int i = 0;
        for (Supplier bean1 :
                para) {
            System.out.print(bean1.getName() + "   ");
            System.out.print(bean1.getSupplierId());
            System.out.println();
        }


    }
}
