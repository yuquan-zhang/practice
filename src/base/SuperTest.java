package base;

/**
 * this 和 super 关键字都指向当前的对象；
 * 不同的是：
 *   this.methodName 调用的都是当前对象所属子类的方法，
 *   而super.methodName 调用的都是其所在类的父类中的方法。
 * 例如：
 *   当super.clone()所在的类是Life时，它调用的方法就是Life类的父类Object中的clone方法
 *   当super.clone()所在的类是Animal时，它调用的方法就是Animal类的父类Life中的clone方法
 *   与此同时，super和this关键字，无论出现在哪（Life类中，或Animal类中），指向的实例对象都是同一个，Animal@506
 *
 */
public class SuperTest {
    public static void main(String[] args) {
        Life animal = new Animal();
        animal.move();
    }
}

class Life implements Cloneable{
    protected void move() {
        System.out.println(this);
        System.out.println(this.clone());
    }

    @Override
    protected Object clone() {
        Life life = null;
        try {
            life = (Life)super.clone();
        } catch (CloneNotSupportedException e){
            //
        }
        return life;
    }

}

class Animal extends Life implements Cloneable{
    @Override
    protected void move() {
        super.move();
        System.out.println(this);
        System.out.println(this.clone());
    }

    @Override
    protected Object clone() {
        Animal life = null;
        life = (Animal)super.clone();
        return life;
    }
}
