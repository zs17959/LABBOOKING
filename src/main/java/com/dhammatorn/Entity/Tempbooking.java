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

//Temporary Entity for booking as a user 
public class Tempbooking{

    private int id;

    @NotNull
    private String seatNo;

    private int startTime;

    private int endTime;

    private String error;

    @NotNull
    private String day;

    private int student;

    private Integer rsop;

    private Integer active8;

    private Integer bnc_croclead;

    private Integer bnc_lead;

    private Integer power_supp;

    private Integer rs_4mmplug;

    private Integer prototyping_board;

    private Integer solidCoreWire;

    private Integer wire_strippers;

    private Integer resistors;

    private Integer capacitors;

    private Integer lcr400_bridge;

    private Integer bnc_Tpiece;

   private Integer oscilloscope_trim;

   private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setSeatNo(String seatNo){
        this.seatNo = seatNo;
    }

    public String getSeatNo(){
        return this.seatNo;
    }
//
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

    public void setDay(String day){
        this.day = day;
    }

    public String getDay(){
        return this.day;
    }

    public void setStudent(int student){
        this.student = student;
    }

    public int getStudent(){
        return this.student;
    }

    public Integer getRsop() {
        return rsop;
    }

    public void setRsop(Integer rsop) {
        this.rsop = rsop;
    }

    public Integer getActive8() {
        return active8;
    }

    public void setActive8(Integer active8) {
        this.active8 = active8;
    }

    public Integer getBnc_croclead() {
        return bnc_croclead;
    }

    public void setBnc_croclead(Integer bnc_croclead) {
        this.bnc_croclead = bnc_croclead;
    }

    public Integer getBnc_lead() {
        return bnc_lead;
    }

    public void setBnc_lead(Integer bnc_lead) {
        this.bnc_lead = bnc_lead;
    }

    public Integer getPower_supp() {
        return power_supp;
    }

    public void setPower_supp(Integer power_supp) {
        this.power_supp = power_supp;
    }

    public Integer getRs_4mmplug() {
        return rs_4mmplug;
    }

    public void setRs_4mmplug(Integer rs_4mmplug) {
        this.rs_4mmplug = rs_4mmplug;
    }

    public Integer getPrototyping_board() {
        return prototyping_board;
    }

    public void setPrototyping_board(Integer prototyping_board) {
        this.prototyping_board = prototyping_board;
    }

    public Integer getSolidCoreWire() {
        return solidCoreWire;
    }

    public void setSolidCoreWire(Integer solidCoreWire) {
        this.solidCoreWire = solidCoreWire;
    }

    public Integer getWire_strippers() {
        return wire_strippers;
    }

    public void setWire_strippers(Integer wire_strippers) {
        this.wire_strippers = wire_strippers;
    }

    public Integer getResistors() {
        return resistors;
    }

    public void setResistors(Integer resistors) {
        this.resistors = resistors;
    }

    public Integer getCapacitors() {
        return capacitors;
    }

    public void setCapacitors(Integer capacitors) {
        this.capacitors = capacitors;
    }

    public Integer getLcr400_bridge() {
        return lcr400_bridge;
    }

    public void setLcr400_bridge(Integer lcr400_bridge) {
        this.lcr400_bridge = lcr400_bridge;
    }

    public Integer getBnc_Tpiece() {
        return bnc_Tpiece;
    }

    public void setBnc_Tpiece(Integer bnc_Tpiece) {
        this.bnc_Tpiece = bnc_Tpiece;
    }

    public Integer getOscilloscope_trim() {
        return oscilloscope_trim;
    }

    public void setOscilloscope_trim(Integer oscilloscope_trim) {
        this.oscilloscope_trim = oscilloscope_trim;
    }
}
