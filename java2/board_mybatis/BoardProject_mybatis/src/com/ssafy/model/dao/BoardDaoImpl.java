package com.ssafy.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public class BoardDaoImpl implements BoardDao {
	private final String ns = "com.ssafy.mapper.BoardMapper.";
	
	private static BoardDaoImpl impl = new BoardDaoImpl();
	public static BoardDaoImpl getImpl() {
		return impl;
	}
	private BoardDaoImpl() {}
	
	@Override
	public int getBoardNo(SqlSession session) {
		String stmt = ns+"getMax";
		return session.selectOne(stmt);
	}

	@Override
	public int insertBoard(SqlSession session, Board board) {
		String stmt = ns+"insert";
		return session.insert(stmt, board);
		
	}

	@Override
	public Board search(SqlSession session, String no) {
		String stmt = ns+"select";
		return session.selectOne(stmt, Integer.parseInt(no));
	}

	@Override
	public Map<String, Object> searchAll(SqlSession session, PageBean bean) {
		String stmt = ns+"searchAll";
		List<Board> list = session.selectList(stmt, bean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		if(list !=null && list.size()>0) {
			map.put("totalNumber", list.get(0).getTotal());
		}
		return map;
	}

	@Override
	public int updateBoard(SqlSession session, Board board) {
		String stmt = ns+"update";
		return session.update(stmt, board);
	}

	@Override
	public int deleteBoard(SqlSession session, String no) {
		String stmt = ns+"delete";
		return session.delete(stmt, Integer.parseInt(no));
	}
	/*
	@Override
	public Map<String, Object> searchAll(Connection con, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			int interval = bean.getInterval();
			int pageNo = bean.getPageNo();
			
			StringBuilder sql = new StringBuilder(100);
			
			StringBuilder where = new StringBuilder();
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					where.append(" where id = ? ");
				} else if (key.equals("title")) {
					where.append(" where title like  ? ");
				} else if (key.equals("contents")) {
					where.append(" where contents like  ? ");
				}
			}

			sql.append(" select (select count(*) from board " + where + 
					   " ) as total, no, id, title, date_format(regdate, '%Y-%m-%d') "
					   + "  as regdate from board   ");
			sql.append(where);
			
			sql.append(" order by no desc limit ?,? ");
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					stmt.setString(idx++, word);
					stmt.setString(idx++, word);
				} else {
					stmt.setString(idx++, "%" + word + "%");
					stmt.setString(idx++, "%" + word + "%");
				}
			}
			stmt.setInt(idx++, (pageNo - 1) * interval);// 몇 페이지에서
			stmt.setInt(idx++, interval);				// 몇 개
			
			rs = stmt.executeQuery();
			
			Map<String, Object> map = new HashMap<>();
			
			ArrayList<Board> boards = new ArrayList<>(interval);
			map.put("list", boards);
			boolean isFirst = true;
			while (rs.next()) {
				if (isFirst) {
					map.put("totalNumber", rs.getInt("total"));
					isFirst = false;
				}
				boards.add(new Board(rs.getInt("no"), rs.getString("id"), 
						   rs.getString("title"), rs.getString("regdate")));
			}
			System.out.println("dao: " + map);
			return map;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
		}
	}

	@Override
	public void updateBoard(Connection con, Board board) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update board set title=?, contents=? where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setInt(3, board.getNo());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	@Override
	public void deleteBoard(Connection con, String no) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from board where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
*/
}
