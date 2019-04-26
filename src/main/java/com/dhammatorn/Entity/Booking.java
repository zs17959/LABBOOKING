package com.dhammatorn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity @Table(name = "booking")
public class Booking {
    @Id @GeneratedValue @Column(name="id")
    private int id;

    @Column(name="seatNo")
    private String seatNo;

    @Column(name="endTime")
    private LocalDateTime endTime;

    @Column(name="startTime")
    private LocalDateTime startTime;

    @Column(name="length")
    private int length;

    @Column(name="student")
    private int student;

    @Column(name="rs_scilloscope_Probes")
    private int rsop;

    @Column(name="rs_Active8Channel")
    private int active8;

    @Column(name="bnc_croclead")
    private int bnc_croclead;

    @Column(name="bnc_lead")
    private int bnc_lead;

    @Column(name="rstriple_powersupply")
    private int power_supp;

    @Column(name="rs_4mmplug")
    private int rs_4mmplug;

    @Column(name="prototyping_board")
    private int prototyping_board;

    @Column(name="solidCoreWire")
    private int solidCoreWire;

    @Column(name="Wire_strippers")
    private int wire_strippers;

    @Column(name="resistors")
    private int resistors;

    @Column(name="capacitors")
    private int capacitors;

    @Column(name="lcr400_bridge")
    private int lcr400_bridge;

    @Column(name="bnc_Tpiece")
    private int bnc_Tpiece;

    @Column(name="oscilloscope_trim")
    private int oscilloscope_trim;

    @Column(name="attendance")
    private Boolean attendance;

    @Column(name="notes")
    private String notes;

    @Column(name="auto_checked")
    private Boolean auto_checked;

    public void setSeatNo(String seatNo){
        this.seatNo = seatNo;
    }

    public String getSeatNo(){
        return this.seatNo;
    }


    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }

    public void setStudent(int student){
        this.student = student;
    }

    public int getStudent(){
        return this.student;
    }

    public int getId() {
        return id;
    }

    public int getRsop() {
        return rsop;
    }

    public void setRsop(int rsop) {
        this.rsop = rsop;
    }

    public int getActive8() {
        return active8;
    }

    public void setActive8(int active8) {
        this.active8 = active8;
    }

    public int getBnc_croclead() {
        return bnc_croclead;
    }

    public void setBnc_croclead(int bnc_croclead) {
        this.bnc_croclead = bnc_croclead;
    }

    public int getBnc_lead() {
        return bnc_lead;
    }

    public void setBnc_lead(int bnc_lead) {
        this.bnc_lead = bnc_lead;
    }

    public int getPower_supp() {
        return power_supp;
    }

    public void setPower_supp(int power_supp) {
        this.power_supp = power_supp;
    }

    public int getRs_4mmplug() {
        return rs_4mmplug;
    }

    public void setRs_4mmplug(int rs_4mmplug) {
        this.rs_4mmplug = rs_4mmplug;
    }

    public int getPrototyping_board() {
        return prototyping_board;
    }

    public void setPrototyping_board(int prototyping_board) {
        this.prototyping_board = prototyping_board;
    }

    public int getSolidCoreWire() {
        return solidCoreWire;
    }

    public void setSolidCoreWire(int solidCoreWire) {
        this.solidCoreWire = solidCoreWire;
    }

    public int getWire_strippers() {
        return wire_strippers;
    }

    public void setWire_strippers(int wire_strippers) {
        this.wire_strippers = wire_strippers;
    }

    public int getResistors() {
        return resistors;
    }

    public void setResistors(int resistors) {
        this.resistors = resistors;
    }

    public int getCapacitors() {
        return capacitors;
    }

    public void setCapacitors(int capacitors) {
        this.capacitors = capacitors;
    }

    public int getLcr400_bridge() {
        return lcr400_bridge;
    }

    public void setLcr400_bridge(int lcr400_bridge) {
        this.lcr400_bridge = lcr400_bridge;
    }

    public int getBnc_Tpiece() {
        return bnc_Tpiece;
    }

    public void setBnc_Tpiece(int bnc_Tpiece) {
        this.bnc_Tpiece = bnc_Tpiece;
    }

    public int getOscilloscope_trim() {
        return oscilloscope_trim;
    }

    public void setOscilloscope_trim(int oscilloscope_trim) {
        this.oscilloscope_trim = oscilloscope_trim;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }


    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getAuto_checked() {
        return auto_checked;
    }

    public void setAuto_checked(Boolean auto_checked) {
        this.auto_checked = auto_checked;
    }
}
