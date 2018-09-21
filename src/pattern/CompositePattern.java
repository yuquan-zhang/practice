package pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Employee {
    int getId();
    String getName();
    double getSalary();
    void print();
    void add(Employee employee);
    void remove(Employee employee);
    Employee getChild(int i);
}

class BankManager implements Employee {
    private int id;
    private String name;
    private double salary;

    public BankManager(int id,String name,double salary) {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }
    List<Employee> employees = new ArrayList<Employee>();
    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }
    @Override
    public Employee getChild(int i) {
        return employees.get(i);
    }
    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }
    @Override
    public int getId()  {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("==========================");

        Iterator<Employee> it = employees.iterator();

        while(it.hasNext())  {
            Employee employee = it.next();
            employee.print();
        }
    }
}

class Cashier implements Employee {
    private int id;
    private String name;
    private double salary;
    public Cashier(int id,String name,double salary)  {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void add(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }
    @Override
    public Employee getChild(int i) {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("==========================");
    }
    @Override
    public void remove(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }
}

class Accountant implements Employee {
    private int id;
    private String name;
    private double salary;
    public Accountant(int id,String name,double salary)  {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void add(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }
    @Override
    public Employee getChild(int i) {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("=========================");
        System.out.println("Id ="+getId());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("=========================");
    }
    @Override
    public void remove(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Employee emp1=new Cashier(101,"Sohan Kumar", 20000.0);
        Employee emp2=new Cashier(102,"Mohan Kumar", 25000.0);
        Employee emp3=new Accountant(103,"Seema Mahiwal", 30000.0);
        Employee manager1=new BankManager(100,"Ashwani Rajput",100000.0);

        manager1.add(emp1);
        manager1.add(emp2);
        manager1.add(emp3);
        manager1.print();
    }
}
