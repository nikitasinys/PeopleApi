package model;

public class Subject {
    private int id;
    private String title;
    private String lecturer;
    private int lecturerId;
    private int credits;

    public Subject() {
    }

    public Subject(int id, String title, int lecturerId, int credits) {
        this.id = id;
        this.title = title;
        this.lecturerId = lecturerId;
        this.credits = credits;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
