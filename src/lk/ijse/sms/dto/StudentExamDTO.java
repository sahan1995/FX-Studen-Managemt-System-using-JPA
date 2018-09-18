/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dto;

import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentExamDTO {
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
    private String id;
    private int exam_id;
    private BigDecimal marks;

    public StudentExamDTO() {
    }

    public StudentExamDTO(String id, int exam_id, BigDecimal marks) {
        this.id = id;
        this.exam_id = exam_id;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "StudentExamDTO{" + "id=" + id + ", exam_id=" + exam_id + ", marks=" + marks + '}';
    }
    
    
    
}
