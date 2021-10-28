package compare;

import lombok.SneakyThrows;

import java.util.*;

/**
 * Description : 比较测试1
 *
 * @author : JunJiang
 * @date : 2021-10-23 18:12
 */
public class CompareTest1 {

    public static void main(String[] args){
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student(21, "A", 172.3f);
        Student student2 = new Student(23, "B", 172.3f);
        Student student3 = new Student(19, "C", 172.3f);
        Student student4 = new Student(12, "D", 172.3f);
        Student student5 = new Student(17, "E", 172.3f);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        studentList.stream().sorted().forEach(System.out::println);
        System.out.println("*********************");

        Collections.sort(studentList, new Comparator<Student>() {
            @SneakyThrows
            @Override
            public int compare(Student o1, Student o2) {
                if (o1 != null && o2 != null) {
                    return -Integer.compare(o1.getAge(), o2.getAge());
                }else {
                    throw new Exception();
                }
            }
        });
        studentList.forEach(System.out::println);

    }
}

class Student implements Comparable<Student> {
    private int age;
    private String name;
    private float height;

    public Student() {
    }

    public Student(int age, String name, float height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public int compareTo(Student o) {
        if (null == o) {
            throw new NullPointerException();
        }

        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}

