package dao.dao_Impl;

import bean.Product;
import dao.dao_interface.ProductDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImlp implements ProductDao {


    @Override
    public Integer insert(Product bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句


        String sql = "\n" +
                "insert into product " +
                "(NAME, Unit_ID, Price,\n" +
                " UserId, CreateDate, Remark)" +
                " value\n" +
                "  (?,?,?," +
                "?,?,?); ";
//                " ('name', 11, 123, 234, '2019-6-6', '352532');";


        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getUnitId());
            pstmt.setObject(3, bean.getPrice());
            pstmt.setObject(4, bean.getUserId());
            pstmt.setObject(5, bean.getCreateDate());
            pstmt.setObject(6, bean.getRemark());

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
    public Integer update(Product bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        String sql =
                "update product\n" +
                        "set NAME      =?,\n" +
                        "    Unit_ID   =?,\n" +
                        "    Price     =?,\n" +
                        "    UserId    =?,\n" +
                        "    CreateDate=?,\n" +
                        "    Remark    =?\n" +
                        "where Product_ID = ?;";


        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getUnitId());
            pstmt.setObject(3, bean.getPrice());
            pstmt.setObject(4, bean.getUserId());
            pstmt.setObject(5, bean.getCreateDate());
            pstmt.setObject(6, bean.getRemark());
            pstmt.setObject(7, bean.getProductId());


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


        sbSQL.append(" delete from product " +
                "          where Product_ID = ?; ");

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
    public List<Product> list() {
        // TODO Auto-generated method stub
        List<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select *\n" +
                "from product;";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            Product tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new Product();


                tmpBean.setProductId(rs.getInt("Product_id"));
                tmpBean.setName(rs.getString("Name"));
                tmpBean.setPrice(rs.getDouble("price"));
                tmpBean.setUserId(rs.getInt("Userid"));
                tmpBean.setCreateDate(rs.getTimestamp("CreateDate"));
                tmpBean.setRemark(rs.getString("remark"));


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
