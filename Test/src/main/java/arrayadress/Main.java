package arrayadress;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: main
 *
 * @author junjiang
 * @create 2019-08-26 10:23
 */
public class Main {

    public static void main(String[] args) {

        List<Test> arr = new ArrayList<>(2);
        System.out.println(System.identityHashCode(arr));

        System.out.println(System.identityHashCode(arr.get(0)));
        System.out.println(System.identityHashCode(arr.get(1)));

        System.out.println();

        Integer[] a = new Integer[3];
        a[0] =  127;
        a[1] =  127;
        a[2] =  127;

        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(a[0]));
        System.out.println(System.identityHashCode(a[1]));
        System.out.println(System.identityHashCode(a[2]));
    }
}