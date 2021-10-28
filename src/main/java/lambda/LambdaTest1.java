package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description : Lambda表达式测试1
 *
 * @author : JunJiang
 * @date : 2021-10-22 19:56
 */
public class LambdaTest1 {

    @Test
    public void test1(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        // 增强for循环
        for (Object feature : features) {
            System.out.print(feature);
        }

        System.out.println("\n***********************");

        // lambda表达式
        features.forEach(x-> System.out.print(" "+x));
    }
}
