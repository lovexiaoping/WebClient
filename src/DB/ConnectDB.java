package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dinglp on 2017/10/25.
 */

public class ConnectDB {

    private static String USER = "root";
    private static String PASSWORD = "123456";

//    该段代码建立数据库链接，注释代码在数据库插入中文数据会显示乱码，在mydb后添加”?useUnicode=true&amp;characterEncoding=utf-8”即可解决
    private static String DB_URL = "jdbc:mysql://localhost:3306/dinglpFrom?useUnicode=true&characterEncoding=utf-8";
    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    //  private static String SQL = "";
    private static Connection connection = null;

    public  static Connection getConnection(){

        try {
            // 加载数据库驱动，注册到驱动管理器
            Class.forName(DB_DRIVER);
            // 创建Connection连接
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);


        } catch (Exception e){
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return  connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){

            try{
                connection.close();
            }catch (SQLException E){
                E.printStackTrace();
            }
        }

    }
}
