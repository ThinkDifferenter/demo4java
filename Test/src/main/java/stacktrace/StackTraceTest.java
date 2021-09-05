package stacktrace;

import java.util.*;
public class StackTraceTest {

    public static int factorial(int n)
    {
        System.out.println("factorial(" + n + "):");

        //函数调用跟踪
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }

        int r;
        if (n <= 1){
            r = 1;
        } else{
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args)
    {
        //在try语句中使用资源会自动关闭资源
        try (Scanner in = new Scanner(System.in))
        {
            System.out.print("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }
}
