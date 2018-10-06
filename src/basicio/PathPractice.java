package basicio;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathPractice {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.home"),"logs","foo.log");
        System.out.printf("path is null ? : %s %n", path == null);
        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
        System.out.printf("path to uri %s%n", path.toUri());
        try {
            Path fp = path.toRealPath();
        }catch (NoSuchFileException e) {
            System.out.printf("%s no such file or directory%n", path);
        }catch (IOException e) {
            System.out.printf("exception for path.toRealPath() %s%n", e);
        }
    }
}
