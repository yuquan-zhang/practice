package basicio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class LogFileTest {
    public static void main(String[] args) {
        String s = "Hello, world! ";
        byte[] data = s.getBytes();
        Path p = Paths.get("./logfile2.txt");
        System.out.printf("Before: Is file exist? %s%n", Files.exists(p));
        try(OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
            System.out.printf("After: Is file exist? %s%n", Files.exists(p));
        }catch (IOException e) {
            System.err.println(e);
        }
        try {
            Path tempFile = Files.createTempFile(null, ".myapp");
            System.out.format("The temporary file" +
                    " has been created: %s%n", tempFile)
            ;
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
