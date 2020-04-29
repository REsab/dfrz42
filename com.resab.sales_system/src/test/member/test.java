package test.member;

import bean.Member;
import dao.dao_Impl.MemberDaoImpl;
import tools.DbPub;

import java.sql.Connection;
import java.sql.Timestamp;

;

public class test {

    public static void main(String[] args) {

        Connection connection = DbPub.getConn();
        System.out.println("sldfdj");
        MemberDaoImpl customerDao = new MemberDaoImpl();
        Member bean = new Member();
        Timestamp timestamp = new Timestamp(12213131);

        bean.setUserName("123");
        bean.setUserPass("123");
        bean.setNickName("23");
        bean.setEmail("2343");
        bean.setMobile("23");
        bean.setMyId("23");
        bean.setMyIdKey("dfs");
        bean.setRegIp("123.123.131.133");
        bean.setRegDate(timestamp);
        bean.setLastLoginIp("12344");
        bean.setLastLoginTime(timestamp);
        bean.setSalt("df");
        bean.setSecques("大震");
        bean.setStatus("sf");
        bean.setRegDate(timestamp);
        bean.setSortNum(1);
        bean.setIsDeleted(2);
        bean.setCreateBy(0);
        bean.setUpdateBy(1);
        bean.setCreateOn(timestamp);
        bean.setUpdateOn((timestamp));


        if (0 < customerDao.insert(bean)) {
            System.out.println("顺昌flsdkfj");

        }


    }
}
