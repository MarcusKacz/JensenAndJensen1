package com.example.jensenandjensen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminLoginController {
    @FXML
    private PasswordField password_txt_ad;

    @FXML
    private TextField username_txt_ad;
    @FXML
    private Label alert_lbl_ad;
    JensenAdminController j=new JensenAdminController();
    //method to admin page login
    public void adminLogin() throws IOException {
        if(username_txt_ad.getText().equalsIgnoreCase("admin") && password_txt_ad.getText().equalsIgnoreCase("admin")){
           j.moveToPage("JensenAdmin.fxml");

        }else {
            alert_lbl_ad.setText("The username or password is incorrect");
        }
    }
    //method to admin page login
    public void AdminCancel(){
        System.exit(0);

    }
}
