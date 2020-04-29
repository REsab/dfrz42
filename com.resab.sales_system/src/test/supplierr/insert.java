package test.supplierr;

import bean.Supplier;
import dao.dao_Impl.SupplieDaoImpl;
import tools.DbPub;

import java.sql.Connection;
import java.sql.Timestamp;

;

public class insert {

    public static void main(String[] args) {

        Connection connection = DbPub.getConn();
        System.out.println("sldfdj");
        SupplieDaoImpl customerDao = new SupplieDaoImpl();
        Supplier bean = new Supplier();

        bean.setName("323");
        bean.setAddress("lfdk");
        bean.setPhone("ldsf");



        Timestamp timestamp = new Timestamp(12213131);




        if (0 < customerDao.insert(bean)) {
            System.out.println("顺昌flsdkfj");

        }


    }
}
