package enumtest;

/**
 * Description : 枚举类测试3
 *
 * @author : JunJiang
 * @date : 2021-10-24 18:53
 */
public class EnumTest3 {

    public static void main(String[] args) {
        System.out.println(WeekendEnum3.MONDAY);
        WeekendEnum3.MONDAY.show();
        WeekendEnum3.WEDNESDAY.show();
    }
}

enum WeekendEnum3 implements A{
    /**
     * 星期枚举类
     */
    MONDAY("Monday", "星期一") {
        @Override
        public void show(){
            System.out.println("这是星期一的show方法");
        }
    },
    TUESDAY("Tuesday", "星期二"),
    WEDNESDAY("Wednesday", "星期三"),
    THURSDAY("Thursday", "星期四"),
    FRIDAY("Friday", "星期五"),
    SATURDAY("Saturday", "星期六"),
    SUNDAY("Sunday", "星期日");

    private final String day;
    private final String chinese;

    WeekendEnum3(String day, String chinese) {
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
    public void show() {
        System.out.println("枚举类实现接口的show方法,所有枚举对象共用");
    }
}

interface A {
    void show();
}
