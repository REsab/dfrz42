package test.supplierr;

import bean.Supplier;
import dao.dao_Impl.SupplieDaoImpl;

import java.util.List;

public class select {
    public static void main(String[] args) {

        SupplieDaoImpl customerDao = new SupplieDaoImpl();

        List<Supplier> para = customerDao.list();

        int i = 0;
        for (Supplier bean :
                para) {
            System.out.print(bean.getSupplierId() + "   ");
            System.out.println(bean.getAddress());

        }
        System.out.println("dfjldssd ");

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
