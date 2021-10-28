package collectionframwork;

import org.junit.Test;

import java.util.*;


/**
 * Description : 线性表测试1
 *
 * @author : JunJiang
 * @date : 2021-10-25 15:47
 */
public class ListTest1 {

    @Test
    public void test1() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(new Integer(1));
        list1.add(new Integer(2));
        list1.add(new Integer(3));
        list1.add(new Integer(4));
        list1.add(new Integer(5));
        list1.add(new Integer(6));
        list1.remove(0);
        list1.add(null);
        list1.forEach(x -> System.out.print(x + " "));

        System.out.println("\n=======================");

        List<Integer> list2 = new LinkedList<>();
        list2.add(new Integer(1));
        list2.add(new Integer(2));
        list2.add(new Integer(3));
        list2.add(new Integer(4));
        list2.add(new Integer(5));
        list2.add(new Integer(6));
        list2.remove(0);
        list2.add(null);
        list2.forEach(x -> System.out.print(x + " "));

    }

    @Test
    public void test2() {

        Arrays.asList(new String[]{"A", "B", "C"}).forEach(System.out::println);

        /*
         * 注意在使用Arrays.asList等可变参数方法时，基本类型数组会被当做一个整体作为参数传入
         * 而包裹类型数组会被拆分为多个变量传入可变参数方法
         */
        System.out.println(Arrays.asList(new int[]{1, 2, 3}).size());
        System.out.println(Arrays.asList(new Integer[]{1, 2, 3}).size());

        Integer[] arr = new Integer[]{1, 2, 3};
        // add()、remove()、clear() 报错！也是这种方式创建集合对象的局限性
        List<Integer> ints = Arrays.asList(arr);
        // Arrays.asList()方法将数组与List列表链接起来：当更新其一个时，另一个自动更新
        arr[0] = 11;
        ints.forEach(System.out::println);

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        List<Integer> result = new ArrayList<>(array.length);
        Collections.addAll(result, array);

        result.forEach(System.out::println);
    }

}
