package base;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

interface UnaryPredicate<T> {
    boolean test(T t);
}

public class GenericsMethod {



    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for(T t : c) {
            if(p.test(t)) {
                ++count;
            }
        }
        return count;
    }

    public static <E extends Number> void countSpecialElement(List<E> list) {
        int count = 0;
        for(Number n : list) {
            if(n.intValue() % 2 == 1) count++;
        }
        System.out.printf("The count of odd element in list is %d%n",count);
    }

    public static <T> void changeDifferentElements(T[] ts) {
        if(ts.length < 2) return;
        System.out.printf("the array before change is %s%n", Arrays.toString(ts));
        if(!ts[0].equals(ts[1])){
            T t = ts[0];
            ts[0] = ts[1];
            ts[1] = t;
        }
        System.out.printf("the array after change is %s%n", Arrays.toString(ts));
    }

    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {
        T maxElen = list.get(begin);
        for(++begin; begin < end; ++begin) {
            if(maxElen.compareTo(list.get(begin)) < 0) {
                maxElen = list.get(begin);
            }
        }
        return maxElen;
    }


    public static void main(String[] args) {
        countSpecialElement(Arrays.asList(1,2,3,4,5,6,7,8,9,1.0));
        changeDifferentElements(new String[]{"one","two"});
        System.out.printf("The count of odd element in list is %d%n",
                countIf(Arrays.asList(1,2,3,4,5,6,7,8,9,1.0),(t) -> t.intValue() % 2 == 1));
    }
}
