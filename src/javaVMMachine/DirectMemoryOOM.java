package javaVMMachine;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 * @author zhangyong created on 2019/10/7
 **/
public class DirectMemoryOOM {
    private static final int _100MB = 1_024 * 1_024 * 100;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_100MB);// 分配本机直接内存
        }
    }
}
