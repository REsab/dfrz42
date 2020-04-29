package test.member;

import bean.Member;
import dao.dao_Impl.MemberDaoImpl;

import java.util.List;

public class delete {
    public static void main(String[] args) {


        MemberDaoImpl customerDao = new MemberDaoImpl();

        if ( 0 < customerDao.delete(2)){
            System.out.println("sussess");
        }


        List<Member> para = customerDao.list();

        for (Member bean :
                para) {
            System.out.print(bean.getUserName() + "   ");
            System.out.println(bean.getMyId());

        }


    }
}
