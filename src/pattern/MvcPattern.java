package pattern;

class Student {
    private String name;
    private int No;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }
}

class StudentView {
    public void displayStudentDetails(String name, int no) {
        System.out.println("student:");
        System.out.println("name:" + name);
        System.out.println("studentNo:" + no);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        this.model.setName(name);
    }

    public void setStudentNo(int no) {
        this.model.setNo(no);
    }

    public String getStudentName() {
        return this.model.getName();
    }

    public int getStudentNo() {
        return this.model.getNo();
    }

    public void updateView() {
        this.view.displayStudentDetails(getStudentName(),getStudentNo());
    }
}

public class MvcPattern {
    private static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setNo(10);
        return student;
    }
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model,view);
        controller.updateView();
        controller.setStudentName("bruce");
        controller.updateView();
    }
}
