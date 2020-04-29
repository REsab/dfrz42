package Schol_CLI_V1_full.school.dao;

import Schol_CLI_V1_full.school.bean.Result;
import Schol_CLI_V1_full.school.util.DbPub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDaoImpl implements ResultDao {
    @Override
    public Integer insert(Result bean) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   \n" +
                "Insert into Result (StudentNo,SubjectId,StudentResult,ExamDate) Values " +
                "(' ?  ', ? , ? ,' ? ')");
        String sql = stringBuilder.toString();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer num = 0;
        try {
            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, bean.getStudentNo());
            preparedStatement.setObject(2, bean.getSubjectId());
            preparedStatement.setObject(3, bean.getStudentResult());
            preparedStatement.setObject(4, bean.getExamdate());


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
        stringBuilder.append(" delete from Result where id =  ? ");
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
    public Integer update(Result bean) {
        StringBuilder stringBuilder = new StringBuilder();
//        Update Result Set StudentNo=user,SubjectId=1,StudentResult=44  where Id =4
//       StudentNo   这个是学生的名字,不在这里做修改 
        stringBuilder.append(" Update Result Set SubjectId= ? ,StudentResult= ? " +
                " where Id = ? ");
        String sql = stringBuilder.toString();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer num = 0;

        connection = DbPub.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, bean.getSubjectId());
            preparedStatement.setObject(1, bean.getStudentResult());
            preparedStatement.setObject(1, bean.getExamdate());
            preparedStatement.setObject(1, bean.getId());
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbPub.close(connection, preparedStatement);
        }
        return num;
    }


    @Override
    public List<Result> GRADE_LIST() {
        List<Result> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select * from Result ");
        String sql = stringBuilder.toString();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Integer num = 0;
        try {
            connection = DbPub.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Result tempBean = null;
            while (resultSet.next()) {
                tempBean = new Result();
                tempBean.setStudentNo(resultSet.getString("studentNO"));
                tempBean.setSubjectId(resultSet.getInt("SubjectId"));
                tempBean.setStudentResult(resultSet.getInt("studentResult"));
                tempBean.setExamdate(resultSet.getString("examdate"));
                list.add(tempBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
