package jvm;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 09:56
 */
public class JvmTestOne {

    public static void main(String[] args) {
        System.out.println("begin.....");

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end.....");
    }
}
