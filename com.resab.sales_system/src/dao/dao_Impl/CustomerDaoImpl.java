package dao.dao_Impl;

import bean.Customer;
import dao.dao_interface.CustomerDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public Integer insert(Customer bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句
        sbSQL.append("INSERT INTO `customer`(\n" +
                "Name,address,phone,fax\n" +
                ",postalcode,constactperson\n" +
                ") VALUES ( ?, ?, ?, ?, ?, ?)");

        String sql = sbSQL.toString();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getAddress());
            pstmt.setObject(3, bean.getPhone());
            pstmt.setObject(4, bean.getFax());
            pstmt.setObject(5, bean.getPostalCode());
            pstmt.setObject(6, bean.getConstactPerson());

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
    public Integer update(Customer bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        sbSQL.append(
                "update customer \n" +
                        "set \n" +
                        "    NAME           =?,    " +
                        "    Address    =  ?,     \n" +
                        "    Phone          = ?,   " +
                        "    Fax            = ?,   \n" +
                        "    PostalCode=?,          " +
                        " ConstactPerson =?         \n" +
                        "where Customer_ID = ?;");

        String sql = sbSQL.toString();


        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getAddress());
            pstmt.setObject(3, bean.getPhone());
            pstmt.setObject(4, bean.getFax());
            pstmt.setObject(5, bean.getPostalCode());
            pstmt.setObject(6, bean.getConstactPerson());
            pstmt.setObject(7, bean.getCustomerId());


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

    ////
    @Override
    public Integer delete(Integer id) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();
        PreparedStatement pstmt = null;
        Connection conn = null;
        Integer num = 0;



        sbSQL.append(" delete from Customer " +
                "          where Customer_Id = ?; ");

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

    //
    @Override
    public List<Customer> list() {
        // TODO Auto-generated method stub
        List<Customer> list = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from customer";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            Customer tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new Customer();

                tmpBean.setCustomerId(rs.getInt("Customer_ID"));
                tmpBean.setName(rs.getString("Name"));
                tmpBean.setPhone(rs.getString("Phone"));
                tmpBean.setAddress(rs.getString("Address"));
                tmpBean.setFax(rs.getString("Fax"));
                tmpBean.setConstactPerson(rs.getString("constactPerson"));
                tmpBean.setPostalCode(rs.getString("PostalCode"));

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
