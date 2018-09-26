package base;

public class DataTypes {


    public static void main(String[] args) {
        int max = -0b1110;
        System.out.println(max >> 1);
        System.out.println(Integer.toBinaryString(max >> 1));
        System.out.println(max >>> 1);
        System.out.println(Integer.toBinaryString(max >>> 1));
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 0, 13);

        System.out.println(new String(copyTo));
        System.out.println(java.util.Arrays.equals(copyFrom,copyTo));
        java.util.Arrays.sort(copyFrom);
        System.out.println(java.util.Arrays.binarySearch(copyFrom,'d'));

    }
}
