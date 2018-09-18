/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.*;

/**
 * @author Sahan Rajakaruna
 */
@Entity
public class StudentBatch {

    /**
     * @return the studentBatch_PK
     */
    @EmbeddedId
    private StudentBatch_PK studentBatch_PK;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sid", referencedColumnName = "sid",updatable = false,insertable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "batch_no", referencedColumnName = "batch_no",updatable = false,insertable = false)
    private Batch batch;

    public StudentBatch() {
    }

 public StudentBatch(StudentBatch_PK studentBatch_PK) {
        this.studentBatch_PK = studentBatch_PK;
    }


    public StudentBatch(String sid, String batch_no,Student student) {

        this.studentBatch_PK = new StudentBatch_PK(sid, batch_no);
        this.student = student;
    }
    public StudentBatch(String sid, String batch_no) {

        this.studentBatch_PK = new StudentBatch_PK(sid, batch_no);

    }
    public StudentBatch_PK getStudentBatch_PK() {
        return studentBatch_PK;
    }

    public void setStudentBatch_PK(StudentBatch_PK studentBatch_PK) {
        this.studentBatch_PK = studentBatch_PK;
    }

    @Override
    public String toString() {
        return "StudentBatch{" + "studentBatch_PK=" + getStudentBatch_PK() + '}';
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }



}
