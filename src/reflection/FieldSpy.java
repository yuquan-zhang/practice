package reflection;

import java.util.Arrays;
import java.util.List;

public class FieldSpy<T> {
    public boolean[][] b = {{false, false},{true,true}};
    public String name = "Alice";
    public List<Integer> list;
    public T val;

    public static void main(String[] args) {
        try {
            Class<?> c = FieldSpy.class;
            Arrays.stream(c.getFields()).forEach(field -> {
                System.out.printf("Type: %s%n",field.getType());
                System.out.printf("GenericType: %s%n",field.getGenericType());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
