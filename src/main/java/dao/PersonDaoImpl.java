package dao;

import db.ConnectionFactory;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    //@Override
    public static Person parseResult(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        try {
            person.setId(resultSet.getInt("Id_person"));
            person.setSurname(resultSet.getString("Surname"));
            person.setName(resultSet.getString("Name"));
            person.setPatronymic(resultSet.getString("Patronymic"));
            person.setIdCountryBirth(resultSet.getInt("Id_country_birth"));
            person.setIdRegionBirth(resultSet.getInt("Id_region_birth"));
            person.setIdTownBirth(resultSet.getInt("Id_town_birth"));
            person.setGender(resultSet.getString("Gender").charAt(0));
            person.setDateBirth(resultSet.getDate("Date_birth"));
            person.setDateDeath(resultSet.getDate("Date_death"));
            person.setCountryBirth(CountryDaoImpl.parseResult(resultSet));
            person.setRegionBirth(RegionDaoImpl.parseResult(resultSet));
            person.setTownBirth(TownDaoImpl.parseResult(resultSet));
        }catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
        return person;
    }

    @Override
    public int getRecordsCount() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery("select count(*) as count from Person");
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
    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery(
                    "select * from Person as p " +
                            "inner join Country as c on p.Id_country_birth = c.Id_country " +
                            "inner join Region as r on p.Id_region_birth = r.Id_region  " +
                            "inner join Town as t on p.Id_town_birth = t.Id_town");
            while (resultSet.next()) {
                list.add(parseResult(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
        //return null;
    }

    @Override
    public Person getPersonById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(
                    "select * from Person as p " +
                            "inner join Country as c on p.Id_country_birth = c.Id_country " +
                            "inner join Region as r on p.Id_region_birth = r.Id_region  " +
                            "inner join Town as t on p.Id_town_birth = t.Id_town where Id_person=?");
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return parseResult(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
        //return null;
    }

    @Override
    public void putPerson(Person person){
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement(
                    "insert into Person(Id_person, Surname, Name, Patronymic, " +
                    "Id_country_birth, Id_region_birth, Id_town_birth, " +
                    "Gender, Date_birth, Date_death) values (?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, person.getId());
            pst.setString(2, person.getSurname());
            pst.setString(3, person.getName());
            pst.setString(4, person.getPatronymic());
            pst.setInt(5, person.getIdCountryBirth());
            pst.setInt(6, person.getIdRegionBirth());
            pst.setInt(7, person.getIdTownBirth());
            pst.setString(8, Character.toString(person.getGender()));
            pst.setDate(9, person.getDateBirth());
            pst.setDate(10, person.getDateDeath());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updatePerson(Person person) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("update Person set " +
                    "Id_person = ?, Surname = ?, Name = ?, Patronymic = ?, " +
                    "Id_country_birth = ?, Id_region_birth = ?, Id_town_birth = ?, " +
                    "Gender = ?, Date_birth = ?, Date_death = ? where Id_person = ?");
            pst.setInt(1, person.getId());
            pst.setString(2, person.getSurname());
            pst.setString(3, person.getName());
            pst.setString(4, person.getPatronymic());
            pst.setInt(5, person.getIdCountryBirth());
            pst.setInt(6, person.getIdRegionBirth());
            pst.setInt(7, person.getIdTownBirth());
            pst.setString(8, Character.toString(person.getGender()));
            pst.setDate(9, person.getDateBirth());
            pst.setDate(10, person.getDateDeath());
            pst.setInt(11, person.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePerson(Person person) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("delete from Person where Id_person = ?");
            pst.setInt(1, person.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
