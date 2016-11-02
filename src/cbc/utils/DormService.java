package cbc.utils;

import java.sql.SQLException;

import cbc.model.Dorm;

public class DormService {
	public static final int NAMEEXIST = 1; // �����Ѵ���
	public static final int IDEXIST = 2; // ID�Ѵ���
	public static final int SUCCESS = 0; // �ɹ�

	// ��ӿͻ�
	public int addDorm(Dorm dorm){
		// �жϿͻ������Ƿ����
		DormUtils dormUtils = new DormUtils();
		boolean isNameExist = dormUtils.checkDormname(dorm.getName());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// �ж������Ƿ����
		boolean isIdExist = dormUtils.checkDormid(dorm.getId());
		if (isIdExist) {
			return IDEXIST;
		}
        DormUtils.insertDorm(dorm);
		return SUCCESS;
	}
	
	
}
