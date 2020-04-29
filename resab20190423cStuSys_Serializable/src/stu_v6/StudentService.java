package stu_v6;

import java.sql.ResultSet;
import java.util.List;

public class StudentService {
	StudentDao studentDao=new StudentDao();
	public Integer exists(Integer id){
		return studentDao.exists(id);
	}
	public List<Student> list() {
		return studentDao.list();
	}
	public Integer insert(Student student) {
		return studentDao.insert(student);
	}
	public Integer update(Student student) {
		return studentDao.update(student);
	}
	public Integer delete(Integer id) {
		return studentDao.delete(id);
	}
}
