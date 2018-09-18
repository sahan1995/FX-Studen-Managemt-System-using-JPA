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
 * @author Sahan Rajakaruna
 */
@Entity
public class Exam {

    @Id
    @GeneratedValue
    private int exam_id;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "moduleID")
    private Module moduleid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course courseid;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.PERSIST)
    private List<StudentExam> studentExams = new ArrayList<>();


    public Exam(Module moduleid, Course courseid) {
        this.moduleid = moduleid;
        this.courseid = courseid;
    }

    public Exam() {
    }

    public Exam(int exam_id) {
        this.exam_id = exam_id;

    }
    /**
     * @return the exam_id
     */
    public int getExam_id() {
        return exam_id;
    }

    /**
     * @param exam_id the exam_id to set
     */
    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    @Override
    public String toString() {
        return "Exam{" + "exam_id=" + exam_id + '}';
    }

    public Module getModuleid() {
        return moduleid;
    }

    public void setModuleid(Module moduleid) {
        this.moduleid = moduleid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public List<StudentExam> getStudentExams() {
        return studentExams;
    }

    public void setStudentExams(List<StudentExam> studentExams) {
        this.studentExams = studentExams;
    }

    public void addStudentExam(StudentExam studentExam){
        studentExam.setExam(this);
        getStudentExams().add(studentExam);
    }
}
