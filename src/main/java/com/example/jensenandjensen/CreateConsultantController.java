package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateConsultantController {
    @FXML
    private Label lbl_message;

    @FXML
    private TextField txt_lastname;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_status;

    @FXML
    private TextField txt_username;

    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();
    JensenAdminController j=new JensenAdminController();

    //method to insert one consultant to database
    public void insertConsultantToDataBase(){
         try{

            conn=DB.getConnection();
            query="INSERT INTO consultant (userName,password,FirstName,LastName,Status) VALUES (?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(3,txt_name.getText());
            ps.setString(4,txt_lastname.getText());
            ps.setString(1,txt_username.getText());
            ps.setString(2,txt_password.getText());
            ps.setString(5,txt_status.getText());
            System.out.println("Inserted records into the table...");
            lbl_message.setText("Inserted records into the table.");
            ps.executeUpdate();
            ps.close();
            conn.close();
            j.moveToPage("JensenAdmin.fxml");

        }catch (SQLException | IOException e){
            e.getMessage();
        }

    }
}
