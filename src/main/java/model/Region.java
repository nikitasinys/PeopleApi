package model;

import java.util.List;

public class Region {
    private int id;
    private int idCountry;
    private String name;
    private Country country;
    private List<Town> towns;
    private List<Person> people;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Region(int id, int idCountry, String name, Country country, List<Town> towns, List<Person> people) {
        this.id = id;
        this.idCountry = idCountry;
        this.name = name;
        this.country = country;
        this.towns = towns;
        this.people = people;
    }

    public Region() {
    }

}
