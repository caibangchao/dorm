package cbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource dataSource = new ComboPooledDataSource();
	
	
	//返回连接池
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	
	//提供DBUtils 手动控制事务使用
	public static Connection getConnection() throws SQLException{

			return dataSource.getConnection();
	
	}
}
