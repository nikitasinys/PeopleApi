package dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    List<Student> getPageStudents(int pageNumber, int studentsPerPage);
    int getRecordsCount();
    Student getStudentById(int id);
}
