package commontest;

/**
 * Description : try catch理解
 *
 * @author : JunJiang
 * @date : 2021-10-28 20:16
 */
public class TryAndCatch {

    public static void main(String[] args) {
        try {
            throw new Exception("异常1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("异常处理完了，接着执行后续逻辑...");

        try {
            throw new Exception("异常2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
