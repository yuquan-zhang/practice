package base;

/**
 * @author zhangyong created on 2019/9/30
 **/
public class NewObjectDemo {
    private String name;
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        NewObjectDemo nod = new NewObjectDemo(){{
           setName("zhang yong");
           this.sex = "male";
        }};
        System.out.println(nod.getName());
        System.out.println(nod.sex);
    }
}
