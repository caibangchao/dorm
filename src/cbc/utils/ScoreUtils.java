package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.Score;

public class ScoreUtils {

	// �鿴���������������ҵ÷֣���С��������
	public List<Score> findAll() {
		String sql = "select * from score order by score_sum";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Score> scores = new ArrayList<Score>();
		try {
			scores = queryRunner.query(sql, new BeanListHandler<Score>(
					Score.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scores;
	}

	// ������������ID������
	public static void insertScore(Score score) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		String sql = "insert into score values(null,?,?,?,?,?,?,null)";

		Object[] objects = { score.getDorm_id(), score.getNeat(),
				score.getClear(), score.getSmell(), score.getDiscipline(),
				score.getScore_sum()};

		queryRunner.update(sql, objects);
	}
    
	
	  //ɾ�����б������ݣ���ձ������ȷ���
	public void deleteAll() {
		String sql = "delete from score";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			queryRunner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
