/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.ijse.sms.dao.CrudDAOImpl;
import lk.ijse.sms.dao.custom.StudentDAO;
import lk.ijse.sms.entity.Student;
import lk.ijse.sms.entity.StudentCourse;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Sahan Rajakaruna
 */
public class StudentDAOImpl extends CrudDAOImpl<Student,String> implements StudentDAO {

//    @Override
//    public Student findByID(String id) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM Student WHERE sid = ?", id);
//        if (rs.next()) {
//
//            return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public ArrayList<Student> getAll() throws Exception {
//        ArrayList<Student> getall = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM Student");
//        while (rs.next()) {
//
//            getall.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
//        }
//        return getall;
//    }
//
//    @Override
//    public String getLastID() throws Exception {
//       ResultSet rs = CrudUtil.executeQuery("SELECT sid FROM Student ORDER BY sid DESC LIMIT 1");
//        if (rs.next()) {
//            return rs.getString(1);
//        } else {
//            return null;
//        }
//    }
//
    @Override
    public ArrayList<StudentCourse> getStudentCourses(String sid) throws Exception {

//        Session session =
//                HibernateUtil.getSessionFactory().openSession();
//        ArrayList<StudentCourse> studentCourses = new ArrayList<>();
//        Query sqlQuery = session.createSQLQuery("SELECT sb.batch_no,c.course_title from StudentBatch sb INNER JOIN Student s on sb.sid = s.sid INNER JOIN Batch b ON sb.batch_no=b.batch_no INNER JOIN Course c ON b.courseID = c.course_id WHERE s.sid=");
//        List<Object []> student = sqlQuery.setParameter("sid", sid).list();
//       for(Object[] row : student){
//           System.out.println(row[0]);
//       }
        return null;
//        return (ArrayList<StudentCourse>) nativeQuery.list();

//        ArrayList<StudentCourse> studentCourses = new ArrayList<>();
//        ResultSet rs = CrudUtil.executeQuery("SELECT sb.batch_no,c.course_title from student_batch sb INNER JOIN student s on sb.sid = s.sid INNER JOIN batch b ON sb.batch_no=b.batch_no INNER JOIN course c ON b.course_id = c.course_id WHERE s.sid=?", sid);
//        while (rs.next()) {
//
//            studentCourses.add(new StudentCourse(rs.getString(2), rs.getString(1)));
//
//        }
//        return studentCourses;
    }
//
//    @Override
//    public int studentCount() throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT COUNT(*) FROM student");
//        if (rs.next()) {
//            return rs.getInt(1);
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public ArrayList<String> getStudentBatch(String sid) throws Exception {
//        ResultSet rs = CrudUtil.executeQuery("SELECT b.batch_no FROM batch b INNER JOIN student_batch sb ON sb.batch_no=b.batch_no WHERE sb.sid=?", sid);
//        ArrayList<String> studentBatches = new ArrayList<>();
//        while(rs.next()){
//            studentBatches.add(rs.getString(1));
//        }
//        return studentBatches;
//    }

}
