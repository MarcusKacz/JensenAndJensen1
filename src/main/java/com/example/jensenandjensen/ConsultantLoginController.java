package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultantLoginController {
    @FXML
    private PasswordField con_password_txt;
    @FXML
    private TextField con_username_txt;
    @FXML
    private Label lbl_con;

    JensenAdminController j=new JensenAdminController();
    Stage stage=new Stage();
    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection DB=new DBconnection();

    //method for consultant login
    public void consultantLogin() throws IOException, SQLException {
        if (con_username_txt.getText().isBlank()==false && con_password_txt.getText().isBlank()==false){
            lbl_con.setText("you try to login");
            verifyingUserLogin();
            j.moveToPage("pomodoro.fxml");

        }else {
            lbl_con.setText("please enter username and password");
        }}

    public void verifyingUserLogin() throws SQLException {
        conn=DB.getConnection();
        query="SELECT * from consultant where username= ? AND  password = ?;";

        try{
            ps=conn.prepareStatement(query);
            ps.setString(1, con_username_txt.getText());
            ps.setString(2,con_password_txt.getText());
            // EXECUTE THE  QRY
            rs=ps.executeQuery();
            while(rs.next()){
                if (rs.getString(2).equals(con_username_txt.getText()) && rs.getString(3).equals(con_password_txt.getText())){
                    lbl_con.setText("You are login now !");
                }else {
                    lbl_con.setText("invalid Login");

                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
    }
    //method to cancel login
    public void consultantCancel(){
        System.exit(0);

    }
}
