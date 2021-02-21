package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	
	private  BasicDataSource dataSource=null;
	
	private  BasicDataSource getDataSource() {
		if(dataSource==null) {
			dataSource=new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/HolaMySQL?useTimezone=true&serverTimezone=UTC");
			dataSource.setUsername("root");
			dataSource.setPassword("admin");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

}
