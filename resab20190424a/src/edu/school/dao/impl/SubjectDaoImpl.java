package edu.school.dao.impl;

import java.sql.*;
import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;

public class SubjectDaoImpl implements SubjectDao {

	@Override
	public Integer insert(Subject bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into Subject(SubjectName,ClassHour,GradeId) values( ?,?,? )");
		String sql = sbSQL.toString();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = null;
		Connection conn = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getSubjectName());
			pstmt.setObject(2, bean.getClassHour());
			pstmt.setObject(3, bean.getGradeId());
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
	public Integer update(Subject bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" update Subject set SubjectName = ? , ClassHour = ? , GradeId = ?");
		sbSQL.append(" where SubjectId = ?");
		String sql = sbSQL.toString();

		ResultSet rs = null;
		Integer num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getSubjectName());
			pstmt.setObject(2, bean.getClassHour());
			pstmt.setObject(3, bean.getGradeId());
			pstmt.setObject(4, bean.getSubjectId());
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
		sbSQL.append(" delete Subject where SubjectId = ? ");
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
	public List<Subject> list() {
		// TODO Auto-generated method stub
		List<Subject> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select * from Subject";
		try {
			conn = DbPub.getConn();
			rs = DbPub.query(conn, sql);
			Subject bean = null;
			System.out.println();
			while (rs.next()) {
				bean = toBean(rs);
				list.add(bean);
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

	public Subject toBean(ResultSet rs) throws SQLException {
		Subject bean;
		bean = new Subject();
		bean.setSubjectId(rs.getInt("SubjectId"));
		bean.setSubjectName(rs.getString("SubjectName"));
		bean.setClassHour(rs.getInt("ClassHour"));
		bean.setGradeId(rs.getInt("GradeId"));
		return bean;
	}

	@Override
	public Subject load(Integer SubjectId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Subject ");
		sb.append(" where SubjectId = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Subject bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, SubjectId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = toBean(rs);
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
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Subject ");
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
				num = rs.getInt("SubjectId");
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
	public Subject loadByName(String SubjectName) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Subject ");
		sb.append(" where SubjectName = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Subject bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, SubjectName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = toBean(rs);
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
	public Integer countByName(String SubjectName) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Subject ");
		sb.append(" where SubjectName = ? ");
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

}
