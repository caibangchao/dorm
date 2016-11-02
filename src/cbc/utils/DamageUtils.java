package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.Damage;

public class DamageUtils {
	
	//��������ID���޸�������
		public void updateDamage(Damage damage){
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "update damage set fi_date=?,remarks=?,isok=? where dorm_id=?";
			Object[] objects = {damage.getFi_date(),damage.getRemarks(),damage.getIsok(),damage.getDorm_id()};
			try {
				queryRunner.update(sql, objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
 
	//�������������
		public List<Damage> findAll() {
			String sql = "select * from damage";
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			List<Damage> damages = new ArrayList<Damage>();
			try {
			 damages = queryRunner.query(sql,
						new BeanListHandler<Damage>(Damage.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return damages;
		}
		
		//���������
		public static void insertDamage(Damage damage) throws SQLException {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

			String sql = "insert into damage values(null,?,?,null,?,?,?,null)";

			Object[] objects = {damage.getQuestion(),damage.getSt_date(),damage.getRemarks(),"δ�޸�",damage.getDorm_id()};

			queryRunner.update(sql, objects);
		}
		
	
}
