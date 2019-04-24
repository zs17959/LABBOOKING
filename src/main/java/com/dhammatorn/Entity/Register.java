package com.dhammatorn.Entity;

public class Register {

    private String name;
    private String lastname;
    private String course;
    private String email;
    private String username;
    private String password;
    private String matchingPassword;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getCourse(){
        return this.course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getMatchingPassword(){
        return this.matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword){
        this.matchingPassword = matchingPassword;
    }


}
