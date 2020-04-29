package edu.school.bean;

import java.sql.*;
import java.util.*;

import edu.school.dao.impl.DbPub;

public class Grade implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -106817925865088875L;

	public Grade() {

	}

	private String gradeName;
	private Integer gradeId;

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

}
