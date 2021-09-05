package enumtest;


/**
 * @author junjiang
 * @date 2018.12.4
 */

/**
 * java 枚举类型常见用法
 * 1.常量
 * 2.switch-case
 * 3.添加新的方法-在枚举实例后添加分号(;)
 * 4.覆盖枚举方法-toString()
 * 5.实现接口
 */
public enum Color {

    //颜色-枚举构造方法在此执行
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    Color(String name, int index) {
        this.name = name;
        this.index = index;
        System.out.println("枚举构造函数调用啦~");
    }
    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

    public static void main(String[] args){

        System.out.println(Color.RED);
        Color color = Color.RED;

        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case YELLOW:
                color = Color.RED;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
            default:
                break;
        }

        System.out.println(color.toString());

        Color c1  = Color.RED;
        Color c2  = Color.BLANK;
        Color c3  = Color.YELLOW;
        Color c4  = Color.GREEN;
        Color c5  = Color.GREEN;

        System.out.println(c1.toString()+c2.toString()+c3.toString()+c4.toString()+c5.toString());
    }
}