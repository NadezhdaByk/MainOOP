package org.example.Model;

public class User {
    private String firstname;
    private String secondname;
    private String patronymic;
    private String datebirth;
    private Integer phone;
    private String gender;

    public User(String firstname, String secondname, String patronymic, String datebirth, Integer phone, String gender) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.datebirth = datebirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDatabirth() {
        return datebirth;
    }

    public void setDatabirth(String databirth) {
        this.datebirth = databirth;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Double number) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
