package dao;

import db.ConnectionFactory;
import model.PhotosPerson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotosPersonDaoImpl implements PhotosPersonDao {
    public static PhotosPerson parseResult(ResultSet resultSet) throws SQLException {
        PhotosPerson photosPerson = new PhotosPerson();

        photosPerson.setHashPhoto(resultSet.getInt("Hash_photo"));
        photosPerson.setIdPerson(resultSet.getInt("Id_person"));
        photosPerson.setPathToPhoto(resultSet.getString("Path_to_photo"));
        photosPerson.setDatePhoto(resultSet.getDate("Date_photo"));
        photosPerson.setPerson(PersonDaoImpl.parseResult(resultSet));

        return photosPerson;
    }

    @Override
    public int getRecordsCount() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery("select count(*) as count from PhotosPerson");
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
    public List<PhotosPerson> getAllPhotosPerson() {
        List<PhotosPerson> list = new ArrayList<>();
        ResultSet resultSet;

        try (Connection connection = ConnectionFactory.getConnection()) {
            resultSet = connection.createStatement().executeQuery(
                    "select * from PhotosPerson as ph " +
                            "inner join Person as p on ph.Id_person = p.Id_person");
            while (resultSet.next()) {
                list.add(parseResult(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public PhotosPerson getPhotosPersonById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(
                    "select * from PhotosPerson as ph " +
                            "inner join Person as p on ph.Id_person = p.Id_person where Hash_photo=?");
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
    public void putPhotosPerson(PhotosPerson photosPerson){
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement(
                    "insert into PhotosPerson(Hash_photo, Id_person, Path_to_photo, Date_photo) values (?,?,?,?)");
            pst.setInt(1, photosPerson.getHashPhoto());
            pst.setInt(2, photosPerson.getIdPerson());
            pst.setString(3, photosPerson.getPathToPhoto());
            pst.setDate(4, photosPerson.getDatePhoto());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updatePhotosPerson(PhotosPerson photosPerson) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("update PhotosPerson set " +
                    "Hash_photo = ?, Id_person = ?, Path_to_photo = ?, Date_photo = ? where Hash_photo = ?");
            pst.setInt(1, photosPerson.getHashPhoto());
            pst.setInt(2, photosPerson.getIdPerson());
            pst.setString(3, photosPerson.getPathToPhoto());
            pst.setDate(4, photosPerson.getDatePhoto());
            pst.setInt(5, photosPerson.getHashPhoto());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePhotosPerson(PhotosPerson photosPerson) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("delete from PhotosPerson where Hash_photo = ?");
            pst.setInt(1, photosPerson.getHashPhoto());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
