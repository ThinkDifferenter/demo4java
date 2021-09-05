package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

    @Test
    public void beforeJavaEight(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }
    }

    @Test
    public void afterJavaEight(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
        System.out.println("==============Anther lambda demo================");
        features.forEach(System.out::println);
    }
}
