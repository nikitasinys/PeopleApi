package model;

public class Lecturer {
    private int id;
    private String name;
    private String fatherName;
    private String surname;

    public Lecturer(int id, String name, String fatherName, String surname) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.surname = surname;
    }

    public Lecturer() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return name + " " + fatherName + " "  + surname;
    }
}
