package dao;

import model.Lecturer;

import java.util.List;
import java.util.Map;

public interface LecturersDao {
    List<Lecturer> listLecturers();
    Map<Integer, String> listNames();
    Lecturer getLecturerById(int id);
}
