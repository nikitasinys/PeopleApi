package dao;

import db.ConnectionFactory;
import model.Lecturer;
import model.Student;
import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery("select * from students");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> getPageStudents(int pageNumber, int studentsPerPage) {
        List<Student> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement("select * from students limit ? offset ?");
            pst.setInt(1, studentsPerPage);
            pst.setInt(2, (pageNumber - 1) * studentsPerPage);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public int getRecordsCount() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery("select count(*) from students");
            int count = 0;
            if (resultSet.next())
                count = resultSet.getInt("count");
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}
