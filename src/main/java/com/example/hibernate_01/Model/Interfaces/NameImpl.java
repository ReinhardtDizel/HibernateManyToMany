package com.example.hibernate_01.Model.Interfaces;

public class NameImpl implements Name{

    public NameImpl(String fullName){
        this.fullName = fullName;
        this.firstName = setFirstName();
        this.middleName = setMiddleName();
        this.lastName = setLastName();
        this.shortName = setShortName();
    }

    public NameImpl() {

    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private String setFirstName() {
        String[] names = this.fullName.split(" ");
        if(names.length >= 2) {
            return names[0];
        }
        return null;
    }
    private String setMiddleName() {
        String[] names = this.fullName.split(" ");
        if(names.length >= 2) {
            return names[1];
        }
        return null;
    }
    private String setLastName() {
        String[] names = this.fullName.split(" ");
        if(names.length == 2) {
            return names[2];
        }
        return null;
    }

    private String setShortName() {
        String middleNameFirstChar = this.middleName.charAt(0) + ".";
        String lastNameFirstChar = this.lastName.charAt(0) + ".";
        String shortName = this.firstName +  " " + middleNameFirstChar + lastNameFirstChar;
        return shortName;
    }


    private String firstName;
    private String lastName;
    private String middleName;
    private String shortName;
    private String fullName;

    public String toString() {
        return this.toString();
    }
}
