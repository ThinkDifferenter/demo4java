package hashmaptest;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 遍历测试
 *
 * @author junjiang
 * @date 2020-03-26 17:24
 */
public class TraverseTest {

    public static void main(String[] args){

        Map<Integer, String> map = new HashMap<>(4);
        map.put(1, "a");
        map.put(3, "c");
        map.put(5, "e");
        map.put(2, "b");
        map.forEach((key, value) -> System.out.println("Key = " + key + "  " + " Value = " + value));

        map.forEach((key,value)->{
            System.out.println("Key = " + key + "Value = " + value);
        });
    }
}