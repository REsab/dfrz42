package dao.dao_Impl;

import bean.StoreHouse;
import dao.dao_interface.StoreHouseDao;
import tools.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreHouseDaoImpl implements StoreHouseDao {
    @Override
    public Integer insert(StoreHouse bean) {
        StringBuilder sbSQL = new StringBuilder();
        // 修改inset sql语句


        String sql = "insert into storehouse" +
                " (Address, Phone, UserId, CREATEDate) " +
                "values " +
                "(?,?,?,?);";
//                "('福州', '32314532', 33, '2019-8-8');\n";


        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer num = null;
        Connection conn = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            //     设置pstmt  里的占位符
            pstmt.setObject(1, bean.getAddress());
            pstmt.setObject(2, bean.getPhone());
            pstmt.setObject(3, bean.getUserId());
            pstmt.setObject(4, bean.getCreateDate());

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
    public Integer update(StoreHouse bean) {
        // TODO Auto-generated method stub
        StringBuilder sbSQL = new StringBuilder();

        String sql = "update storehouse set " +
                " Address               =?" +
                ", Phone                 =?" +
                ",UserId                 =? " +
                ",CREATEDate             =? " +
                "where StoreHouse_ID    = ?;";


        ResultSet rs = null;
        Integer num = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DbPub.getConn();
            pstmt = conn.prepareStatement(sql);

            pstmt.setObject(1, bean.getAddress());
            pstmt.setObject(2, bean.getPhone());
            pstmt.setObject(3, bean.getUserId());
            pstmt.setObject(4, bean.getCreateDate());
            pstmt.setObject(5, bean.getStoreHouseId());


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


        String sql = "delete from storehouse where StoreHouse_ID = ?;";

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
    public List<StoreHouse> list() {
        // TODO Auto-generated method stub
        List<StoreHouse> list = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        String sql = "select * from storehouse;";
        try {
            conn = DbPub.getConn();
            rs = DbPub.query(conn, sql);
            StoreHouse tmpBean = null;
            System.out.println();
            while (rs.next()) {

                tmpBean = new StoreHouse();


                tmpBean.setStoreHouseId(rs.getInt("StoreHouse_Id"));
                tmpBean.setAddress(rs.getString("Address"));
                tmpBean.setPhone(rs.getString("Phone"));
                tmpBean.setUserId(rs.getInt("UserId"));
                tmpBean.setCreateDate(rs.getTimestamp("CreateDate"));

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
