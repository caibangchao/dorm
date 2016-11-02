package cbc.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cbc.model.Dorm;

public class DormUtils {
	
	//��������IDɾ����������
		public void deleteDorm(String id){
			String sql = "delete from dorm where id = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				queryRunner.update(sql, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	//��������ID���޸�����
	public void updateDorm(Dorm dorm){
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update dorm set name=?,bedsum=?,usedbed=?,houseparent=?,remarks=? where id=?";
		Object[] objects = {dorm.getName(),dorm.getBedsum(),dorm.getUsedbed(),dorm.getHouseparent(),dorm.getRemarks(),dorm.getId()};
		try {
			queryRunner.update(sql, objects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//����ID��ѯ��Ϣ
		public Dorm findDorm(String id){
			String sql = "select *  from dorm where id=?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			Dorm dorm = new Dorm();
			try {
				dorm = queryRunner.query(sql, new BeanHandler<Dorm>(Dorm.class),id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dorm;
		}
	
	
	
	
	//����������Ϣ
		public static void insertDorm(Dorm dorm) {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

			String sql = "insert into dorm values(?,?,?,?,?,?,null)";

			Object[] objects = {dorm.getId(),dorm.getName(),dorm.getBedsum(),dorm.getUsedbed(),dorm.getHouseparent(),dorm.getRemarks()};
     
			try {
				queryRunner.update(sql, objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
   
	// �ж�id�Ƿ����
		public static boolean checkDormid(String id) {
			String sql = "select * from dorm where id = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				Dorm dorm = queryRunner.query(sql,
						new BeanHandler<Dorm>(Dorm.class), id);
				if (dorm == null) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
		}

		// �ж������Ƿ����
		public static boolean checkDormname(String name) {
			String sql = "select * from dorm where name = ?";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			try {
				Dorm dorm = queryRunner.query(sql,
						new BeanHandler<Dorm>(Dorm.class), name);
				if (dorm == null) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return true;
		}
	
}
