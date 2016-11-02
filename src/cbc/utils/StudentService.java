package cbc.utils;



import cbc.model.Student;

public class StudentService {

	public static final int NAMEEXIST = 1; // 姓名已存在
	public static final int PHONEEXIST = 2; // 手机号已被登记
	public static final int SUCCESS = 0; // 成功

	// 添加客户
	public int addStudent(Student student) {
		// 判断学生姓名是否存在
		StudentUtils studentUtils = new StudentUtils();
		boolean isNameExist = studentUtils.checkStudentName(student.getName());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// 判断学生电话是否存在
		boolean isPhoneExist = studentUtils.checkPhoneExist(student.getPhone());
		if (isPhoneExist) {
			return PHONEEXIST;
		}

		try {
			StudentUtils.insertStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
}
