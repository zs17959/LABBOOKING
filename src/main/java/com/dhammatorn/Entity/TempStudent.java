package com.dhammatorn.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class TempStudent {

    private String id;

    @Column(name="name")
    @NotEmpty(message = "*Please provide your first name")
    private String name;

    @Column(name="lastname")
    @NotEmpty(message = "*Please provide your last name")
    private String lastname;

    @Column(name="course")
    @NotEmpty(message = "*Please provide your course")
    private String course;

    @Column(name="email")
    @NotEmpty(message = "*Please provide your email")
    private String email;

    @Column(name="ucard")
    private String ucard;





//    public int getId(){
//        return this.id;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return this.course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }



    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return this.lastname;
    }



    public void setUcard(String ucard){
        this.ucard = ucard;
    }

    public String getUcard(){
        return this.ucard;
    }


}
