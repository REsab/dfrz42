package edu.school.dao.impl;

import java.sql.*;
import java.util.*;
import edu.school.bean.*;
import edu.school.dao.*;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Integer insert(Student bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" insert into Student(StudentNo,loginPwd,studentName ");
		sbSQL.append(" ,sex,GradeId,phone,Addresss,bronDate,email ");
		sbSQL.append(" ) values( ?,?,?,?,?,?,?,?,?) ");
		String sql = sbSQL.toString();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer num = null;
		Connection conn = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, bean.getStudentNo());
			pstmt.setObject(2, bean.getLoginPwd());
			pstmt.setObject(3, bean.getStudentName());
			pstmt.setObject(4, bean.getSex());
			pstmt.setObject(5, bean.getGradeId());
			pstmt.setObject(6, bean.getPhone());
			pstmt.setObject(7, bean.getAddress());
			pstmt.setObject(8, bean.getBronDate());
			pstmt.setObject(9, bean.getEmail());
			num = pstmt.executeUpdate();

			if (num > 0) {
				sql = "";
				sql += " select @@Identity";
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
	public Integer update(Student bean) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" update Student set  loginPwd = ? , StudentName = ?");
		sbSQL.append(" ,sex = ?,GradeId = ?,phone= ?,Addresss= ?,bronDate= ?,email= ? ,StudentNo = ? ");
		sbSQL.append(" where StudentId = ?");
		String sql = sbSQL.toString();

		ResultSet rs = null;
		Integer num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);

			pstmt.setObject(1, bean.getLoginPwd());

			pstmt.setObject(2, bean.getStudentName());
			pstmt.setObject(3, bean.getSex());
			pstmt.setObject(4, bean.getGradeId());
			pstmt.setObject(5, bean.getPhone());
			pstmt.setObject(6, bean.getAddress());
			pstmt.setObject(7, bean.getBronDate());
			pstmt.setObject(8, bean.getEmail());
			pstmt.setObject(9, bean.getStudentNo());
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
	public Integer delete(String id) {
		// TODO Auto-generated method stub
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(" delete Student where StudentNo = ? ");

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
	public List<Student> list() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		ResultSet rs = null;
		Connection conn = null;
		String sql = "select * from StudentInfo";
		try {
			conn = DbPub.getConn();
			rs = DbPub.query(conn, sql);
			Student bean = null;
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

	@Override
	public Student load(String StudentNo) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from StudentInfo ");
		sb.append(" where StudentNo = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Student bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, StudentNo);

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
		sb.append(" select count(1) from StudentInfo ");
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
				num = rs.getInt("StudentNo");
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
	public Student loadByName(String studentName) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from StudentInfo ");
		sb.append(" where StudentName = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Student bean = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, studentName);

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

	public Student toBean(ResultSet rs) throws SQLException {
		Student bean;
		bean = new Student();
		bean.setStudentNo(rs.getString("StudentNo"));
		bean.setLoginPwd(rs.getString("LoginPwd"));
		bean.setStudentName(rs.getString("StudentName"));
		bean.setSex(rs.getString("Sex"));
		bean.setGradeId(rs.getInt("GradeId"));
		bean.setPhone(rs.getString("Phone"));
		bean.setAddress(rs.getString("Addresss"));
		bean.setBronDate(rs.getString("BronDate"));
		bean.setEmail(rs.getString("Email"));
		return bean;
	}

	@Override
	public Integer countByName(String studentName) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(1) from StudentInfo ");
		sb.append(" where StudentName = ? ");
		String sql = sb.toString();

		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer num = null;
		try {
			conn = DbPub.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, studentName);
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
