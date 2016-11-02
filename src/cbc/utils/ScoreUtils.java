package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.Score;

public class ScoreUtils {

	// 查看本次评比所有寝室得分，由小到大排序
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

	// 增加评分寝室ID及分数
	public static void insertScore(Score score) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		String sql = "insert into score values(null,?,?,?,?,?,?,null)";

		Object[] objects = { score.getDorm_id(), score.getNeat(),
				score.getClear(), score.getSmell(), score.getDiscipline(),
				score.getScore_sum()};

		queryRunner.update(sql, objects);
	}
    
	
	  //删除所有表中数据，清空本次评比分数
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
