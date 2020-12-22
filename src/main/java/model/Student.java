package model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String surname;
    private List<Subject> subjectList;

    public Student(int id, String name, String surname, List<Subject> subjectList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.subjectList = subjectList;
    }

    public Student() {
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

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
