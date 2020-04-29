package test.member;

import bean.Member;
import dao.dao_Impl.MemberDaoImpl;

import java.util.List;

public class update {
    public static void main(String[] args) {

        MemberDaoImpl co = new MemberDaoImpl();

        Member bean = new Member();
        bean.setUserName("23232342423");
        bean.setUserPass("23");
        bean.setNickName("3332");
        bean.setEmail("dlfd");
        bean.setUserId(5);

        co.update(bean);

        List<Member> para = co.list();
        int i = 0;
        for (Member bean1 :
                para) {
            System.out.print(bean1.getUserName() + "   ");
            System.out.print(bean1.getMyId());
            System.out.print(bean1.getUserId());
            System.out.print(bean1.getUserId());
            System.out.print(bean1.getUserId());
            System.out.println(bean1.getUserId());
        }


    }
}
