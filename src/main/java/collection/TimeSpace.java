package collection;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author junjiang
 * @date 2018.10.26
 */
public class TimeSpace {

    /**
     * 小时时间差计算
     * @param args
     */
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(new Date());
        String update = "2018-10-25 10:47:00";
        System.out.println("当前时间为:" + now);

        try{
            //时间间隔获取
            long to = sdf.parse(now).getTime();
            long from = sdf.parse(update).getTime();
            int cMinute = (int) ((to - from)/(1000 * 60 ));
            float cHour = (float)  cMinute/60;

            System.out.println("小时："+cHour);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


