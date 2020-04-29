package edu.school.server;

import java.util.*;
import edu.school.bean.*;

public interface StudentServer {
	Integer insert(Student bean);

	Integer update(Student bean);

	Integer delete(String id);

	List<Student> list();
	
	Student load(String StudentNo);

	Integer count();

	Student loadByName(String studentName);

	Integer countByName(String studentName);
}