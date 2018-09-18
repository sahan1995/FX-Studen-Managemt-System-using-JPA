/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import javax.persistence.*;

/**
 *
 * @author Sahan Rajakaruna
 */
@Entity
public class CourseModule {

    @EmbeddedId
    private CourseModule_PK courseModule_PK;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",insertable = false,updatable = false)
    private Course course_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "module_id",referencedColumnName = "module_id",insertable = false,updatable = false)
    private Module module_id;

    /**
     * @return the courseModule_PK
     */
    public CourseModule_PK getCourseModule_PK() {
        return courseModule_PK;
    }

    /**
     * @param courseModule_PK the courseModule_PK to set
     */
    public void setCourseModule_PK(CourseModule_PK courseModule_PK) {
        this.courseModule_PK = courseModule_PK;
    }


    public CourseModule() {
    }

    public CourseModule(CourseModule_PK courseModule_PK) {
        this.setCourseModule_PK(courseModule_PK);
    }
    public CourseModule(String course_id,String module_Id) {
        this.setCourseModule_PK(new CourseModule_PK(course_id, module_Id));
    }

    public Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public Module getModule_id() {
        return module_id;
    }

    public void setModule_id(Module module_id) {
        this.module_id = module_id;
    }
}
