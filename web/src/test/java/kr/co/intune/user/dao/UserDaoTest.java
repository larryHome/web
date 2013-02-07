package kr.co.intune.user.dao;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import kr.co.intune.user.domin.User;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		NUserDao userDao = new NUserDao();
		User user = new User();
		user.setId("Larry");
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
