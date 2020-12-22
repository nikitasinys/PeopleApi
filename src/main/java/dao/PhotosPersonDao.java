package dao;

import model.PhotosPerson;

import java.util.List;

public interface PhotosPersonDao {
    List<PhotosPerson> getAllPhotosPerson();
    int getRecordsCount();
    PhotosPerson getPhotosPersonById(int id);
    void updatePhotosPerson(PhotosPerson photosPerson);
    void putPhotosPerson(PhotosPerson photosPerson);
    void deletePhotosPerson(PhotosPerson photosPerson);
}
