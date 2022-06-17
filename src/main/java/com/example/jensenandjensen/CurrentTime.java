package com.example.jensenandjensen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    //extra class if we want to use the current local time with pomodoro
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public CurrentTime(){
    }

    public String currentTime(){
        return dtf.format(now);
    }
}