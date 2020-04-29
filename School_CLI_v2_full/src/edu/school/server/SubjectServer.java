package edu.school.server;

import java.util.*;
import edu.school.bean.*;

public interface SubjectServer {
	Integer insert(Subject bean);

	Integer update(Subject bean);

	Integer delete(Integer id);

	List<Subject> list();

	Subject load(Integer SubjectId);

	Integer count();

	Subject loadByName(String SubjectName);

	Integer countByName(String SubjectName);
}