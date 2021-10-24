package generic;

import java.util.Arrays;

/**
 * 描述: Main
 *
 * @author junjiang
 * @create 2019-11-04 14:38
 */
public class Main {

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "c"};
        Arrays.sort(a);

        System.out.println(Main.getMiddle(a));
    }
}