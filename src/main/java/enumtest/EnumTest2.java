package enumtest;

import java.util.Arrays;

/**
 * Description : 枚举类测试2
 *
 * @author : JunJiang
 * @date : 2021-10-24 18:35
 */
public class EnumTest2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(WeekendEnum2.values()));
        System.out.println(WeekendEnum2.valueOf("MONDAY"));
        System.out.println(Arrays.toString(WeekendEnum2.class.getEnumConstants()));
        System.out.println(WeekendEnum2.MONDAY.getClass().getSuperclass());
        System.out.println(WeekendEnum2.class.getSuperclass());
    }
}

/**
 * Java5及之后，针对枚举类提出enum关键字，简化了自定义枚举类的流程，并提供了枚举类相关的支持方法
 */
enum WeekendEnum2 {
    /**
     * 星期枚举类
     */
    MONDAY("Monday", "星期一"),
    TUESDAY("Tuesday", "星期二"),
    WEDNESDAY("Wednesday", "星期三"),
    THURSDAY("Thursday", "星期四"),
    FRIDAY("Friday", "星期五"),
    SATURDAY("Saturday", "星期六"),
    SUNDAY("Sunday", "星期日");

    private final String day;
    private final String chinese;

    WeekendEnum2(String day, String chinese) {
        this.day = day;
        this.chinese = chinese;
    }

    public String getDay() {
        return day;
    }

    public String getChinese() {
        return chinese;
    }
}
