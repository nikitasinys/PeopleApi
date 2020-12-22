package dao;

import model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
//    List<Student> getPageStudents(int pageNumber, int studentsPerPage);
    List<Person> getAllPerson();
    int getRecordsCount();
    Person getPersonById(int id);
    void updatePerson(Person person);
    void putPerson(Person person);
    void deletePerson(Person person);
        //static Person parseResult(ResultSet resultSet) throws SQLException;
}
