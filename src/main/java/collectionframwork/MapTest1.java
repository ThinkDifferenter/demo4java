package collectionframwork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author JiangJun
 */
public class MapTest1 {

    public static void main(String[] args){
        Map<Long,Float> m = new HashMap<Long,Float>();
        m.put(new Long(1),new Float(31.234));
        m.put(new Long(3),new Float(20.15151));
        m.put(new Long(2),new Float(23.151));


        //way1:
        for (Map.Entry<Long,Float> entry : m.entrySet() ){
            System.out.println("Key: "+entry.getKey()+" ,Value: "+entry.getValue());
        }
        System.out.println("=====================");

        //way2:
        for (Long k:m.keySet()) {
            System.out.println("Key: "+ k +" ,Value: "+ m.get(k));
        }
        System.out.println("=====================");

        //way3:
        Iterator<Map.Entry<Long,Float>> entry = m.entrySet().iterator();
        while(entry.hasNext()){
            Map.Entry<Long,Float> ent = entry.next();
            System.out.println("Key = " + ent.getKey() + " ,Value = " + ent.getValue());
        }

    }
}
