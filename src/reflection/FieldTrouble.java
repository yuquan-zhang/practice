package reflection;

import java.lang.reflect.Field;

public class FieldTrouble {
    private Integer val;
    public static void main(String[] args) {
        FieldTrouble ft = new FieldTrouble();
        try {
            Class<?> c = FieldTrouble.class;
            Field f = c.getDeclaredField("val");
            f.set(ft,new Integer(12));
            System.out.println(ft.val);
            System.out.printf("Integer is assignable from int ? %b%n",Integer.class.isAssignableFrom(int.class));
            System.out.printf("int is assignable from Integer ? %b%n",int.class.isAssignableFrom(Integer.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
