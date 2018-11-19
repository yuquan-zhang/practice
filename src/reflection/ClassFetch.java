package reflection;

class cls {
    private cls(){}
}

public class ClassFetch {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("reflection.cls");
            c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
