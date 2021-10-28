package annotation;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.annotation.ElementType.*;

/**
 * Description : 接口测试
 *
 * @author : JunJiang
 * @date : 2021-10-25 11:22
 */
@MyAnnotation(value = "Hi")
@MyAnnotation(value = "XiaoCuiEr")
public class AnnotationTest {
    @MyAnnotation
    public static void main(String[] args) {
        List<@MyAnnotation String> list = new ArrayList<>();
        int i = (@MyAnnotation int) 10L;

        // 利用反射获取注解信息并进行相应的处理
        System.out.println(Arrays.toString(AnnotationTest.class.getAnnotations()));

        // 获取class对象的方式：类.class & 实例对象.getClass()
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.getClass().getAnnotations();
    }
}

/**
 * @author JiangJun
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    String value() default "hello";
}

/**
 * @author JiangJun
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotations{
    MyAnnotation[] value();
}
