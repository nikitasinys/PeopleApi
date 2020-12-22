package dao;

import model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CountryDao {
    //Country parseResult(ResultSet resultSet) throws SQLException;
    List<Country> getAllCountry();
    int getRecordsCount();
    Country getCountryById(int id);
    void updateCountry(Country country);
    void putCountry(Country country);
    void deleteCountry(Country country);
}
