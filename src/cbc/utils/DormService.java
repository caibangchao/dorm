package cbc.utils;

import java.sql.SQLException;

import cbc.model.Dorm;

public class DormService {
	public static final int NAMEEXIST = 1; // 名字已存在
	public static final int IDEXIST = 2; // ID已存在
	public static final int SUCCESS = 0; // 成功

	// 添加客户
	public int addDorm(Dorm dorm){
		// 判断客户姓名是否存在
		DormUtils dormUtils = new DormUtils();
		boolean isNameExist = dormUtils.checkDormname(dorm.getName());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// 判断邮箱是否存在
		boolean isIdExist = dormUtils.checkDormid(dorm.getId());
		if (isIdExist) {
			return IDEXIST;
		}
        DormUtils.insertDorm(dorm);
		return SUCCESS;
	}
	
	
}
