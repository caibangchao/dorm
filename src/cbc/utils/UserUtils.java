package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.User;


 
public class UserUtils {
	
	//�����û�ID���޸��û�����
	public void updateUser(User user){
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update users set username=?,password=?,email=? where id = ?";
		Object[] objects = {user.getUsername(),user.getPassword(),user.getEmail(),user.getId()};
		try {
			queryRunner.update(sql, objects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//����IDɾ���û�����
	public void deleteUser(int id){
		String sql = "delete from users where id = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//�����û�����ѯ��Ϣ
	public User findUser(String username){
		String sql = "select *  from users where username=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User user = new User();
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//���������û�
	public List<User> findAll() {
		String sql = "select * from users";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<User> users = new ArrayList<User>();
		try {
		 users = queryRunner.query(sql,
					new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
    //�����û���Ϣ
	public static void insertUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		String sql = "insert into users values(null,?,?,?,null)";

		Object[] objects = { user.getUsername(), user.getPassword(),
				user.getEmail() };

		queryRunner.update(sql, objects);
	}
	
	//����û��������Ƿ���ȷ
	public User checkUser(User user){
		String sql = "select * from users where username=? and password = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] objects = {user.getUsername(),user.getPassword()};
		
			User user1 = new User();
			try {
				user1 = queryRunner.query(sql,
						new BeanHandler<User>(User.class), objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user1;
		
	}
	// �ж��û����Ƿ����
	public static boolean checkUsername(String username) {
		String sql = "select * from users where username = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			User user = queryRunner.query(sql,
					new BeanHandler<User>(User.class), username);
			if (user == null) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	// �ж������Ƿ����
	public static boolean checkEmailExist(String email) {
		String sql = "select * from users where email = ?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			User user = queryRunner.query(sql,
					new BeanHandler<User>(User.class), email);
			if (user == null) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
