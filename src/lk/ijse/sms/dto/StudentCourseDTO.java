/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dto;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentCourseDTO {

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the course_title
     */
    public String getCourse_title() {
        return course_title;
    }

    /**
     * @param course_title the course_title to set
     */
    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
    private String batchId;
    private String course_title;

    public StudentCourseDTO() {
    }

    public StudentCourseDTO(String batchId, String course_title) {
        this.batchId = batchId;
        this.course_title = course_title;
    }

    @Override
    public String toString() {
        return "StudentCourseDTO{" + "batchId=" + batchId + ", course_title=" + course_title + '}';
    }
    
}
