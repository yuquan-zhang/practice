package basicio;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DirectoryTest {
    public static void main(String[] args) {
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for(Path name : dirs) {
            System.err.println(name);
        }
    }
}
