package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlConnect {
	public Connection conn = null;
	public PreparedStatement pst = null;

	public MysqlConnect(String sql) throws Exception {  
		String url = GetProperties.getProperties("url");
		String name = GetProperties.getProperties("driver");
		String user = GetProperties.getProperties("musername");
		String password = GetProperties.getProperties("mpassword");
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
}
}
