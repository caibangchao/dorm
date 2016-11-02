package cbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource dataSource = new ComboPooledDataSource();
	
	
	//�������ӳ�
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	
	//�ṩDBUtils �ֶ���������ʹ��
	public static Connection getConnection() throws SQLException{

			return dataSource.getConnection();
	
	}
}