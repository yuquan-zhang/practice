package base;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

public class MethodReferenceTest {
    public static void main(String[] args) {
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {

        DEST result = collectionFactory.get();
//        for (T t : sourceCollection) {
//            result.add(t);
//        }
        result.addAll(sourceCollection);
        return result;
    }
}
