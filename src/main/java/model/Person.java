package model;
//import java.util.Date;
import java.sql.Date;
import java.util.List;

public class Person {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private char gender;
    private Date dateBirth;
    private Date dateDeath;
    private int idCountryBirth;
    private int idRegionBirth;
    private int idTownBirth;
    private Country countryBirth;
    private Region regionBirth;
    private Town townBirth;
    private List<PhotosPerson> photos;

    public Person(int id, String surname, String name, String patronymic,
                  char gender, Date dateBirth, Date dateDeath,
                  int idCountryBirth, int idRegionBirth,
                  int idTownBirth, Country countryBirth,
                  Region regionBirth, Town townBirth,
                  List<PhotosPerson> photos) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.idCountryBirth = idCountryBirth;
        this.idRegionBirth = idRegionBirth;
        this.idTownBirth = idTownBirth;
        this.countryBirth = countryBirth;
        this.regionBirth = regionBirth;
        this.townBirth = townBirth;
        this.photos = photos;
    }

    public Person() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateDeath() {
        return dateDeath;
    }


    public int getIdCountryBirth() {
        return idCountryBirth;
    }

    public void setIdCountryBirth(int idCountryBirth) {
        this.idCountryBirth = idCountryBirth;
    }

    public int getIdRegionBirth() {
        return idRegionBirth;
    }

    public void setIdRegionBirth(int idRegionBirth) {
        this.idRegionBirth = idRegionBirth;
    }

    public int getIdTownBirth() {
        return idTownBirth;
    }

    public void setIdTownBirth(int idTownBirth) {
        this.idTownBirth = idTownBirth;
    }

    public void setDateDeath(Date dateDeath) {
        this.dateDeath = dateDeath;
    }

    public Country getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(Country countryBirth) {
        this.countryBirth = countryBirth;
    }

    public Region getRegionBirth() {
        return regionBirth;
    }

    public void setRegionBirth(Region regionBirth) {
        this.regionBirth = regionBirth;
    }

    public Town getTownBirth() {
        return townBirth;
    }

    public void setTownBirth(Town townBirth) {
        this.townBirth = townBirth;
    }

    public List<PhotosPerson> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosPerson> photos) {
        this.photos = photos;
    }

}
