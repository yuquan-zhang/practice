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
        String phone = "15821118384";
        System.out.println(phone.substring(6));
        System.out.println(phone.substring(phone.length() - 6));
    }

    private static String pureFileName(String fileName) {
        int index = fileName.lastIndexOf(File.separator);
        String pureFileName = fileName.substring(index + 1);
        return pureFileName;
    }
}
