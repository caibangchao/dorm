package cbc.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cbc.model.Visitor;

public class VisitorUtils {

	// 查看所有访客情况
	public List<Visitor> findAll() {
		String sql = "select * from visitor";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		List<Visitor> damages = new ArrayList<Visitor>();
		try {
			damages = queryRunner.query(sql, new BeanListHandler<Visitor>(
					Visitor.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return damages;
	}

	// 增加损坏情况
	public static void insertVisitor(Visitor visitor) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

		String sql = "insert into visitor values(null,?,?,?,?,?,null)";

		Object[] objects = { visitor.getName(), visitor.getAddress(),
				visitor.getRelation(), visitor.getStudent_name(),
				visitor.getDorm_id() };

		queryRunner.update(sql, objects);
	}

}
