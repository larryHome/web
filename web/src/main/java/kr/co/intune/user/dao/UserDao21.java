package kr.co.intune.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.intune.user.domin.User;

public class UserDao21 {
	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/intune", "intuneDev", "intune1234");
//		Connection c = getConnection();

		PreparedStatement ps = c
				.prepareStatement("insert into users(id, name,password) values (?,?,?)");

		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();

		c.close();

	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/intune", "intuneDev", "intune1234");
//		Connection c = getConnection();

		PreparedStatement ps = c
				.prepareStatement("select * from users where id = ?");

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		rs.next();

		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/intune", "intuneDev", "intune1234");
		return c;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		UserDao21 userDao = new UserDao21();
		User user = new User();
		user.setId("Larry1");
		user.setName("석창화");
		user.setPassword("12341234");

		userDao.add(user);

		System.out.println(user.getId() + "등록 성공");

		User user2 = userDao.get(user.getId());

		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 성공");

	}
}
