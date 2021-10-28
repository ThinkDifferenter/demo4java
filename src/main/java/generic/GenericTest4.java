package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description : 泛型测试4
 *
 * @author : JunJiang
 * @date : 2021-10-28 16:16
 */
public class GenericTest4 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();

        /* 具有继承关系的子父类传入泛型后不再具有继承关系，而是并列关系，如果父类的容器能够引用子类容器
           再次添加元素时会破坏容器中元素的统一性
           list2 = list1; Error! A,B是继承关系， G<A> & G<B>为并列关系; A<G>&B<G> 依然为继承关系。
           通配符？ G<A> & G<B>的共同父类为G<?>
        */
        ArrayList<String> list3 = new ArrayList<>();
        List<String> list4 = list3;

        // It's OK !
        List<?> list5 = null;
        list5 = list1;
        list5 = list2;

    }

    /**
     * 含有通配符的方法
     */
    public static void printList(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        List<?> list2 = list;

        // list2.add("CC") Error! 通配符引用指向容器时，不允许通过该引用再往容器中添加元素(写入，null除外！)，可通过该引用获取容器中元素
        list2.add(null);
        list.add("CC");

        printList(list2);
    }
}
