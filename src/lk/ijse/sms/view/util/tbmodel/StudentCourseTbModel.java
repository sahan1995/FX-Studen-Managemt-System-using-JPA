/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.view.util.tbmodel;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentCourseTbModel {

    /**
     * @return the batchNo
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * @param batchNo the batchNo to set
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * @return the courseTitle
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     * @param courseTitle the courseTitle to set
     */
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    private String batchNo;
    private String courseTitle;

    public StudentCourseTbModel() {
    }

    public StudentCourseTbModel(String batchNo, String courseTitle) {
        this.batchNo = batchNo;
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "StudentCourseTbModel{" + "batchNo=" + batchNo + ", courseTitle=" + courseTitle + '}';
    }
    
}
