import lk.ijse.sms.business.BOFactory;
import lk.ijse.sms.business.custom.RegisterCourseBO;
import lk.ijse.sms.dto.CourseModuleDTO;
import lk.ijse.sms.dto.ExamDTO;

public class TestClass {

    public static void main(String[] args) throws Exception {

        RegisterCourseBO bo = (RegisterCourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.course_register);

        ExamDTO examDTO = new ExamDTO(null, "C005", "M001");
        CourseModuleDTO courseModuleDTO = new CourseModuleDTO("C005", "M001");
        bo.addExamandModule(examDTO,courseModuleDTO);

    }

}
