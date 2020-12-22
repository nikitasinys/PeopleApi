package model;

import java.util.List;

public class Country {
    public Country() {
    }

    public Country(int id, String name, List<Region> regions, List<Person> people) {
        this.id = id;
        this.name = name;
        this.regions = regions;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    private int id;
    private String name;
    List<Region> regions;
    private List<Person> people;

}
