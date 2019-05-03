package com.dhammatorn.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

//entity for AdminBooking 
public class Adminbooking {

    private int id;

    private List<String> seatNum;

    @NotNull
    private String[] seatNo;

    private int startTime;

    private int endTime;

    @NotNull
    private String day;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setSeatNo(String[] seatNo){
        this.seatNo = seatNo;
    }

    public String[] getSeatNo(){
        return this.seatNo;
    }

//    public void setStartTime(String startTime){
//        this.startTime = startTime;
//    }
//
//    public String getStartTime(){
//        return this.startTime;
//    }
//
//    public void setEndTime(String endTime){
//        this.endTime = endTime;
//    }
//
//    public String getEndTime(){
//        return this.endTime;
//    }

    public void setDay(String day){
        this.day = day;
    }

    public String getDay(){
        return this.day;
    }

    public List<String> getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(List<String> seatNum) {
        this.seatNum = seatNum;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
