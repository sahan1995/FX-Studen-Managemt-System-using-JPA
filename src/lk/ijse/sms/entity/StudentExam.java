/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
@Entity
public class StudentExam implements Serializable {

    @EmbeddedId
    private StudentExam_PK studentExam_PK;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sid",referencedColumnName = "sid",insertable = false,updatable = false)
    private Student student;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "examid",referencedColumnName = "exam_id",insertable = false,updatable = false)
    private Exam exam;

    private BigDecimal marks;


    /**
     * @return the studentExam_PK
     */
    public StudentExam_PK getStudentExam_PK() {
        return studentExam_PK;
    }

    /**
     * @param studentExam_PK the studentExam_PK to set
     */
    public void setStudentExam_PK(StudentExam_PK studentExam_PK) {
        this.studentExam_PK = studentExam_PK;
    }

    /**
     * @return the marks
     */
    public BigDecimal getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }


    public StudentExam() {
    }

    public StudentExam(StudentExam_PK studentExam_PK, BigDecimal marks) {
        this.studentExam_PK = studentExam_PK;
        this.marks = marks;
    }
    public StudentExam(BigDecimal marks,int exam_id,String sid) {
        this.studentExam_PK = new StudentExam_PK(sid, exam_id);
        this.marks = marks;
    }

    public StudentExam(Student student, Exam exam, BigDecimal marks) {

        this.studentExam_PK = new StudentExam_PK(student.getSid(),exam.getExam_id());
        this.marks = marks;

    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "StudentExam{" +
                "student=" + studentExam_PK.getSidm() +
                ", exam=" + studentExam_PK.getExamid() +
                ", marks=" + marks +
                '}';
    }
}
