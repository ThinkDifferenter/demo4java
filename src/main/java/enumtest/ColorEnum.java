package enumtest;

public enum ColorEnum implements Behaviour {

    //颜色-枚举构造方法在此执行
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    /**
     * 构造方法
      * @param name
     * @param index
     * @return
     **/
    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index+":"+this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }

    public static void main(String[] args){
        ColorEnum.RED.print();
        System.out.println(RED.getInfo());
    }
}
