package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface First {
    String value();
    int version();
}
@First(value = "this is first annotation.",version = 1)
class Annotation {

    @First(value = "this is method annotation",version = 1)
    public String value() {
        return "I'm in method.";
    }

    public int age() {
        return 22;
    }

}

public class FirstTest {
    public static void main(String[] args) throws Exception{
        First first = Annotation.class.getAnnotation(First.class);
        System.out.println(first.value());
        Method[] methods = Annotation.class.getDeclaredMethods();
        for(Method method : methods) {
            first = method.getAnnotation(First.class);
            if(first != null) {
                System.out.println(first.value());
                System.out.println(method.invoke(new Annotation(),null));
            }else {
                System.out.println("There are no First annotation.");
            }
        }
    }
}
