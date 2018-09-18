/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sahan Rajakaruna
 */
@Entity
public class Student {
    
    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */




    public void setAddress(String address) {
        this.address = address;
    }


    @Id
    private String sid;
    private String fname;
    private String lname;
    private String nic;
    private String contact;
    private String address;

    @OneToMany(mappedBy = "student",cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<StudentBatch> studentBatchList = new ArrayList<>();

    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST)
    private List<StudentExam> studentExamList = new ArrayList<>();


    public Student() {
    }

    public Student(String sid, String fname, String lname, String nic, String contact, String address) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.contact = contact;
        this.address = address;
    }

    public Student(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", nic=" + nic + ", contact=" + contact + ", address=" + address + '}';
    }

    public List<StudentBatch> getStudentBatchList() {
        return studentBatchList;
    }

    public void setStudentBatchList(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }

    public void addStudetBatch(StudentBatch studentBatch){
        studentBatch.setStudent(this);
        getStudentBatchList().add(studentBatch);
    }

    public List<StudentExam> getStudentExamList() {
        return studentExamList;
    }

    public void setStudentExamList(List<StudentExam> studentExamList) {
        this.studentExamList = studentExamList;
    }
    public void addStudentExamList(StudentExam studentExam){
        studentExam.setStudent(this);
        getStudentExamList().add(studentExam);
    }
}
