package annotationunderstand;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author junjiang
 * @date 2019.4.2
 */
@MyAnTargetType
public class AnnotationTest {

    @MyAnTargetField
    private String file = "我是字段";

    @MyAnTargetMethod
    public void test(@MyAnTargetParameter String args) {
        System.out.println("参数值 === "+args);
    }

    public static void  main(String[] args ){
        // 获取类上的注解MyAnTargetType
        MyAnTargetType t = AnnotationTest.class.getAnnotation(MyAnTargetType.class);
        System.out.println("1.类上的注解值 === "+t.value());

        MyAnTargetMethod tm = null;
        try{
            // 根据反射获取AnnotationTest类上的test方法
            Method method = AnnotationTest.class.getDeclaredMethod("test",String.class);
            // 获取方法上的注解MyAnTargetMethod
            tm = method.getAnnotation(MyAnTargetMethod.class);
            System.out.println("2.方法上的注解值 === "+tm.value());
            Annotation[][] annotations = method.getParameterAnnotations();
            for(Annotation[] tt : annotations){
                for(Annotation t1:tt){
                    if(t1 instanceof MyAnTargetParameter){
                        System.out.println("3.参数上的注解值 === "+((MyAnTargetParameter) t1).value());
                    }
                }
            }
            method.invoke(new AnnotationTest(), "改变默认参数");
            // 获取AnnotationTest类上字段field的注解MyAnTargetField
            MyAnTargetField fieldAn = AnnotationTest.class.getDeclaredField("field").getAnnotation(MyAnTargetField.class);
            System.out.println("4.字段上的注解值 === "+fieldAn.value());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
