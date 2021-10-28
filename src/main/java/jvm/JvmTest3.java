package jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Description : JVM  测试3
 *
 * @author : JunJiang
 * @date : 2021-10-24 21:37
 */
public class JvmTest3 {

    @Test
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    @Test
    public void test2(){
        List<byte[]> list = new ArrayList<>();
        while (true){
            byte[] arr = new byte[new Random().nextInt(1000)];
            list.add(arr);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
