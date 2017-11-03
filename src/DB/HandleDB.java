package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by dinglp on 2017/10/25.
 */
public class HandleDB {

    private  String SQL = "";

    public boolean InsertData(String name, String password){

        SQL = "SELECT * FROM AccountData WHERE name = ? and password = ?";

        Connection connection = null;

        /*

        PreparedStatement是什么？
        PreparedStatement也叫预编译声明！
        PreparedStatement是Statement的子接口，你可以使用PreparedStatement来替换Statement。
        PreparedStatement的好处：
        防止SQL攻击；
        提高代码的可读性，以可维护性；
         提高效率。
         */


        PreparedStatement astatement = null;
        ResultSet rs = null;
        try {
            //2.得到连接
            connection = ConnectDB.getConnection();
            //3.创建PreparedStatment 用于传送sql查询语句
            astatement = connection.prepareStatement(SQL);
            //给？赋值
            astatement.setString(1,name);
            astatement.setString(2,password);
            // 执行sql
            rs = astatement.executeQuery();
            if (rs.next()){

                //合法
            }else {


            }

            rs.close();
            astatement.close();

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            ConnectDB.closeConnection(connection);

        }
        return true;

    }

    public  boolean InsertServletParmData(String name, Boolean sex, String birthday ,String address){

        System.out.print("-----------------");
        System.out.print(name);

        System.out.print("-----------------");

        SQL = "INSERT INTO dinglpTable (name , sex , birthday , address) VALUES (? , ? , ?, ?)";

        Connection connection = null;
        PreparedStatement astatement = null;
        int rs = 0;
        try {
            //2.得到连接
            connection = ConnectDB.getConnection();
            //3.创建PreparedStatment 用于传送sql查询语句
            astatement = connection.prepareStatement(SQL);
            //给？赋值
            astatement.setString(1,name);
            astatement.setBoolean(2,sex);
            astatement.setString(3,birthday);
            astatement.setString(4,address);
            // 执行sql
            rs = astatement.executeUpdate();
            if (rs==1){
                return true;

                //合法
            }else {

                return false;

            }

//            astatement.close();

        }catch (Exception e){
            e.printStackTrace();

        }finally {

            ConnectDB.closeConnection(connection);

        }
        return false;

    }



    public boolean CreateFromTable(String name, String sex, String birthday ,String address){

        SQL = "SELECT * FROM dinglpFrom WHERE name = ? and sex = ? and birthday = ? and address = ?";



        Connection connection = null;

        /*

        PreparedStatement是什么？
        PreparedStatement也叫预编译声明！
        PreparedStatement是Statement的子接口，你可以使用PreparedStatement来替换Statement。
        PreparedStatement的好处：
        防止SQL攻击；
        提高代码的可读性，以可维护性；
         提高效率。
         */


        return true;

    }


}
