package test.member;

import bean.Member;
import server.service_implement.MemberServiceImpl;

import java.util.List;

public class select {
    public static void main(String[] args) {

       MemberServiceImpl customerDao = new MemberServiceImpl();

        List<Member> para = customerDao.list();
//        List<MemberDao> para = customerDao.list();

        int i = 0;
        for (Member bean :
                para) {
            System.out.print(bean.getUserName() + "   ");
            System.out.println(bean.getMyId());

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
