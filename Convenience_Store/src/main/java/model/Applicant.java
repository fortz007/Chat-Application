package model;

import enums.Grade;

public class Applicant extends Person {
    private String position;
    private Grade grade;

    Applicant (){

    }
    public Applicant(String position, Grade grade) {
        this.position = position;
        this.grade = grade;
    }

    public Applicant(Integer id, String name, Character sex, String contact, String position, Grade grade) {
        super(id, name, sex, contact);
        this.position = position;
        this.grade = grade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "position='" + position + '\'' +
                ", grade=" + grade +
                "} " + super.toString();
    }
}
