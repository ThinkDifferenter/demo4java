package innerclass;

public class Circle {

    private double radius = 0;
    public static int count =1;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Draw getInnerInstance(){
        return new Draw();
    }

    //外部类访问内部类数据只能通过创建内部类对象来获取
    public int getInnerNum(){
        Circle circle = new Circle(0.68);
        Circle.Draw draw =  circle.getInnerInstance();
        return draw.num;
    }


    //成员内部类
    class Draw {
        private int num = 0;

        public void drawSahpe() {
            //外部类的private成员
            System.out.println(radius);

            //外部类的静态成员
            System.out.println(count);
        }
    }

    public static void main(String[] args){
        Circle circle = new Circle(3.14);
        Circle.Draw draw = circle.new Draw();
        draw.drawSahpe();

        Circle.Draw draw1 = circle.getInnerInstance();
        draw1.num=1;

        System.out.println(draw1.num);
    }
}
