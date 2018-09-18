/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author Sahan Rajakaruna
 */
@Embeddable
public class StudentExam_PK implements Serializable {

    private String sid;
    private int examid;
    /**
     * @return the sidm
     */
    public String getSidm() {
        return sid;
    }

    /**
     * @param sidm the sidm to set
     */
    public void setSidm(String sid) {
        this.sid = sid;
    }

    /**
     * @return the examid
     */
    public int getExamid() {
        return examid;
    }

    /**
     * @param examid the examid to set
     */
    public void setExamid(int examid) {
        this.examid = examid;
    }


    public StudentExam_PK() {
    }

    public StudentExam_PK(String sidm, int examid) {
        this.sid = sidm;
        this.examid = examid;
    }
    
}
