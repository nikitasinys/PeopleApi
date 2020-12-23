package dao;

import db.ConnectionFactory;
import model.Town;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TownDaoImpl implements TownDao {
    public static Town parseResult(ResultSet resultSet) throws SQLException {
        Town town = new Town();

        try {
            town.setId(resultSet.getInt("Id_town"));
            town.setIdRegion(resultSet.getInt("Id_region"));
            town.setName(resultSet.getString("Name_town"));
            town.setRegion(RegionDaoImpl.parseResult(resultSet));
    //        town.setPeople(PersonDaoImpl.parseResult(resultSet));
        }catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
            return town;
        }

    @Override
    public List<Town> getAllTown() {
        List<Town> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery("select * from Town as t " +
                    "inner join Region as r on t.Id_region = r.Id_region");
            while (resultSet.next()) {
                list.add(parseResult(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int getRecordsCount() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery("select count(*) as count from Town");
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
    public Town getTownById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(
                    "select * from Town as t " +
                            "inner join Region as r on t.Id_region = r.Id_region where Id_town=?");
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                return parseResult(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTown(Town town) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("update Town set " +
                    "Id_town = ?, Id_region = ?, Name_town = ? where Id_town = ?");
            pst.setInt(1, town.getId());
            pst.setInt(2, town.getIdRegion());
            pst.setString(3, town.getName());
            pst.setInt(4, town.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void putTown(Town town) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("insert into Town(Id_town, Id_region, Name_town) values (?,?,?)");
            pst.setInt(1, town.getId());
            pst.setInt(2, town.getIdRegion());
            pst.setString(3, town.getName());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteTown(Town town) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("delete from Town where Id_town = ?");
            pst.setInt(1, town.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
