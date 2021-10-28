package lambda;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description : Lambda 表达式测试2
 * 流的创建操作、流的中间操作、流的终止操作
 *
 * @author : JunJiang
 * @date : 2021-10-22 21:55
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");

        //获取一个顺序流
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        //获取一个并行流 - 速度相对较快
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::println);

    }

    @Test
    public void test2() {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> stream = Arrays.stream(nums);

        stream.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(System.out::println);

        Stream<Integer> stream1 = Stream.iterate(0, x -> x + 2).limit(10);
        stream1.forEach(System.out::println);

        Stream<Double> stream2 = Stream.generate(Math::random).limit(10);
        stream2.forEach(System.out::println);
    }

    @Test
    public void test4() throws FileNotFoundException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Light_up/Desktop/Notes.txt"));
        Stream<String> lineStream = bf.lines();
        lineStream.forEach(System.out::println);
    }

    @Test
    @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
    public void test5() {
        // 测试方法忽略Java开发手册提示的错误
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }

    @Test
    public void test6() {
        Stream<Integer> stream = Stream.of(12, 34, 56, 78, 90, 34, 63, 24, 52, 12, 56, 32);
        stream.filter(x -> x > 30).map(x -> x * 10).distinct().sorted((x, y) -> y - x).limit(6).forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(list.stream().allMatch(x -> x > 10));
        System.out.println(list.stream().noneMatch(x -> x > 10));
        System.out.println(list.stream().anyMatch(x -> x > 4));

        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());

        System.out.println(list.stream().count());
        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());
    }

    @Test
    public void test8() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        System.out.println(list.stream().reduce((x1, x2) -> x1 + x2).get());
        System.out.println(list.stream().reduce(10, (x1, x2) -> x1 * x2));
    }

    @Test
    public void test9() {
        Student s1 = new Student("aa", 10, 1);
        Student s2 = new Student("bb", 20, 2);
        Student s3 = new Student("cc", 10, 3);
        List<Student> list = Arrays.asList(s1, s2, s3);

        list.stream().map(Student::getAge).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().map(Student::getAge).collect(Collectors.toSet()).forEach(System.out::println);
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        list.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));

        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get());
        System.out.println(list.stream().collect(Collectors.summingInt(Student::getAge)));

        System.out.println(list.stream().collect(Collectors.averagingDouble(Student::getAge)));
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

        //分组
        Map<Integer, List<Student>> ageMap = list.stream().collect(Collectors.groupingBy(Student::getAge));
        //多重分组,先根据类型分再根据年龄分
        Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));

        //分区
        Map<Boolean, List<Student>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));

        //规约
        System.out.println(list.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get());
    }

}

class Student {
    private String name;
    private int age;
    private int type;

    public Student() {

    }

    public Student(String name, int age, int type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

