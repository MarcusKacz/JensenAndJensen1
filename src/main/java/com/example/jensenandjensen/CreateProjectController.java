package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateProjectController {

    @FXML
    private TextField txt_project;
    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();

    //method to insert one project to database
    public  void insertNewProject(){
        try{

            conn=DB.getConnection();
            query="INSERT INTO project (projectName) VALUES (?);";
            ps = conn.prepareStatement(query);
             ps.setString(1, txt_project.getText());
            System.out.println("Inserted records into the table...");

            ps.executeUpdate();
            ps.close();
            conn.close();



        }catch (SQLException e){
            e.getMessage();
        }

    }
}
