package reflect;

/**
 * 描述: 反射测试类
 *
 * @author junjiang
 * @date 2020-03-18 14:02
 */
public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
    public Student() {
        System.out.println("实例化一个对象！");

    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    
}