package com.dhammatorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//declare that this is the main spring boot application
//this annotation make sure spring initiliaze the spring beans

@SpringBootApplication
public class Main {
    //psvm is the short cut for |v "public static void main ..
    public static void main(String[] args) {

        //this tells springboot to run this application here and resolve the dependencies
        SpringApplication.run(Main.class, args);
    }
}
