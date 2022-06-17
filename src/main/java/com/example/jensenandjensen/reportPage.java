package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class reportPage {
    @FXML
    private TextField task_txt;

    @FXML
    private TextArea textarea_report;

    String query;
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();
    JensenAdminController j=new JensenAdminController();
    Consultants c=new Consultants();

    public void sendByEmail(){

    }
    //method to edit report
    public void EditReport(){

    }
    public void BackToAdminPage() throws IOException {
        j.moveToPage("JensenAdmin.fxml");

    }

    public void createReport(){
        try{

            DB.getConnection();
            query="SELECT * FROM  consultant   ";
            ps = conn.prepareStatement(query);
            ps.execute();
            ps.close();
            conn.close();

        }catch (Exception e){
            e.getMessage();
        }


    }
    public void print(){
        textarea_report.setText("The consultant ID  " +c.getId()+ " done from this Task \n"
                                 +"the task is one of four task to this Project \n"
                                 +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "+"The consultant ID  " +c.getId()+ " done from this Task \n"
                +"the task is one of four task to this Project \n"
                +"this project is name of "

        );



    }
}
