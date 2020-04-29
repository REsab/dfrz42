package dao.dao_Impl;

import bean.ProductUnit;
import dao.dao_interface.ProductUnitDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductUnitDaoImpl implements ProductUnitDao {
    @Override
    public Integer insert(ProductUnit bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句


        String sql = "insert into productunit" +
                " (NAME, CreateDate, USerId, Remark)" +
                " value (?,?,?,?);";
//                " value ('fsdf', '2018-3-3', 11, 'eeeee');";


        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getCreateDate());
            pstmt.setObject(3, bean.getUnitId());
            pstmt.setObject(4, bean.getRemark());


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
    public Integer update(ProductUnit bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        String sql = "update productunit set " +
                " NAME= ?" +
                ", CreateDate=?" +
                ", USerId=?" +
                ", Remark=?" +
                " where Unit_ID=?; ";


        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getName());
            pstmt.setObject(2, bean.getCreateDate());
            pstmt.setObject(3, bean.getUSerId());
            pstmt.setObject(4, bean.getRemark());
            pstmt.setObject(5, bean.getUnitId());

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


        String sql = "delete  from  productunit where Unit_ID=?;";

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
    public List<ProductUnit> list() {

        // TODO Auto-generated method stub
        List<ProductUnit> list = new ArrayList<ProductUnit>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from productunit";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            ProductUnit tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new ProductUnit();
                tmpBean.setUnitId(rs.getInt("Unit_ID"));
                tmpBean.setName(rs.getString("name"));
                tmpBean.setUSerId(rs.getInt("USerId"));
                tmpBean.setCreateDate(rs.getTimestamp("createDate"));
                tmpBean.setRemark(rs.getString("Remark"));
                System.out.println(tmpBean.getName() + "    " + tmpBean.getUnitId() + "    " + tmpBean.getUSerId());
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
