package genericsuperandextends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args){
        // <? extends E> 是 Upper Bound（上限） 的通配符，用来限制元素的类型的上限（限制类及其子类）
        List<? extends Fruit> fruits;
        //fruits =  new ArrayList<Fruit>();
        //fruits = new ArrayList<Object>(); error!
        fruits = new ArrayList<Apple>(2);

        // <? extends E>不支持写入（add）子类间类型不兼容,支持读取（get）
        //fruits.add(new Fruit());error!
        //fruits.add(new Apple());error!
        //fruits.add(new Pear());error!
        //fruits.get(0);

        //<? super E> 是 Lower Bound（下限） 的通配符 ，用来限制元素的类型下限（限制类及其父类）
        List<? super Apple> apples;
        //apples = new ArrayList<Fruit>();
        //apples = new ArrayList<Pear>(); error!
        apples = new ArrayList<Apple>();

        //<? super E>支持写入（add）与限制类类型兼容的类，支持读取（get），返回对象均为Object，需要类型转换
        apples.add(new Apple());
        apples.add(new RedApple());


//        PECS法则：生产者（Producer）使用extends，消费者（Consumer）使用super
//        1、生产者
//        如果你需要一个提供E类型元素的集合，使用泛型通配符<? extends E>。它好比一个生产者，可以提供数据。
//        2、消费者
//        如果你需要一个只能装入E类型元素的集合，使用泛型通配符<? super E>。它好比一个消费者，可以消费你提供的数据。
//        3、既是生产者也是消费者
//        既要存储又要读取，那就别使用泛型通配符。

        Apple apple1 = new Apple("apple1");
        Apple apple2 = new Apple("apple2");

        Main.swap(apple1,apple2);

        System.out.println(apple1.getStr());
        System.out.println(apple2.getStr());

        Pear  pear1 = new Pear();
        Pear  pear2 = new Pear();

        out.println(pear1.equals(pear1));

        int[]  array = {1,2,3,4,5};
        out.println(Arrays.toString(array));

        int[][] array2 = {{1,2},{3,4},{5,6}};
        out.println(Arrays.deepToString(array2));

        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(apple1);
        fruitList.add(apple1);
        fruitList.add(apple2);

        out.println(fruitList.toString());

        int[] clone = array.clone();

        out.println(Arrays.toString(clone));
    }

    //java按值调用 call by value
    public static void swap(Apple a1,Apple a2){
        Apple tmp = a1;
        a1 = a2;
        a2 = tmp;
    }
}

