package generic;

import java.util.Arrays;

/**
 * Description : 泛型测试1
 *
 * @author : JunJiang
 * @date : 2021-10-28 15:09
 */
public class GenericTest1<T> {
    private T[] arr;

    public GenericTest1() {
    }

    public GenericTest1(T[] arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "GenericTest1{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"java", "spring"};
        GenericTest1<String> genericTest1 = new GenericTest1<>(arr);
        System.out.println(genericTest1.toString());
    }
}

