/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sahan Rajakaruna
 */
@Entity
public class Course {

    @Id
    private String course_id;
    private String course_title;
    private String duration;


    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private List<Batch> batchList  = new ArrayList<>();

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

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Course(String course_id) {
        this.course_id = course_id;
    }

    public Course() {
    }

    public Course(String course_id, String course_title, String duration) {
        this.course_id = course_id;
        this.course_title = course_title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", course_title=" + course_title + ", duration=" + duration + '}';
    }


    public List<Batch> getBatchList() {
        return batchList;
    }

    public void setBatchList(List<Batch> batchList) {
        this.batchList = batchList;
    }
}
