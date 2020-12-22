package model;

import java.util.List;

public class Town {
    private int id;
    private int idRegion;
    private String name;
    private Region region;
    private List<Person> people;

    public Town(int id, int idRegion, String name, Region region, List<Person> people) {
        this.id = id;
        this.idRegion = idRegion;
        this.name = name;
        this.region = region;
        this.people = people;
    }


    public Town() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }


}
