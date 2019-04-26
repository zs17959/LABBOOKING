package com.dhammatorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//declare that this is the main spring boot application
//this annotation make sure spring initiliaze the spring beans

@SpringBootApplication
public class Main {
    //psvm is the short cut for |v "public static void main ..
    public static void main(String[] args) {

        //this tells springboot to run this application here and resolve the dependencies
        SpringApplication.run(Main.class, args);
//        Timer timer = new Timer();
//        timer.schedule(new AutoAttendance(), 0, 6, TimeUnit.HOURS);
//        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
//        ses.scheduleAtFixedRate(new AutoAttendance() , 0, 1, TimeUnit.HOURS);


    }
}

