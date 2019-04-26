package com.dhammatorn.Entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


//object in the database
@Data
@Entity @Table(name = "student")
public class Student {
    @Id @GeneratedValue @Column(name="id")
    private int id;

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

    @Column(name="username")
    @NotEmpty(message = "*Please provide your username")
    private String username;

    @Column(name="password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "active")
    private int active;

    @Column(name="ucard")
    private String ucard;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name="booking")
    private int booking;

    @Column(name="strikes")
    private int strikes;



    public int getId(){
        return this.id;
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

    public void setBooking(int booking){
        this.booking = booking;
    }

    public int getBooking(){
        return this.booking;
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

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setActive(int active){
        this.active = active;
    }

    public int getActive(){
        return this.active;
    }

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    public Set<Role> getRoles(){
        return this.roles;
    }

    public void setUcard(String ucard){
        this.ucard = ucard;
    }

    public String getUcard(){
        return this.ucard;
    }

    public void setStrikes(int strikes){
        this.strikes = strikes;
    }

    public int getStrikes(){
        return this.strikes;
    }

    public void setId(int id) {
        this.id = id;
    }
}
