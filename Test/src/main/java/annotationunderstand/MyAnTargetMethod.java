package annotationunderstand;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author junjiang
 * @date 2019.4.2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetMethod {
    String value() default "我是定义在方法上的注解元素value的默认值";
}
