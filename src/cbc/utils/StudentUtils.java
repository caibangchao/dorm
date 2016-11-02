package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.Student;

public class StudentUtils {

	//根据用户ID来修改用户内容
		public void updateStudent(Student student){
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "update student set gender=?,birthday=?,qq=?,phone=?,class_id=?,dorm_id=? where name=?";
			Object[] objects = {student.getGender(),student.getBirthday(),student.getQq(),student.getPhone(),student.getClass_id(),student.getDorm_id(),student.getName()};
			try {
				queryRunner.update(sql, objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		//根据ID删除用户数据
		public void deleteStudent(String name){
			String sql = "delete from student where name = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				queryRunner.update(sql,name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//根据用户名查询信息
		public Student findStudent(String name){
			String sql = "select *  from student where name=?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			Student student = new Student();
			try {
				student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return student;
		}
		
		//查找所有学生信息
		public List<Student> findAll() {
			String sql = "select * from student";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			List<Student> users = new ArrayList<Student>();
			try {
			 users = queryRunner.query(sql,
						new BeanListHandler<Student>(Student.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return users;
		}
		
		
	    //增加学生信息
		public static void insertStudent(Student student){
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

			String sql = "insert into student values(null,?,?,?,?,?,?,?,null)";

			Object[] objects = {student.getName(),student.getGender(),student.getBirthday(),student.getQq(),student.getPhone(),student.getClass_id(),student.getDorm_id()};

			try {
				queryRunner.update(sql, objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		// 判断学生名是否存在
		public static boolean checkStudentName(String name) {
			String sql = "select * from student where name = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				Student student = queryRunner.query(sql,
						new BeanHandler<Student>(Student.class),name);
				if (student == null) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
		}

		// 判断手机号是否存在
		public static boolean checkPhoneExist(String phone) {
			String sql = "select * from student where phone = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				Student student = queryRunner.query(sql,
						new BeanHandler<Student>(Student.class), phone);
				if (student == null) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
		}

	
}
