package collectionframwork;

import java.util.*;


public class MapTest2 {

    public static void main(String[] args){

        Map<Long,Float> m = new HashMap<Long,Float>();
        m.put(new Long(1),new Float(31.234));
        m.put(new Long(3),new Float(20.15151));
        m.put(new Long(2),new Float(23.151));

        System.out.println(m);
        List<Map.Entry<Long, Float>> list_Data = new ArrayList<Map.Entry<Long, Float>>(m.entrySet());

        Collections.sort(list_Data, new Comparator<Map.Entry<Long, Float>>() {
            @Override
            public int compare(Map.Entry<Long, Float> o1, Map.Entry<Long, Float> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Long,Float> mapping:list_Data){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }

    }
}
