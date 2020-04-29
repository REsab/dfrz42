package stu_v5;/*
 服务层类StudentService【相当于三层结构中的数据服务层】
定义一个StudentDao类型的属性，名称为studentDao；

只是完成对StudentDao对象各个方法调用。
Service层定义在Dao层的所有非private方法，并调用Dao层对应的方法。

 */

class studentService {

    studentDao studentDao = new studentDao();


    public Integer insert(Student student) {   //插入学生
        return studentDao.insert(student);

    }


    public Integer update(Student student) {
        return studentDao.update(student);
    }


    public Student[] list() {
        return studentDao.list();
    }


    public Integer delete(int id) {
        return studentDao.delete(id);
    }


    public Integer searchIdIndex(Integer id) {

        return studentDao.searchIdIndex(id);
    }

    public Integer getNewIndex() {
    return studentDao.getNewIndex();
    }
    public Integer exists(Integer id) {


        return studentDao.exists(id);
    }
}
