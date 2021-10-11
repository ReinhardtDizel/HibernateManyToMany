package com.example.hibernate_01.Model.Interfaces;

import java.io.Serializable;
import java.util.Objects;

public class NameImpl implements Name,Serializable {

   public NameImpl(String fullName, String firstName, String middleName, String lastName, String shortName) {
        this.fullName = fullName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.shortName = shortName;
    }

    public NameImpl() {
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getMiddleName() {
        return middleName;
    }
    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    @Override
    public String getShortName() {
        return shortName;
    }
    @Override
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    @Override
    public String getFullName() {
        return fullName;
    }
    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String firstName;
    private String lastName;
    private String middleName;
    private String shortName;
    private String fullName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameImpl)) return false;
        NameImpl name = (NameImpl) o;
        return Objects.equals(getFirstName(), name.getFirstName()) && Objects.equals(getLastName(), name.getLastName()) && Objects.equals(getMiddleName(), name.getMiddleName()) && Objects.equals(getShortName(), name.getShortName()) && Objects.equals(getFullName(), name.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getShortName(), getFullName());
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
