package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
/**
 * 采用单例解析sys-config.xml文件
 * @author liang
 *
 */
public class XmlConfigReader {

	//单例懒汉式（延迟加载lazy）
	//设置为空，使用在new，不用不new
	private static XmlConfigReader instance = null;

	//定义JdbcConfig成员变量，保存jdbc相关配置信息
	private JdbcConfig jdbcConfig = new JdbcConfig();;
	
	private XmlConfigReader(){
		//创建saxReader对象
		SAXReader reader = new SAXReader();
		//通过当前线程的类加载器，获得文件的相对路径，将xml文件读入到输入流
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-config.xml");
		try {
			// 通过read方法读取xml文件， 转换成Document对象
			Document doc = reader.read(in);

			//获得节点对象，取得jdbc相关的配置信息
			Element driverNameElt = (Element)doc.selectObject("/config/db-info/driver-name");	
			Element urlElt = (Element)doc.selectObject("/config/db-info/url");
			Element userNameElt = (Element)doc.selectObject("/config/db-info/user-name");
			Element passwordElt = (Element)doc.selectObject("/config/db-info/password");

			//设置jdbc相关的配置
			jdbcConfig.setDriverName(driverNameElt.getStringValue());
			jdbcConfig.setUrl(urlElt.getStringValue());
			jdbcConfig.setUserName(userNameElt.getStringValue());
			jdbcConfig.setPassword(passwordElt.getStringValue());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 加锁，实现多线程的同步机制，防止多线程的访问冲突
	 * @return
	 */
	public static synchronized XmlConfigReader getInstance(){
		if(instance == null){			
			instance = new XmlConfigReader();
		}
		return instance;
	}
	/**
	 * 返回jdbc的相关配置
	 * @return
	 */
	public JdbcConfig getJdbcConfig(){
		return jdbcConfig;
	}
	
	//����
	public static void main(String[] args) {
		
		JdbcConfig jdbcConfig = XmlConfigReader.getInstance().getJdbcConfig();
		System.out.println("���ݿ���������" + jdbcConfig.getDriverName());
		System.out.println("���ݿ�url��" + jdbcConfig.getUrl());
		System.out.println("���ݿ��û�����" + jdbcConfig.getUserName());
		System.out.println("���ݿ����룺" + jdbcConfig.getPassword());
		
		System.out.println(jdbcConfig);

	}

}
