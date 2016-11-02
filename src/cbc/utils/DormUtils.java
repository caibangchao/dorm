package cbc.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cbc.model.Dorm;

public class DormUtils {
	
	//根据寝室ID删除寝室数据
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
		
		
	//根据寝室ID来修改内容
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
	
	
	//根据ID查询信息
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
	
	
	
	
	//增加宿舍信息
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
	
   
	// 判断id是否存在
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

		// 判断邮箱是否存在
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
