package annotationunderstand;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author junjiang
 * @date 2019.4.2
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnTargetType {
    /**
     * 定义注解的一个元素 并给定默认值
     */
    String value() default "我是定义在类接口枚举类上的注解元素value的默认值";
}
