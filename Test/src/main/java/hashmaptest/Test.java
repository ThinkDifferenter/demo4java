package hashmaptest;

import java.util.HashMap;

/**
 * 描述: 测试
 *
 * @author junjiang
 * @date 2020-03-24 11:09
 */
public class Test {

    public static void main(String[] args){

        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("1",1);
        map1.put("2",2);
        map1.put("3",3);
        // key存在返回value
        Integer integer = map1.computeIfAbsent("3", key -> new Integer(4));
        // key不存在执行函数存入
        Integer integer1 = map1.computeIfAbsent("4", key -> new Integer(4));
        System.out.println("\n===================computeIfAbsent==================");
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(map1.toString());


        HashMap<String,Integer> map2 = new HashMap<>();
        map2.put("1",1);
        map2.put("2",2);
        map2.put("3",3);
        // 只对map中存在的key对应的value进行操作
        Integer integer3 = map2.computeIfPresent("3", (k,v) -> v+1 );
        // map中不存在的key不做任何操作
        Integer integer4 = map2.computeIfPresent("4", (k,v) -> {
            if (v==null) {
                return 0;
            }
            return v+1;
        } );
        System.out.println("\n===================computeIfPresent==================");
        System.out.println(integer3);
        System.out.println(integer4);
        System.out.println(map2.toString());


        HashMap<String,Integer> map3 = new HashMap<>();
        map3.put("1",1);
        map3.put("2",2);
        map3.put("3",3);

        // key不管存在不在都会执行后面的函数，并保存到map中
        Integer integer5 = map3.compute("3", (k,v) -> v+1 );
        Integer integer6 = map3.compute("4", (k,v) -> {
            if (v==null) {
                return 0;
            }
            return v+1;
        } );
        System.out.println("\n===================compute==================");
        System.out.println(integer5);
        System.out.println(integer6);
        System.out.println(map3.toString());
    }

}