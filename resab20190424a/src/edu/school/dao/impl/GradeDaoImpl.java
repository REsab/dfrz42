package edu.school.dao.impl;

import java.sql.*;
import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;

public class GradeDaoImpl implements GradeDao {

	public Grade load(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Grade ");
		sb.append(" where GradeId = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Grade bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new Grade();
				bean.setGradeId(rs.getInt("GradeId"));
				bean.setGradeName(rs.getString("GradeName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DbPub.close(conn, pstmt, rs);
		}
		return bean;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Grade ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer num = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt("GradeId");
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
	public Grade loadByName(String name) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Grade ");
		sb.append(" where GradeName = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Grade bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new Grade();
				bean.setGradeId(rs.getInt("GradeId"));
				bean.setGradeName(rs.getString("GradeName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DbPub.close(conn, pstmt, rs);
		}
		return bean;
	}

	@Override
	public Integer countByName(String name) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Grade ");
		sb.append(" where GradeName = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer num = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
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
	public Integer insert(Grade bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into Grade(GradeName) values( ? )");
		String sql = sbSQL.toString();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = null;
		Connection conn = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getGradeName());
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
	public Integer update(Grade bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" update Grade set GradeName = ?");
		sbSQL.append(" where GradeId = ?");
		String sql = sbSQL.toString();

		ResultSet rs = null;
		Integer num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getGradeName());
			pstmt.setObject(2, bean.getGradeId());
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
		sbSQL.append(" delete Grade where GradeId = ? ");
		String sql = sbSQL.toString();

		PreparedStatement pstmt = null;
		Connection conn = null;
		Integer num = 0;
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
	public List<Grade> list() {
		// TODO Auto-generated method stub
		List<Grade> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select * from Grade";
		try {
			conn = DbPub.getConn();
			rs = DbPub.query(conn, sql);
			Grade tmpBean = null;
			System.out.println();
			while (rs.next()) {
				tmpBean = new Grade();
				tmpBean.setGradeId(rs.getInt("GradeId"));
				tmpBean.setGradeName(rs.getString("GradeName"));
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
