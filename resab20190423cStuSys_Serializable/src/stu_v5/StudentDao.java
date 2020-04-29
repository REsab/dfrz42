package stu_v5;
/*
 访问层类StudentDao【相当于三层结构中的数据访问层】
只完成对DataCenter类中的学生类数组的增删改查，注意，不能有输入输出；
先实例化DataCenter类的一个对象，作为StudentDao的属性。
判断exists() : 传入一个id，到数组中查找，有则返回1，否则返回0。
查list() : 返回Student[]类型对象
获取是新下标getNewIndex() : 返回最新的可添加的数组下标。
增insert() : 传入一个Student对象，添加到数组中，成功返回1，否则返回
0。
查找id对应下标searchId()： 传入id，获得其下标，不存是返回-1.
改update() : 传入一个Student对象，找到id对应的，将其它内容，写入数
组中对应的对象。
位移moveIndex()： 传入一个要删除的下标，删除后，将后面的元素前移，前移
后，最后元素置为null
删delete() : 传入一个id，到数组中查找，有则删除（调用moveIndex()）
并返回1，否则返回0
 */

 class studentDao {



    /**
     * ///寻找第一个空下标
     * <p>
     * 获取是新下标getNewIndex() : 返回最新的可添加的数组下标。
     */

    public Integer getNewIndex() {
        Integer index = 0;
        for (int i = 0; i < DataCenter.studentsArr.length; i++) {
            if (DataCenter.studentsArr[i] == null) {
                index = i;
                return index;

            }
        }
        return index;
    }

    /**
     * 插入学生
     * 插入学生
     * <p>
     * 增insert() : 传入一个Student对象，添加到数组中，
     * 成功返回1，否则返回 0。
     */
    public Integer insert(Student student) {   //插入学生
        Integer result = 0;

        int index = getNewIndex();
        if (index > 0 && index < DataCenter.studentsArr.length) {
            DataCenter.studentsArr[index] = new Student();
            DataCenter.studentsArr[index].setId(student.getId());
            DataCenter.studentsArr[index].setName(student.getName());
            DataCenter.studentsArr[index].setSex(student.getSex());
            result = 1;
        }
        return result;


    }

    /**
     * 是否存在这个号数
     * 判断exists() : 传入一个id，到数组中查找，有则返回1，否则返回0。
     */
    public Integer exists(Integer id) {
        int index = getNewIndex();
        for (int i = 0; i < index; i++) {
            if (DataCenter.studentsArr[i] != null) {
                if (DataCenter.studentsArr[i].getId().equals(id)) {
                    return 1;
                }
            }
        }

        return 0;
    }


    /**
     * 修改学生
     * 改update() : 传入一个Student对象，找到id对应的，
     * 将其它内容，写入数
     * 组中对应的对象。
     * 不存是返回-1.
     */
    public Integer update(Student student) {
        Integer result = 0;
        if (exists(student.getId()) == 1) {   //是否有这个人
            int index = searchIdIndex(student.getId()); //找到这个新修改的学号位置
            if (index >= 0 && index < DataCenter.studentsArr.length) {   //下标位置 是正确的
                DataCenter.studentsArr[index].setId(student.getId());
                DataCenter.studentsArr[index].setName(student.getName());
                DataCenter.studentsArr[index].setSex(student.getSex());
                result = 1;  //修改完成
            }
        }
        return result;
    }

    /**
     * 查list() : 返回Student[]类型对象
     */
    public Student[] list() {
        return DataCenter.studentsArr;
    }


    /**
     * 获取id对应的下标
     * 获取id对应的下标
     * 获取id对应的下标
     * 查找id对应下标searchId()： 传入id，获得其下标，不存是返回-1.
     */
    public Integer searchIdIndex(Integer id) {
        for (Integer i = 0; i < DataCenter.studentsArr.length; i++) {
            if (DataCenter.studentsArr[i] != null) {
                if (id.equals(DataCenter.studentsArr[i].getId())) {
                    return i;
                }
            }
        }
        return -1;
    }




    /**
     * 删除对应下标的学生
     * 删除对应下标的学生
     * 删除对应下标的学生
     * 删除对应下标的学生
     * <p>
     * 删delete() : 传入一个id，到数组中查找，有则删除（调用moveIndex()）
     * 并返回1，否则返回0
     */
    public Integer delete(int id) {
        Integer result = 0;

        if (1 == exists(id)) {   //判断学号是否存在
            moveIndex(id);
            result = 1;
        } else {
            result = -1;
        }

        return result;
    }
    /* w
  删除id
     */
    private void moveIndex(int id) {

        if (id >= 0 && id < DataCenter.studentsArr.length) {
            int last = -1;
            for (int i = 0; i < DataCenter.studentsArr.length; i++) {
                if (DataCenter.studentsArr[i + 1] == null) {
                    last = i;
                    break;
                }

                DataCenter.studentsArr[i] = DataCenter.studentsArr[i + 1];


            }
            if (last != -1) {

                DataCenter.studentsArr[last] = null;
            }

        }


    }

}
