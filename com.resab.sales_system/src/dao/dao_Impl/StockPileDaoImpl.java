package dao.dao_Impl;

import bean.StockPile;
import dao.dao_interface.StockPileDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockPileDaoImpl implements StockPileDao {


    @Override
    public Integer insert(StockPile bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句


        String sql = "insert into stockpile " +
                "( StoreHOuse_ID, Product_ID, " +
                "FirstEnterDate, LastLeaveDate, " +
                "Quantity, Price) " +
                "value" +
                " ( ?,?,?   ,?,?,? );";
//                " ( 1, 991, 339, '2016-6-9', '2017-9-9', '33', 44 );\n";


        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getStoreHOuseId());
            pstmt.setObject(2, bean.getProductId());
            pstmt.setObject(3, bean.getFirstEnterDate());
            pstmt.setObject(4, bean.getLastLeaveDate());
            pstmt.setObject(5, bean.getQuantity());
            pstmt.setObject(6, bean.getPrice());


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
    public Integer update(StockPile bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        String sql = "update stockpile set" +
                "StockPile_ID       =?, " +
                "StoreHOuse_ID      =?, " +
                "Product_ID         = ?, " +
                "FirstEnterDate     =?, " +
                "LastLeaveDate      =?, " +
                "Quantity           =?, " +
                "Price              =?  " +
                "where StockPile_ID = ?; ";


        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getStockPileId());
            pstmt.setObject(2, bean.getStoreHOuseId());
            pstmt.setObject(3, bean.getProductId());
            pstmt.setObject(4, bean.getFirstEnterDate());
            pstmt.setObject(5, bean.getLastLeaveDate());
            pstmt.setObject(6, bean.getQuantity());
            pstmt.setObject(7, bean.getPrice());
            pstmt.setObject(8, bean.getStockPileId());


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


        String sql = "delete from stockpile where StockPile_ID = ? ;";

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
    public List<StockPile> list() {
        // TODO Auto-generated method stub
        List<StockPile> list = new ArrayList<StockPile>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from supplier";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            StockPile tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new StockPile();

                tmpBean.setStockPileId(rs.getInt("StockPile_id"));
                tmpBean.setStoreHOuseId(rs.getInt("StoreHOuse_Id"));
                tmpBean.setProductId(rs.getInt("Product_Id"));
                tmpBean.setFirstEnterDate(rs.getTimestamp("FirstEnterDate"));
                tmpBean.setLastLeaveDate(rs.getTimestamp("LastLeaveDate"));
                tmpBean.setQuantity(rs.getShort("Quantity"));
                tmpBean.setPrice(rs.getDouble("Price"));


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
