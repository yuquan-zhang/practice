package base;

import java.util.ArrayList;
import java.util.List;

public class Varargs {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }

    public static void main(String[] args) {
        Varargs varargs = new Varargs();
        varargs.setNames("Bob","lucy","michael");
        System.out.println(varargs.names.length);

        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() + "/" + l2.getClass());
        System.out.println(l1.getClass() == l2.getClass());

        List<String>[] lists = new List[5];
    }
}
