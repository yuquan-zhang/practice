package base;

import java.io.File;

/**
 * @author zhangyong created on 2020/8/26
 **/
public class StringUtils {
    public static void main(String[] args) {
        System.out.println(pureFileName("/abc/langldng.jpg"));
        System.out.println(pureFileName("thisisatest.jpg"));
        System.out.println(pureFileName("thisisatest.jpg/"));
    }

    private static String pureFileName(String fileName) {
        int index = fileName.lastIndexOf(File.separator);
        String pureFileName = fileName.substring(index + 1);
        return pureFileName;
    }
}
