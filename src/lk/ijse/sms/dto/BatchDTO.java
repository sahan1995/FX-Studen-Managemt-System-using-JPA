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
public class BatchDTO 
{

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
    private BigDecimal fee;
    private String course_id;

    public BatchDTO() {
    }

    public BatchDTO(String batch_no, BigDecimal fee, String course_id) {
        this.batch_no = batch_no;
        this.fee = fee;
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "BatchDTO{" + "batch_no=" + batch_no + ", fee=" + fee + ", course_id=" + course_id + '}';
    }
    
}
