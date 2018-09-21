package pattern;

import java.util.ArrayList;
import java.util.List;

class StudentVO {
    private String name;
    private int rollNo;

    public StudentVO(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}

class StudentBO {
    List<StudentVO> studentVOS;

    public StudentBO() {
        studentVOS = new ArrayList<>();
        studentVOS.add(new StudentVO("bob",0));
        studentVOS.add(new StudentVO("jack",1));
    }

    public void deleteStudent(StudentVO studentVO) {
        studentVOS.remove(studentVO.getRollNo());
        System.out.println("deleting student rollNo:" + studentVO.getRollNo() + " from database.");
    }

    public List<StudentVO> getAllStudents() {
        return studentVOS;
    }

    public StudentVO getStudent(int rollNo) {
        return studentVOS.get(rollNo);
    }

    public void updateStudent(StudentVO studentVO) {
        studentVOS.get(studentVO.getRollNo()).setName(studentVO.getName());
        System.out.println("Updating student rollNo:" + studentVO.getRollNo() + " in the database.");
    }
}

public class TransferObjectPattern {
    public static void main(String[] args) {
        StudentBO studentBusinessObject = new StudentBO();
        for (StudentVO student : studentBusinessObject.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        //update student
        StudentVO student = studentBusinessObject.getAllStudents().get(0);
        student.setName("Michael");
        studentBusinessObject.updateStudent(student);

        //get the student
        student = studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");

    }
}
