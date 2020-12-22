package dao;

import model.Region;

import java.util.List;

public interface RegionDao {
    List<Region> getAllRegion();
    int getRecordsCount();
    Region getRegionById(int id);
    void updateRegion(Region region);
    void putRegion(Region region);
    void deleteRegion(Region region);
}
