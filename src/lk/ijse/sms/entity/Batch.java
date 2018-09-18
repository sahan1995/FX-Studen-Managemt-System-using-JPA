/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sahan Rajakaruna
 */
@Entity
public class Batch {

    @Id
    private String batch_no;
    private BigDecimal fee;

    @OneToMany(mappedBy = "batch", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<StudentBatch> studentBatchList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID",referencedColumnName = "course_id")
    private Course course;

    public Batch() {
    }

    public Batch(String batch_no, BigDecimal fee, Course course) {
        this.batch_no = batch_no;
        this.fee = fee;
        this.course = course;
    }

    public Batch(String batch_no, BigDecimal fee, String course_id) {
        this.batch_no = batch_no;
        this.fee = fee;

    }

    public Batch(String batch_no, BigDecimal fee) {
        this.batch_no = batch_no;
        this.fee = fee;
    }

    /**
     * @return the batch_no
     */
    public String getBatch_no() {
        return batch_no;
    }

    /**
     * @param batch_no the batch_no to set
     */
    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    /**
     * @return the fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }


    @Override
    public String toString() {
        return "Batch{" + "batch_no=" + batch_no + ", fee=" + fee +'}';
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<StudentBatch> getStudentBatchList() {
        return studentBatchList;
    }

    public void setStudentBatchList(List<StudentBatch> studentBatchList) {
        this.studentBatchList = studentBatchList;
    }
}
