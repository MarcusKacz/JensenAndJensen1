package com.example.jensenandjensen;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PomodoroController extends doTodayList {





    @FXML
    private ImageView tomato_img;
    @FXML
    private TextField settime_txt;
    @FXML
    private ImageView ray_img;
    @FXML
    private Label message_lbl;

    @FXML
    private Label pomodoro_counter_lbl;

    @FXML
    private Label counter_lbl;
    @FXML
    protected Label task_txt;


     Time time = new Time("0:0:0");
    int counter=1;
    JensenAdminController j=new JensenAdminController();
    RotateTransition rotate=new RotateTransition();
    doTodayList d=new doTodayList();
    String query;
    public Connection conn=null;
    public PreparedStatement ps;
    public ResultSet rs;
    DBconnection db= new DBconnection();



    //method to get the task details
    public void getTask()  {
         conn= DB.getConnection();

        try {
            query = "SELECT TOP 1 taskName FROM tasks where taskStatus='not done';";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                task_txt.setText("Task : "+rs.getString("taskName"));

                ps.close();
                conn.close();

            } } catch (SQLException e){
            e.getMessage();
        }
    }
    //method to change the status of task
     public void MarkTaskAsDone()  {
        String task=task_txt.getText();
         System.out.println(task);
         try{

             conn=DB.getConnection();
             query="UPDATE  tasks SET taskStatus = 'done' where taskName=(SELECT TOP 1 taskName FROM tasks where taskStatus='not done');";
             ps = conn.prepareStatement(query);

             System.out.println("  Tha Task is done now");

             ps.executeUpdate();


         }catch (SQLException e){
             e.getMessage();
         }
    }


    //method to enter do-today page
    public void moveToDoTodayPage() throws IOException {
        j.moveToPage("doTodayList.fxml");

    }
    //method to enter setPomodoroPage
    public void setPomodoroPage() throws IOException {
        j.moveToPage("pomodoro.fxml");
        task_txt.setText(d.taskToDo());
    }
     public void logOutBtn(){

        System.exit(0);
     }



    //method to get the red apple an action
    public void rotateTomato(){
        rotate.setNode(ray_img);
        rotate.setDuration(Duration.millis(5000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(250);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();


    }
    public void startPomodoro(){
        pomodoro_counter_lbl.setText(time.getCurrentTime());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
         rotateTomato();
        getTask();
        message_lbl.setText("");
        //counter++;

    }
    public void stop(){
        rotate.stop();
        timeline.setCycleCount(1);

        //timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.stop();

    }

    public void Pause(){
        rotate.stop();
        timeline.stop();
    }
    public void getBreak(){

        rotate.stop();
        timeline.stop();
        counter_lbl.setText("Counter : \t"+counter);
        counter++;
        }


         Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        e -> {
                            if(time.getCurrentTime().equals(settime_txt.getText()))
                             {
                                 message_lbl.setText("Break time now");
                                getBreak();
                            }
                            time.oneSecondPassed();
                            pomodoro_counter_lbl.setText(time.getCurrentTime());
                           // pomodoro_counter_lbl.getText();
                        }

                        ));
     int value;


}
