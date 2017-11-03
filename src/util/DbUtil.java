package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	/**
	 * 取得Connection
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			JdbcConfig jdbcConfig = XmlConfigReader.getInstance().getJdbcConfig();
			//获取oracle驱动的路径
			Class.forName(jdbcConfig.getDriverName());
			// String url = "jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL";
			// 数据库连接，oracle代表连接的是oracle数据库；thin:@MyDbComputerNameOrIP代表的是数据库所在的IP地址（可以保留thin:）；
			//1521代表连接数据库的端口号；ORCL代表的是数据库名称
			conn = DriverManager.getConnection(jdbcConfig.getUrl(), jdbcConfig.getUserName(), jdbcConfig.getPassword());
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	//����
	public static void main(String[] args){
		JdbcConfig jdbcConfig = XmlConfigReader.getInstance().getJdbcConfig();
		System.out.println("���ݿ���������" + jdbcConfig.getDriverName());
		System.out.println("���ݿ�url��" + jdbcConfig.getUrl());
		System.out.println("���ݿ��û�����" + jdbcConfig.getUserName());
		System.out.println("���ݿ����룺" + jdbcConfig.getPassword());
		
		System.out.println(jdbcConfig);
		
		System.out.println(DbUtil.getConnection());		
	}
}
