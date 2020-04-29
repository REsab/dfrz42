package edu.school.server;

import java.util.*;
import edu.school.bean.*;

public interface GradeServer {
	Integer insert(Grade bean);

	Integer update(Grade bean);

	Integer delete(Integer id);

	List<Grade> list();
	
	Grade load(Integer id);

	Integer count();

	Grade loadByName(String name);

	Integer countByName(String name);
}