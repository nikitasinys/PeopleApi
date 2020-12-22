package dao;

import db.ConnectionFactory;
import model.Lecturer;
import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturerDaoImpl implements LecturersDao {
    @Override
    public List<Lecturer> listLecturers() {
        List<Lecturer> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery("select * from lecturers");
            while (resultSet.next()) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId(resultSet.getInt("id"));
                lecturer.setName(resultSet.getString("name"));
                lecturer.setSurname(resultSet.getString("surname"));
                lecturer.setFatherName(resultSet.getString("fathername"));
                list.add(lecturer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Map<Integer, String> listNames() {
        List<Lecturer> list = listLecturers();
        Map<Integer, String> map = new HashMap<>();
        for (Lecturer l: list) {
            map.put(l.getId(), l.toString());
        }
        return map;
    }

    @Override
    public Lecturer getLecturerById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement("select * from lecturers where id=?");
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId(resultSet.getInt("id"));
                lecturer.setName(resultSet.getString("name"));
                lecturer.setSurname(resultSet.getString("surname"));
                lecturer.setFatherName(resultSet.getString("fathername"));
                return lecturer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
