package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class doTodayList   {

    @FXML
    public ListView<String> list_area;

    @FXML
    private TextField list_txt;

    JensenAdminController j= new JensenAdminController();
    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();

    //method to add new task to todolist task
    public void addToDoList(){
         String task= list_txt.getText();
        list_area.getItems().add(" - "+task);
        insertNewTask();

    }
    //method to insert previous task to database
    public  void insertNewTask(){
        try{

            conn=DB.getConnection();
            query="INSERT INTO tasks (taskName,taskStatus) VALUES (?,?);";
            ps = conn.prepareStatement(query);
             ps.setString(1,list_txt.getText() );
            ps.setString(2,"not done");


            System.out.println("Records inserted into the table...");

            ps.executeUpdate();
            ps.close();
            conn.close();

        }catch (SQLException e){
            e.getMessage();
        }

    }
    //method to clear text field or selected field in to do list
    public void clearToDoList(){
       int selected=list_area.getSelectionModel().getSelectedIndex();
        list_area.getItems().remove(selected);
        list_txt.setText("");
    }
    //method to return the selected field
    public String taskToDo(){
        String selected= String.valueOf(list_area.getSelectionModel().getSelectedIndex());
        return selected;
    }
    //method to move to page
    public void backToMainPage() throws IOException {
        String selected= String.valueOf(list_area.getSelectionModel().getSelectedIndex());
        j.moveToPage("pomodoro.fxml");
       }
}
