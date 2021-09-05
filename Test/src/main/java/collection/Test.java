package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangjun
 * @date 2018.10.22
 */
public class Test
{
    private static int a;

    private static void f(int b){
        a=b;
        System.out.print(a);
    }

    public static void main(String[] args){
        Map<Integer,String> m = new HashMap<Integer, String>();

        m.put(new Integer(1),"jiang");
        m.put(new Integer(2),"jun");

        //System.out.println("before: "+m);

        for ( Map.Entry<Integer, String> entry: m.entrySet()){
            System.out.printf("Key:%d,Value:%s\n",entry.getKey(),entry.getValue());
        }

        m.put(new Integer(2),"zhang");

        System.out.println("after: "+m);



        Float a = 1f;
        Float b = 2f;

        System.out.println(a.compareTo(b));

        System.out.println(Float.compare(a,b));

    }

}
