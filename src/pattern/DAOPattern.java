package pattern;

import java.util.ArrayList;
import java.util.List;

class People {
    private String name;
    private int rollNo;

    public People(String name, int rollNo) {
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

interface PeopleDao {
    List<People> getAllPeoples();
    People getPeople(int rollNo);
    void updatePeople(People people);
    void deletePeople(People people);
}

class PeopleDaoImp implements PeopleDao {
    private List<People> peoples;

    public PeopleDaoImp() {
        peoples = new ArrayList<>();
        peoples.add(new People("bob",0));
        peoples.add(new People("jack",1));
    }

    @Override
    public List<People> getAllPeoples() {
        return peoples;
    }

    @Override
    public People getPeople(int rollNo) {
        return peoples.get(rollNo);
    }

    @Override
    public void updatePeople(People people) {
        peoples.get(people.getRollNo()).setName(people.getName());
        System.out.println("People: roll No " + people.getRollNo() + ", updated in database.");
    }

    @Override
    public void deletePeople(People people) {
        peoples.remove(people.getRollNo());
        System.out.println("People: roll No " + people.getRollNo() + ", deleted from database.");
    }
}

public class DAOPattern {
    public static void main(String[] args) {
        PeopleDao peopleDao = new PeopleDaoImp();
        for(People people : peopleDao.getAllPeoples()) {
            System.out.println("People:[rollNo :" + people.getRollNo() + ", name :" + people.getName() + "] ");
        }
        People people = peopleDao.getPeople(0);
        people.setName("Bruce");
        peopleDao.updatePeople(people);

        people = peopleDao.getPeople(0);
        System.out.println("People : [roll No : " + people.getRollNo() + ", name : " + people.getName() + "]");
    }
}
