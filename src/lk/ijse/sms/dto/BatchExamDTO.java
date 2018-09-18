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
public class BatchExamDTO {

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
     * @return the exam_module
     */
    public String getExam_module() {
        return exam_module;
    }

    /**
     * @param exam_module the exam_module to set
     */
    public void setExam_module(String exam_module) {
        this.exam_module = exam_module;
    }
    private int exam_id;
    private String exam_module;

    public BatchExamDTO() {
    }

    public BatchExamDTO(int exam_id, String exam_module) {
        this.exam_id = exam_id;
        this.exam_module = exam_module;
    }

    @Override
    public String toString() {
        return "BatchExamDTO{" + "exam_id=" + exam_id + ", exam_module=" + exam_module + '}';
    }
    
}
