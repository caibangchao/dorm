package cbc.utils;

import java.sql.SQLException;

import cbc.model.User;

public class UserService {
	public static final int NAMEEXIST = 1; // �����Ѵ���
	public static final int EMAILEXIST = 2; // �����Ѵ���
	public static final int SUCCESS = 0; // �ɹ�

	// ��ӿͻ�
	public int addUser(User user) {
		// �жϿͻ������Ƿ����
		UserUtils userUtils = new UserUtils();
		boolean isNameExist = UserUtils.checkUsername(user.getUsername());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// �ж������Ƿ����
		boolean isEmailExist = UserUtils.checkEmailExist(user.getEmail());
		if (isEmailExist) {
			return EMAILEXIST;
		}

		// �������ݿ�
		try {
			UserUtils.insertUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
}
