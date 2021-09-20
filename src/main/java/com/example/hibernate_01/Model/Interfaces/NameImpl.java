package com.example.hibernate_01.Model.Interfaces;

public class NameImpl implements Name {

    public NameImpl(String fullName){
        this.fullName = fullName;
        this.firstName = setFirstName(fullName);
        this.middleName = setMiddleName(fullName);
        this.lastName = setLastName(fullName);
        this.shortName = setShortName(fullName);
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

    private String setFirstName(String fullName) {
        String[] names = fullName.split(" ");
        if(names.length >= 2) {
            return names[0];
        }
        return null;
    }
    private String setMiddleName(String fullName) {
        String[] names = fullName.split(" ");
        if(names.length >= 2) {
            return names[1];
        }
        return null;
    }
    private String setLastName(String fullName) {
        String[] names = fullName.split(" ");
        if(names.length == 2) {
            return names[2];
        }
        return null;
    }

    private String setShortName(String fullName) {
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
}
