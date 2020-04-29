package dao.dao_Impl;

import bean.Supplier;
import dao.dao_interface.SupplierDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplieDaoImpl implements SupplierDao {
    @Override
    public Integer insert(Supplier bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句


        String sql = "insert into supplier (" +
                "NAME, Address, Phone, Fax,\n" +
                "PostalCode, ConstactPerson) " +
                "values\n" +
                "  (?,?,?, " +
                "  ?,?,? ) ;";


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
    public Integer update(Supplier bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        String sql = "update supplier\n" +
                "set NAME           = ? ,\n" +
                "    Address        =?,\n" +
                "    Phone          =?,\n" +
                "    Fax            =?,\n" +
                "    PostalCode     =?,\n" +
                "    ConstactPerson =?\n" +
                "where Supplier_ID  =?;";


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
            pstmt.setObject(7, bean.getSupplierId());


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


        String sql = "delete\n" +
                "from product\n" +
                "where Product_ID = ?;";

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

    public List<Supplier> list() {
        // TODO Auto-generated method stub
        List<Supplier> list = new ArrayList<Supplier>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from supplier";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            Supplier tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new Supplier();


                tmpBean.setSupplierId(rs.getInt("Supplier_ID"));
                tmpBean.setName(rs.getString("name"));
                tmpBean.setAddress(rs.getString("Address"));
                tmpBean.setPhone(rs.getString("Phone"));
                tmpBean.setFax(rs.getString("PostalCode"));
                tmpBean.setPostalCode(rs.getString("PostalCode"));
                tmpBean.setConstactPerson(rs.getString("ConstacePerson"));


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
