package getforname;

/**
 * 描述: 我的类型
 *
 * @author junjiang
 * @date 2020-03-17 15:54
 */
public class MyClass {

    private String name;
    private int age;
    private int[] number;
    private double money;

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

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClass c = new MyClass();
        Class s = c.getClass();
        System.out.println(s.toString());
        System.out.println(s.toGenericString());
        System.out.println(c.getClass());

        System.out.println("=======================================");
        System.out.println(int.class);
        System.out.println(double[].class);
        System.out.println(MyClass.class);

        System.out.println("=======================================");
        System.out.println(Class.forName("java.lang.Thread").getName());
        System.out.println(Class.forName("getforname.MyClass").getName());
        System.out.println();
        System.out.println();

    }
}