package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述: 主测试类
 *
 * @author junjiang
 * @date 2020-03-18 13:50
 */
public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException,
            SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

        // 普通方法创建一个对象
//        Student stu = new Student();
        // 利用反射机制创建一个对象
        Student newInstance = Student.class.newInstance();
        // 通过字节码获取属性
        Class clazz = Student.class;

        // 指定返回一个公有的属性
        System.out.println("=============指定返回一个公有的属性===============");
        Field field = clazz.getDeclaredField("name");
        System.out.println("属性的名称:" + field.getName());
        System.out.println("属性的类型：" + field.getType().getName());

        // 获取一个类中的所有属性
        System.out.println("=============获取一个类中的所有属性===============");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("属性的名称:" + f.getName());
            System.out.println("属性的类型：" + f.getType().getName());
            // 给属性赋值 设置为私有属性可以访问
            f.setAccessible(true);

            if (int.class == f.getType()) {
                f.set(newInstance, 50);
            } else if (String.class == f.getType()) {
                f.set(newInstance, "蔡徐坤");
            }
        }
        System.out.println("========通过直接赋值后的结果==========");
        System.out.println(newInstance);

        // 获取所有方法 不包括构造方法
        System.out.println("========获取所有方法(不包括构造方法)==========");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 参数名称
            String methodName = method.getName();
            // 参数个数
            int parameterCount = method.getParameterCount();
            System.out.println("方法名字:" + methodName);
            System.out.println("方法参数个数:" + parameterCount);
            Class<?>[] parameterTypes = method.getParameterTypes();
            // 获取每个方法的参数类型
            for (Class<?> class1 : parameterTypes) {
                System.out.println("参数类型:" + class1.getName());
            }

            // 获取方法的返回值
            Class<?> returnType = method.getReturnType();
            System.out.println("方法的返回值为：" + returnType.getName());
            System.out.println("-------------------");
        }

        // 返回当前Class对象表示的类或接口的指定已说明的一个方法对象。
        System.out.println("==========设值注入=========");
        Method declaredMethod = clazz.getDeclaredMethod("setName", String.class);
        declaredMethod.invoke(newInstance, "马云");
        System.out.println(newInstance);

        // 构造函数
        System.out.println("==========构造注入=========");
        Constructor constructor = clazz.getConstructor(new Class[] { String.class, int.class });
        // 如何执行构造函数
        Object obj = constructor.newInstance(new Object[] { "周杰伦", 46 });
        System.out.println(obj);

        System.out.println("==========构造方法=========");
        //获取所有的构造函数
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            if(c.getParameterCount() != 0){
                Class[] parameterTypes = c.getParameterTypes();
                for (Class class1 : parameterTypes) {
                    System.out.println("参数类型："+class1.getTypeName());
                }
                System.out.println("-------------------");
            }else{
                System.out.println("无参构造");
                System.out.println("-------------------");
            }
        }
    }
}