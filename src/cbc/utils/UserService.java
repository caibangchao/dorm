package cbc.utils;

import java.sql.SQLException;

import cbc.model.User;

public class UserService {
	public static final int NAMEEXIST = 1; // 姓名已存在
	public static final int EMAILEXIST = 2; // 邮箱已存在
	public static final int SUCCESS = 0; // 成功

	// 添加客户
	public int addUser(User user) {
		// 判断客户姓名是否存在
		UserUtils userUtils = new UserUtils();
		boolean isNameExist = UserUtils.checkUsername(user.getUsername());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// 判断邮箱是否存在
		boolean isEmailExist = UserUtils.checkEmailExist(user.getEmail());
		if (isEmailExist) {
			return EMAILEXIST;
		}

		// 插入数据库
		try {
			UserUtils.insertUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
}
