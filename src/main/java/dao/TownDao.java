package dao;

import model.Town;

import java.util.List;

public interface TownDao {
    List<Town> getAllTown();
    int getRecordsCount();
    Town getTownById(int id);
    void updateTown(Town town);
    void putTown(Town town);
    void deleteTown(Town town);
}
