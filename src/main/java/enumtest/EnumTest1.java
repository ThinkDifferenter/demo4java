package enumtest;


/**
 * Description : 枚举类测试1
 *
 * @author : JunJiang
 * @date : 2021-10-24 18:17
 */
public class EnumTest1 {

    public static void main(String[] args) {
        System.out.println(WeekendEnum1.MONDAY);
        System.out.println(WeekendEnum1.MONDAY.getDay() + WeekendEnum1.MONDAY.getChinese());
    }
}

/**
 * 自定义枚举类，java5之前针没有enum关键字
 */
class WeekendEnum1 {
    private final String day;
    private final String chinese;

    public static final WeekendEnum1 MONDAY = new WeekendEnum1("Monday", "星期一");
    public static final WeekendEnum1 TUESDAyer = new WeekendEnum1("Tuesday", "星期二");
    public static final WeekendEnum1 WEDNESDAY = new WeekendEnum1("Wednesday", "星期三");
    public static final WeekendEnum1 THURSDAY = new WeekendEnum1("Thursday", "星期四");
    public static final WeekendEnum1 FRIDAY = new WeekendEnum1("Friday", "星期五");
    public static final WeekendEnum1 SATURDAY = new WeekendEnum1("Saturday", "星期六");
    public static final WeekendEnum1 SUNDAY = new WeekendEnum1("Sunday", "星期日");

    private WeekendEnum1(String day, String chinese) {
        this.day = day;
        this.chinese = chinese;
    }

    public String getDay() {
        return day;
    }

    public String getChinese() {
        return chinese;
    }

    @Override
    public String toString() {
        return "WeekendEnum1{" +
                "day='" + day + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}