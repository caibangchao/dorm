package cbc.utils;



import cbc.model.Student;

public class StudentService {

	public static final int NAMEEXIST = 1; // �����Ѵ���
	public static final int PHONEEXIST = 2; // �ֻ����ѱ��Ǽ�
	public static final int SUCCESS = 0; // �ɹ�

	// ��ӿͻ�
	public int addStudent(Student student) {
		// �ж�ѧ�������Ƿ����
		StudentUtils studentUtils = new StudentUtils();
		boolean isNameExist = studentUtils.checkStudentName(student.getName());
		if (isNameExist) {
			return NAMEEXIST;
		}
		// �ж�ѧ���绰�Ƿ����
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
