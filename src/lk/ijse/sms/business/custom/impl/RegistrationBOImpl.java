/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.sms.business.custom.impl;

import lk.ijse.sms.business.custom.RegistrationBO;
import lk.ijse.sms.dao.DAOFactory;
import lk.ijse.sms.dao.custom.StudentBatchDAO;
import lk.ijse.sms.dao.custom.StudentDAO;
import lk.ijse.sms.dto.StudentBatchDTO;
import lk.ijse.sms.dto.StudentDTO;
import lk.ijse.sms.entity.StudentBatch;

/**
 * @author Sahan Rajakaruna
 */
public class RegistrationBOImpl implements RegistrationBO {

    private StudentDAO studentDAO;
    private StudentBatchDAO student_batchDAO;

    private StundetBOImpl studentBo;
    private StudentBatchBOImpl studentBatchBO;

    public RegistrationBOImpl() {
        this.student_batchDAO = (StudentBatchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.student_batch);
        this.studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.student);

        studentBo = new StundetBOImpl();
        studentBatchBO = new StudentBatchBOImpl();

    }

    @Override
    public boolean RegisterNewStudent(StudentDTO student, StudentBatchDTO studentBatch) throws Exception {



        boolean first = studentBo.RegisterStudent(student);
        boolean second = studentBatchBO.AddStudentBatch(studentBatch);

        if(first&&second){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean RegisterToBatch(StudentBatchDTO studentBatch) throws Exception {
        return studentBatchBO.AddStudentBatch(new StudentBatchDTO(studentBatch.getId(), studentBatch.getBatch_bo()));

    }

}
