package basetest;

import interfacedefaultmethod.InterfaceA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        List<String> list = new ArrayList<>(2);
        list.add("1");
        list.add("2");

        for(String item : list){
            if("1".equals(item)){
                list.remove(item);
            }
        }

        System.out.println(list.toString());
    }

    public static void swap(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap(Integer a,Integer b){
        Integer tmp = a;
        a = b;
        b = tmp;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> tmp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                tmp.put(i, nums[i]);
            }
        }

        for(Integer i : tmp.keySet()){
            for(Integer j : tmp.keySet()){
                if(i.equals(j)){
                    continue;
                }

                if (tmp.get(i) + tmp.get(j) == target) {
                    result[0] = i;
                    result[1] = j;
                }

            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if (i == j) {
                    continue;
                }

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }


}
