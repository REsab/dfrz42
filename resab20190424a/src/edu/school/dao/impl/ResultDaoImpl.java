package edu.school.dao.impl;

import java.sql.*;
import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;

public class ResultDaoImpl implements ResultDao {

	@Override
	public Integer insert(Result bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into Result(StudentNo,SubjectId,ExamDate,StudentResult) values( ?,?,?,? )");
		String sql = sbSQL.toString();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = null;
		Connection conn = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);

			pstmt.setObject(1, bean.getStudentNo());
			pstmt.setObject(2, bean.getSubjectId());
			pstmt.setObject(3, bean.getExamDate());
			pstmt.setObject(4, bean.getStudentResult());

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
	public Integer update(Result bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" update Result set StudentNo = ?,SubjectId = ?,ExamDate = ?,StudentResult = ?");
		sbSQL.append(" where Id = ?");
		String sql = sbSQL.toString();

		ResultSet rs = null;
		Integer num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getStudentNo());
			pstmt.setObject(2, bean.getSubjectId());
			pstmt.setObject(3, bean.getExamDate());
			pstmt.setObject(4, bean.getStudentResult());
			pstmt.setObject(5, bean.getId());
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
		sbSQL.append(" delete Result where Id = ? ");
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
	public List<Result> list() {
		// TODO Auto-generated method stub
		List<Result> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select * from Result";
		try {
			conn = DbPub.getConn();
			rs = DbPub.query(conn, sql);
			Result tmpBean = null;
			System.out.println();
			while (rs.next()) {
				tmpBean = toBean(rs);
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

	public Result toBean(ResultSet rs) throws SQLException {
		Result tmpBean;
		tmpBean = new Result();
		tmpBean.setId(rs.getInt("Id"));
		tmpBean.setStudentNo(rs.getString("StudentNo"));
		tmpBean.setSubjectId(rs.getInt("SubjectId"));
		tmpBean.setStudentResult(rs.getInt("StudentResult"));
		tmpBean.setExamDate(rs.getString("ExamDate"));
		return tmpBean;
	}

	@Override
	public Result load(Integer id) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Result ");
		sb.append(" where Id = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Result bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);

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
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Result ");
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
				num = rs.getInt("Id");
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
	public Result loadByName(String studentNo) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from Result ");
		sb.append(" where StudentNo = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Result bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, studentNo);
			
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
	public Integer countByName(String studentNo) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from Result ");
		sb.append(" where StudentNo = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer num = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, studentNo);
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
