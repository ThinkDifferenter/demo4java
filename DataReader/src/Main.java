import java.sql.*;

/**
 * @author  jiangjun
 * @date 2018.10.17
 */
public class Main {

    public static void getConnection() throws Exception
    {
            Connection conn = null;
            try { Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/test?" + "user=root&password=123456" +
                     "&useUnicode=true&characterEncoding=UTF8" + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
             conn = DriverManager.getConnection(url);
            }catch (ClassNotFoundException e){
                System.out.println("JDBC Driver not found"); e.printStackTrace();
            }catch (SQLException e){
                System.out.println("SQL 执行错误");
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("连接成功!");
    }

    public static void main(String[] args){
        try {
            Main.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
