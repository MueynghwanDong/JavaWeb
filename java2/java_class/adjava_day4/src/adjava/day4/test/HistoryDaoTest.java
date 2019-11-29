package adjava.day4.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import adjava.day4.dao.HistoryDao;
import adjava.day4.dao.HistoryDaoImpl;
import adjava.day4.dto.History;
import adjava.day4.util.DBUtil;

public class HistoryDaoTest {
	HistoryDao hdao = HistoryDaoImpl.getImpl();
	public static void main(String[] args) throws SQLException {
		HistoryDaoTest hdt = new HistoryDaoTest();
//		hdt.insertTest();
		hdt.selectTest();
	}
	
	public void insertTest() throws SQLException {
		History history = new History("hong", "입금", 100);
		Connection con = DBUtil.getUtil().getConnection();
		int result = hdao.insert(con, history);
		System.out.println(result);
	}
	
	public void selectTest() throws SQLException {
		Connection con = DBUtil.getUtil().getConnection();
		List<History> list = hdao.getHistoryByUser(con, "hong");
		
		for(History h : list) {
			System.out.println(h);
		}
	}
}
