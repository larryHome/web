package kr.co.intune.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/intune2", "intuneDev", "intune1234");
		return c;
	}

}
