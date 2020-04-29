package edu.school.dao;

import java.util.*;
import edu.school.bean.*;

public interface ResultDao {
	Integer insert(Result bean);

	Integer update(Result bean);

	Integer delete(Integer id);

	List<Result> list();

	Result load(Integer id);

	Integer count();

	Result loadByName(String name);

	Integer countByName(String name);
}
