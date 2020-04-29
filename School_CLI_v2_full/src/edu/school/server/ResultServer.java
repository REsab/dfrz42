package edu.school.server;

import java.util.*;
import edu.school.bean.*;

public interface ResultServer {
	Integer insert(Result bean);

	Integer update(Result bean);

	Integer delete(Integer id);

	List<Result> list();

	Result load(Integer id);

	Integer count();

	Result loadByName(String studentNo);

	Integer countByName(String studentNo);
}