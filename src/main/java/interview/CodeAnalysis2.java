package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * Description : 代码分析2
 *
 * @author : JunJiang
 * @date : 2021-10-26 18:24
 */
@SuppressWarnings("Duplicates")
public class CodeAnalysis2 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person(1001, "Tom");
        Person p2 = new Person(1002, "Jerry");
        set.add(p1);
        set.add(p2);
        set.forEach(System.out::println);
        System.out.println("******************");

        /**
         * 通过引用p1可直接修改p1中的字段，但此时，HashSet已经通过p1的初始数据计算出该对象存储的位置
         * 修改p1对象字段的数据不会改变其在HashSet中的存储位置。
         *
         * 通过修改数据后的p1去做remove操作时，HashSet会先去计算该对象的hash值，若hash值相等再通过equals方法
         * 判断是否相等。由于p1修改过，所以根据计算出来的hash值去对应位置上查看，发现没有可移除的对象，故remove
         * 操作没有移除集合中的任何元素。
         */
        p1.setName("Tony");
        set.remove(p1);
        set.forEach(System.out::println);
        System.out.println("******************");

        /**
         * 此时再添加Tony对象，HashSet会根据Tony对象计算出对应的hash值，去确定Tony对象存储的位置，p1对象虽然name字段被修改为Tony
         * 但是，该对象的初始存储位置是通过Tom对象计算出来的，故新的Tony对象能够成功添加。
         */
        set.add(new Person(1001,"Tony"));
        set.forEach(System.out::println);
        System.out.println("******************");

        /**
         * 同样的，向HashSet中添加对象时，会先计算hash值，若hash值相同，会通过equals做进一步判断。这里添加Tom对象，与最初添加的Tom
         * 对象完全一样，故计算所得hash值与修改为Tony对象相同，因此会进一步判断两者是否相同。由于初始的Tom对象被修改为Tony，新添加的Tom
         * 对象与之不等，故新Tom对象能够成功添加。
         */
        set.add(new Person(1001, "Tom"));
        set.forEach(System.out::println);
    }
}

class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}