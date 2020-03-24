package base;

import java.lang.annotation.*;

/**
 * @author zhangyong created on 2019/11/8
 **/
public interface InterfaseDemo {

    @DemoSon()
    default String value() {
        return "hello";
    }

    public static void main(String[] args) {
        Inter inter = new Inter(){

        };
    }
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@interface Demo {
    String value();

    boolean ignore() default false;
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Demo("son")
@interface DemoSon {

}

interface Inter {

    default String hello() {
        return "";
    }
}
