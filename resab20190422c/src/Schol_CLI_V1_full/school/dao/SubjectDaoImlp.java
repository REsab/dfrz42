package Schol_CLI_V1_full.school.dao;

import Schol_CLI_V1_full.school.bean.Subject;
import Schol_CLI_V1_full.school.util.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImlp implements SubjectDao {
    @Override
    public Integer insert(Subject bean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   Insert into Subject Values (?)");
        String sql = stringBuilder.toString();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer num = 0;
        try {
            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, bean.getSubjectName());
            num = preparedStatement.executeUpdate();

            if (num > 0) {
                sql = null;
                sql += "select @@IDENTITY";
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
        stringBuilder.append(" delete from Subject where Subjectid = ? ");
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
    public Integer update(Subject bean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Update Subject Set SubjectName = ' ? ', ClassHour= ?  " +
                ",GradeId= ?  where SubjectId =  ? ");
        String sql = stringBuilder.toString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer num = 0;

        connection = DbPub.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, bean.getSubjectName());
            preparedStatement.setObject(2, bean.getClassHour());
            preparedStatement.setObject(3, bean.getGradeId());
            preparedStatement.setObject(4, bean.getSubjetId());
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, preparedStatement);
        }
        return num;
    }

    @Override
    public List<Subject> Subject_LIST() {

        List<Subject> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select * from Subject ");
        String sql = stringBuilder.toString();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Integer num = 0;


        try {

            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Subject tempBean = null;
            while (resultSet.next()) {
                tempBean = new Subject();
                tempBean.setSubjetId(resultSet.getInt("subjectId"));
                tempBean.setSubjectName(resultSet.getString("subjectName"));
                tempBean.setClassHour(resultSet.getInt("classHour"));
                tempBean.setGradeId(resultSet.getInt("gradeId"));
                list.add(tempBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
