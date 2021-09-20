package com.example.hibernate_01.Model.Interfaces;


public interface Name {
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getShortName();
    String getFullName();
    void setFullName(String fullName);
}