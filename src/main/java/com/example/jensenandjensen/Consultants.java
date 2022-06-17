package com.example.jensenandjensen;

import javafx.scene.control.Button;

public class Consultants {
    //declare consultants details
    int id;
    String firstName,LastName,UserName,Password,Status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }




    public Consultants(int id, String firstName, String lastName, String userName, String password, String status) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        UserName = userName;
        Password = password;
        Status = status;
    }

    public Consultants( ) {

    }
    public Consultants( String firstName,String status) {
        this.firstName = firstName;
        Status = status;
    }
}
