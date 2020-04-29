package edu.school.dao;

import edu.school.bean.Grade;
import edu.school.util.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImlp implements GradeDao {
    @Override
    public Integer insert(Grade bean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   Insert into Grade Values (?)");
        String sql = stringBuilder.toString();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer num = 0;
        try {
            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, bean.getGradeName());
            num = preparedStatement.executeUpdate();

            if (num > 0) {
                sql = null;
                sql = "select @@IDENTITY";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    num = resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, preparedStatement, resultSet);
        }
        return num;
    }

    @Override
    public Integer delete(Integer id) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" delete from Grade where gradeid = ? ");
        String sql = stringBuilder.toString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Integer num = 0;

        connection = DbPub.getConnection();
        try {
            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, preparedStatement);
        }
        return num;
    }

    @Override
    public Integer update(Grade bean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Update Grade Set GradeName = ? where GradeId =? ");
        String sql = stringBuilder.toString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer num = 0;

        connection = DbPub.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, bean.getGradeName());
            preparedStatement.setObject(2, bean.getGradeId());
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, preparedStatement);
        }
        return num;
    }

    @Override
    public List<Grade> GRADE_LIST() {

        List<Grade> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select * from Grade ");
        String sql = stringBuilder.toString();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Integer num = 0;


        try {

            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Grade tempBean = null;
            while (resultSet.next()) {
                tempBean = new Grade();
              tempBean.setGradeId(resultSet.getInt("gradeId"));
                tempBean.setGradeName(resultSet.getString("gradeName"));
                list.add(tempBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

}
