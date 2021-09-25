package gctest;

/**
 * Description : finalize 方法测试
 *
 * @author : JunJiang
 * @date : 2021-09-19 15:30
 */
public class FinalizeTest {

    private static FinalizeTest finalizeTest;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Override the Object's finalize method");
        finalizeTest = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeTest = new FinalizeTest();
        finalizeTest = null;

        System.out.println("GC First:");
        System.gc();
        Thread.sleep(5000);
        if (finalizeTest == null) {
            System.out.println("the object is death");
        } else {
            System.out.println("the object is alive");
        }


        System.out.println("GC Second:");
        finalizeTest = null;
        System.gc();
        Thread.sleep(5000);
        if (finalizeTest == null) {
            System.out.println("the object is death");
        } else {
            System.out.println("the object is alive");
        }

    }
}
