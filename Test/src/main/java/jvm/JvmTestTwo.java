package jvm;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 09:59
 */
public class JvmTestTwo {

    public static void main(String[] args) {
        System.out.println("begin.....");

        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end.....");
    }
}
