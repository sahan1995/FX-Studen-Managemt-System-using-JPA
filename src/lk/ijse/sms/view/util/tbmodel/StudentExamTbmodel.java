/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.view.util.tbmodel;

import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentExamTbmodel {

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
     * @return the module_name
     */
    public String getModule_name() {
        return module_name;
    }

    /**
     * @param module_name the module_name to set
     */
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    /**
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
    
    private int exam_id;
    private String module_name;
    private String mark;

    public StudentExamTbmodel() {
    }

    public StudentExamTbmodel(int exam_id, String module_name, String mark) {
        this.exam_id = exam_id;
        this.module_name = module_name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "StudentExamTbmodel{" + "exam_id=" + exam_id + ", module_name=" + module_name + ", mark=" + mark + '}';
    }
    
}
