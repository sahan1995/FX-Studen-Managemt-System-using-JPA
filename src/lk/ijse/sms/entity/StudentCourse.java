/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentCourse {

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
     * @return the course_id
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    private String batch_no;
    private String course_id;

    public StudentCourse() {
    }

    public StudentCourse(String batch_no, String course_id) {
        this.batch_no = batch_no;
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "StudentCourse{" + "batch_no=" + batch_no + ", course_id=" + course_id + '}';
    }
    
}
