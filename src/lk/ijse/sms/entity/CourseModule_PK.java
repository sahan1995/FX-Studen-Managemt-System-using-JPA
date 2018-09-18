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
public class CourseModule_PK implements Serializable {
    
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

    /**
     * @return the module_id
     */
    public String getModule_id() {
        return module_id;
    }

    /**
     * @param module_id the module_id to set
     */
    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }
    private String course_id;
    private String module_id;

    public CourseModule_PK() {
    }

    public CourseModule_PK(String course_id, String module_id) {
        this.course_id = course_id;
        this.module_id = module_id;
    }
    
}
