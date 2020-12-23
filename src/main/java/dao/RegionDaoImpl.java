package dao;

import db.ConnectionFactory;
import model.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDaoImpl implements RegionDao {
    public static Region parseResult(ResultSet resultSet) throws SQLException {

        Region region = new Region();
        try {
        region.setId(resultSet.getInt("Id_region"));
        region.setIdCountry(resultSet.getInt("Id_country"));
        region.setName(resultSet.getString("Name_region"));
        region.setCountry(CountryDaoImpl.parseResult(resultSet));
        //        region.setPeople(PersonDaoImpl.parseResult(resultSet));
        }catch (Exception throwables)
        {
            throwables.printStackTrace();
        }
        return region;
    }

    @Override
    public List<Region> getAllRegion() {
        List<Region> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery("select * from Region as r " +
                    "inner join Country as c on r.Id_country = c.Id_country");
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
            ResultSet resultSet = connection.createStatement().executeQuery("select count(*) as count from Region");
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
    public Region getRegionById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(
                    "select * from Region as r" +
                            "inner join Country as c on r.Id_country = c.Id_country where Id_region=?");
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
    public void updateRegion(Region region) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("update Region set " +
                    "Id_region = ?, Id_country = ?, Name_region = ? where Id_region = ?");
            pst.setInt(1, region.getId());
            pst.setInt(2, region.getIdCountry());
            pst.setString(3, region.getName());
            pst.setInt(4, region.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void putRegion(Region region) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("insert into Region(Id_region, Id_country, Name_region) values (?,?,?)");
            pst.setInt(1, region.getId());
            pst.setInt(2, region.getIdCountry());
            pst.setString(3, region.getName());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteRegion(Region region) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("delete from Region where Id_region = ?");
            pst.setInt(1, region.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
