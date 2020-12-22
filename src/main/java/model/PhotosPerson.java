package model;


import java.sql.Date;
//import java.util.Date;

public class PhotosPerson {
    private int hashPhoto;
    private int idPerson;
    private String pathToPhoto;
    private Date datePhoto;
    private Person person;

    public PhotosPerson() {
    }

    public PhotosPerson(int hashPhoto, int idPerson, String pathToPhoto, Date datePhoto, Person person) {
        this.hashPhoto = hashPhoto;
        this.idPerson = idPerson;
        this.pathToPhoto = pathToPhoto;
        this.datePhoto = datePhoto;
        this.person = person;
    }

    public int getHashPhoto() {
        return hashPhoto;
    }

    public void setHashPhoto(int hashPhoto) {
        this.hashPhoto = hashPhoto;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    public Date getDatePhoto() {
        return datePhoto;
    }

    public void setDatePhoto(Date datePhoto) {
        this.datePhoto = datePhoto;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
