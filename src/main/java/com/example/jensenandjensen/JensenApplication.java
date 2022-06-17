package com.example.jensenandjensen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JensenApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JensenApplication.class.getResource("JensenAdmin.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(JensenApplication.class.getResource("consultantLoginController.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(JensenApplication.class.getResource("AdminLogin.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(JensenApplication.class.getResource("CreateConsultant.fxml"));
        FXMLLoader fxmlLoader4 = new FXMLLoader(JensenApplication.class.getResource("pomodoro.fxml"));
        FXMLLoader fxmlLoader5 = new FXMLLoader(JensenApplication.class.getResource("doTodayList.fxml"));
        FXMLLoader fxmlLoader6 = new FXMLLoader(JensenApplication.class.getResource("reportPage.fxml"));
        FXMLLoader fxmlLoader7 = new FXMLLoader(JensenApplication.class.getResource("largScreen.fxml"));






        Scene scene = new Scene(fxmlLoader1.load(), 900, 600);
        stage.setTitle("Jensen & Jensen for Consultant!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}