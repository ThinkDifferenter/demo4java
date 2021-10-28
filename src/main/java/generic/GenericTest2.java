package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: GenericTest2
 *
 * @author junjiang
 * @date 2019-11-04 14:38
 */
public class GenericTest2<E> {
    private E tag;

    /**
     * 使用泛型类中的泛型标识的方法不是泛型方法
     */
    public E getTag() {
        return tag;
    }

    /**
     * 使用泛型类中的泛型标识的方法不是泛型方法
     */
    public void setTag(E tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "GenericTest2{" +
                "tag=" + tag +
                '}';
    }

    /**
     * 静态泛型方法
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    /**
     * 非静态泛型方法
     */
    public <X> List<X> arrayToList(X[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "c"};
        Arrays.sort(a);

        System.out.println(GenericTest2.getMiddle(a));

        GenericTest2<String> genericTest2 = new GenericTest2<>();
        genericTest2.setTag("This is generic method");
        System.out.println(genericTest2.toString());

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        System.out.println(genericTest2.arrayToList(arr));
    }
}