package com.example.hibernate_01.Model.Interfaces;

import java.io.Serializable;

public class NameImpl implements Serializable {

    public NameImpl(String name){
        this.fullName = name;
        String[] names = this.splitName(name);
        String shortName = this.setShortName(names[0],names[1],names[2]);
        this.setFirstName(names[0]);
        this.setMiddleName(names[1]);
        this.setLastName(names[2]);
        this.setShortName(shortName);
    }

    public NameImpl() {
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getShortName() {
        return shortName;
    }
    public String getFullName() {
        return fullName;
    }
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
    private String[] splitName(String name) {
        String[] names = name.split(" ");
        if(names.length >= 2) {
            return names;
        }
        return null;
    }
    private String setShortName(String firstName, String a, String b) {
        String middleNameFirstChar = a.charAt(0) + ".";
        String lastNameFirstChar = b.charAt(0) + ".";
        String shortName = firstName +  " " + middleNameFirstChar + lastNameFirstChar;
        return shortName;
    }

    private String firstName;
    private String lastName;
    private String middleName;
    private String shortName;
    private String fullName;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (null == firstName?null:firstName.hashCode());
        hash = 31 * hash + (null == lastName?null:lastName.hashCode());
        hash = 31 * hash + (null == middleName?null:middleName.hashCode());
        hash = 31 * hash + (null == shortName?null:shortName.hashCode());
        hash = 31 * hash + (null == fullName?null:fullName.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof NameImpl)) {
            return false;
        }
        NameImpl  name = (NameImpl) obj;
        return ( this.getShortName() == name.getShortName() ||
                (this.getShortName() != null
                && this.getShortName().equals(name.getShortName())))
                &&( this.getFullName() == name.getFullName() ||
                (this.getFullName() != null
                        && this.getFullName().equals(name.getFullName())));
    }

    @Override
    public String toString() {
        return "NameImpl{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
