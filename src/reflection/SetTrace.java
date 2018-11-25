package reflection;

import java.lang.reflect.Field;
import java.util.Scanner;

import static java.lang.System.out;

enum TraceLevel { OFF, LOW, MEDIUM, HIGH, DEBUG }

class MyServer {
    private TraceLevel level = TraceLevel.OFF;
}
public class SetTrace {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        TraceLevel newLevel = TraceLevel.valueOf(scanner.nextLine());

        try {
            MyServer svr = new MyServer();
            Class<?> c = svr.getClass();
            Field f = c.getDeclaredField("level");
            f.setAccessible(true);
            TraceLevel oldLevel = (TraceLevel)f.get(svr);
            out.format("Original trace level:  %s%n", oldLevel);

            if (oldLevel != newLevel) {
                f.set(svr, newLevel);
                out.format("    New  trace level:  %s%n", f.get(svr));
            }

            // production code should handle these exceptions more gracefully
        } catch (IllegalArgumentException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        }
    }
}
