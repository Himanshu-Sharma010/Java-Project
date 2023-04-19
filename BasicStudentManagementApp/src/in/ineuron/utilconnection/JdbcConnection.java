package in.ineuron.utilconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcConnection {

	
	private  JdbcConnection() {}
	
	static {
		try {
			//load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
              e.printStackTrace();
 		}
	}
	
	
	//Establish the connection of driver with database
	public static Connection getJdbcConnection() throws SQLException, IOException {

		
		HikariConfig config  =new HikariConfig("src\\in\\ineuron\\properties\\SMSapplication.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		
		Connection connection = dataSource.getConnection();
		
		return connection  ;
		
	}
	
	
	
	
	
	
	
}
