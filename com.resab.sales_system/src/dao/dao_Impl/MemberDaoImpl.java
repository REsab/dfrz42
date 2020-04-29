package dao.dao_Impl;

import bean.Member;
import dao.dao_interface.MemberDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    @Override
    public Integer insert(Member bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句
//        sbSQL.append(" insert into member\n" +
//                "                (\n" +
//                "                        UserName, UserPass, NickName, Email,\n" +
//                "                        Mobile, MyId, MyIdKey, RegIp,\n" +
//                "                        RegDate, LastLoginIp, LastLoginTime, Salt,\n" +
//                "                        Secques, Status, Remark, SortNum,\n" +
//                "                        IsDeleted, CreateBy, UpdateBy, CreateOn,\n" +
//                "                        UpdateOn)\n" +
//                "        value (\n" +
//                "\n" +
//                "                'tom1', '123', 'peiqi1', '1231@qq.com',\n" +
//                "                '12345678', '4444', '2345', '444',\n" +
//                "                '2019-1-1', '123.123.123.22', '2019-3-9', '1234',\n" +
//                "                '34', '234', 'q3435', 33,\n" +
//                "                0, 1, 2,   '2019-4-5',\n" +
//                "                '2019-3-6'\n" +
//                "        )\n");


        sbSQL.append(" insert into member\n" +
                "                (\n" +
                "              UserName, UserPass, NickName, Email,\n" +
                "              Mobile, MyId, MyIdKey, RegIp,\n" +
                "              RegDate, LastLoginIp, LastLoginTime, Salt,\n" +
                "              Secques, Status, Remark, SortNum,\n" +
                "              IsDeleted, CreateBy, UpdateBy, CreateOn,\n" +
                "              UpdateOn)\n" +
                "        value (" +
                "     ?,?,?,?  ,         " +
                "     ?,?,?,?  ,         " +
                "     ?,?,?,?  ,         " +
                "     ?,?,?,?  ,         " +
                "     ?,?,?,?          " +
                "          ,?           " +
                "        )\n");

        String sql = sbSQL.toString();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getUserName());
            pstmt.setObject(2, bean.getUserPass());
            pstmt.setObject(3, bean.getNickName());
            pstmt.setObject(4, bean.getEmail());
            pstmt.setObject(5, bean.getMobile());
            pstmt.setObject(6, bean.getMyId());
            pstmt.setObject(7, bean.getMyIdKey());
            pstmt.setObject(8, bean.getRegIp());
            pstmt.setObject(9, bean.getRegDate());
            pstmt.setObject(10, bean.getLastLoginIp());
            pstmt.setObject(11, bean.getLastLoginTime());
            pstmt.setObject(12, bean.getSalt());
            pstmt.setObject(13, bean.getSecques());
            pstmt.setObject(14, bean.getStatus());
            pstmt.setObject(15, bean.getRemark());
            pstmt.setObject(16, bean.getSortNum());
            pstmt.setObject(17, bean.getIsDeleted());
            pstmt.setObject(18, bean.getCreateBy());
            pstmt.setObject(19, bean.getUpdateBy());
            pstmt.setObject(20, bean.getCreateOn());
            pstmt.setObject(21, bean.getUpdateOn());


            num = pstmt.executeUpdate();

            if (num > 0) {
                sql = " select @@Identity";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    num = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            DbPub.close(conn, pstmt, rs);
        }
        return num;


    }

    @Override
    public Integer update(Member bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();
        String sql = "update member\n" +
                "set UserName      = ?,\n" +
                "    UserPass      = ?,\n" +
                "    NickName      = ?,\n" +
                "    Email         =?,\n" +
                "    Mobile        = ?,\n" +
                "    MyId          =?,\n" +
                "    MyIdKey       =?,\n" +
                "    RegIp         = ?,\n" +
                "    RegDate       = ?,\n" +
                "    LastLoginIp   =?,\n" +
                "    LastLoginTime = ?,\n" +
                "    Salt          = ?,\n" +
                "    Secques       =?,\n" +
                "    Status        = ?,\n" +
                "    Remark        =?,\n" +
                "    SortNum       =?,\n" +
                "    IsDeleted     =?,\n" +
                "    CreateBy      =?,\n" +
                "    UpdateBy      =?,\n" +
                "    CreateOn      =?,\n" +
                "    UpdateOn      = ?\n" +
                "where userid      = ?;";

        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getUserName());
            pstmt.setObject(2, bean.getUserPass());
            pstmt.setObject(3, bean.getNickName());
            pstmt.setObject(4, bean.getEmail());
            pstmt.setObject(5, bean.getMobile());
            pstmt.setObject(6, bean.getMyId());
            pstmt.setObject(7, bean.getMyIdKey());
            pstmt.setObject(8, bean.getRegIp());
            pstmt.setObject(9, bean.getRegDate());
            pstmt.setObject(10, bean.getLastLoginIp());
            pstmt.setObject(11, bean.getSalt());
            pstmt.setObject(12, bean.getSecques());
            pstmt.setObject(13, bean.getStatus());
            pstmt.setObject(14, bean.getRemark());
            pstmt.setObject(15, bean.getSortNum());
            pstmt.setObject(16, bean.getIsDeleted());
            pstmt.setObject(17, bean.getCreateBy());
            pstmt.setObject(18, bean.getCreateOn());
            pstmt.setObject(19, bean.getUpdateBy());
            pstmt.setObject(20, bean.getCreateOn());
            pstmt.setObject(21, bean.getUpdateOn());

            pstmt.setObject(22, bean.getUserId());

            num = pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("执行[" + sql + "]出现错误.");
        } finally {
            DbPub.close(conn, pstmt, rs);
        }
        return num;
    }

    @Override
    public Integer delete(Integer id) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();
        PreparedStatement pstmt = null;
        Connection conn = null;
        Integer num = 0;


        sbSQL.append("delete from member\n" +
                "where UserId=?;  ");

        String sql = sbSQL.toString();

        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, id);
            num = pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            DbPub.close(conn);
        }
        return num;
    }

    @Override
    public List<Member> list() {
        List<Member> list = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from member";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            Member tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new Member();
                tmpBean.setUserId(rs.getInt("UserId"));
                tmpBean.setUserName(rs.getString("UserName"));
                tmpBean.setUserPass(rs.getString("UserPass"));
                tmpBean.setNickName(rs.getString("NickName"));
                tmpBean.setEmail(rs.getString("Email"));
                tmpBean.setMobile(rs.getString("mobile"));
                tmpBean.setMyId(rs.getString("myid"));
                tmpBean.setMyIdKey(rs.getString("myidkey"));
                tmpBean.setRegIp(rs.getString("RegIp"));
                tmpBean.setRegDate(rs.getTimestamp("RegDate"));
                tmpBean.setLastLoginIp(rs.getString("LastLoginIp"));
                tmpBean.setLastLoginTime(rs.getTimestamp("LastLoginTime"));
                tmpBean.setSalt(rs.getString("Salt"));
                tmpBean.setSecques(rs.getString("Secques"));
                tmpBean.setStatus(rs.getString("Status"));
                tmpBean.setRegDate(rs.getTimestamp("RegDate"));
                tmpBean.setSortNum(rs.getInt("SortNum"));
                tmpBean.setIsDeleted(rs.getLong("IsDeleted"));
                tmpBean.setCreateBy(rs.getInt("Createby"));
                tmpBean.setUpdateBy(rs.getInt("UpdateBy"));
                tmpBean.setCreateOn(rs.getTimestamp("CreateOn"));
                tmpBean.setUpdateOn(rs.getTimestamp("updateOn"));


                list.add(tmpBean);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("执行[" + sql + "]出现错误.");
        } finally {
            DbPub.close(conn, rs);
        }
        return list;
    }
}
