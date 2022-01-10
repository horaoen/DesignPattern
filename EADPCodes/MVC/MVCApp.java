package MVC;


/**
 * @author dll
 * @version 1.0
 * @created 28-2��-2020 23:52:20
 */
public class MVCApp {

public static void main(String[] args) {
 
      //�����ݿ��ȡѧ����¼
      StudentModel model  = retrieveStudentFromDatabase();
 
      //����һ����ͼ����ѧ����ϸ��Ϣ���������̨
      StudentView view = new StudentView();
 
      StudentController controller = new StudentController(model, view);
 
      controller.updateView();
 
      //����ģ������
      controller.setStudentName("John");
 
      controller.updateView();
   }
 
   private static StudentModel retrieveStudentFromDatabase(){
      StudentModel student = new StudentModel();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }
}//end MVCApp