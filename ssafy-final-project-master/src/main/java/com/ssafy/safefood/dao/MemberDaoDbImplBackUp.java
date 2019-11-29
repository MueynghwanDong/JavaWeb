//package com.ssafy.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import com.ssafy.util.DBUtil;
//import com.ssafy.vo.Food;
//import com.ssafy.vo.Member;
//
//public class MemberDaoDbImplBackUp implements MemberDaoDb {
//	private DBUtil util = DBUtil.getDBUtil();
////	FoodService fs = new FoodServiceImpl();
//
//	// - 추가 -
//	private static MemberDaoDbImplBackUp impl = new MemberDaoDbImplBackUp();
//
//	public MemberDaoDbImplBackUp() {
//
//	}
//
//	public static MemberDaoDbImplBackUp getImpl() {
//		return impl;
//	}
//
//	@Override
//	public int insertMember(Connection con, Member member) throws SQLException {
//		String sql = "insert into signup values (?,?,?,?,?)";
//		PreparedStatement ps = null;
//		int result = -1;
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, member.getId());
//			ps.setString(2, member.getPw());
//			ps.setString(3, member.getName());
//			ps.setString(4, member.getPhone());
//			ps.setString(5, member.getEmail());
//
//			result = ps.executeUpdate();
//		} finally {
//			util.close(ps);
//		}
//		return result;
//	}
//
//	@Override
//	public Member searchMember(Connection con, String id) throws SQLException {
//		String sql = "select * from signup where id = ?";
//		Member member = null;
//		try {
//			con = util.getConnection();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				member = new Member(rset.getString("id"), rset.getString("pw"), rset.getString("name"),
//						rset.getString("phone"), rset.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			util.close(rset);
//			util.close(pstmt);
//		}
//		return member;
//	}
//
//	@Override
//	public boolean LoginMember(Connection con, String id, String pw) throws SQLException {
//		String sql = "select * from signup where id = ?";
//		Member member = null;
//		try {
//			con = util.getConnection();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				member = new Member(rset.getString("id"), rset.getString("pw"), rset.getString("name"),
//						rset.getString("phone"), rset.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			util.close(rset);
//			util.close(pstmt);
//		}
//		if (member == null) {
//			System.out.println("없음");
//			return false;
//		} else {
//			if (pw.equals(member.getPw())) {
//				return true;
//			} else {
//				System.out.println("비번오류");
//				return false;
//			}
//		}
//	}
//
//	@Override
//	public int updateMember(Connection con, Member member) throws SQLException {
//		String sql = "update signup set pw = ?, name = ?, phone = ?, email = ? where id = ?";
//		PreparedStatement ps = null;
//		int result = -1;
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, member.getPw());
//			ps.setString(2, member.getName());
//			ps.setString(3, member.getPhone());
//			ps.setString(4, member.getEmail());
//			ps.setString(5, member.getId());
//
//			result = ps.executeUpdate();
//		} finally {
//			util.close(ps);
//		}
//		return result;
//	}
//
//	@Override
//	public void deleteMember(Connection con, String id) throws SQLException {
//		String sql = "delete from signup where id=?";
//		PreparedStatement ps = null;
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, id);
//			ps.executeUpdate();
//		} finally {
//			util.close(ps);
//		}
//	}
//
//	@Override
//	public List<Member> searchAll() throws SQLException {
//		List<Member> finds = new LinkedList<>();
//		String sql = "select * from signup"; 
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rset = null;
//		try {
//			con = util.getConnection();
//			pstmt = con.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			while (rset.next()) {
//				Member member = new Member();
//				member.setId(rset.getString("id"));
//				member.setPw(rset.getString("pw"));
//				member.setName(rset.getString("name"));
//				member.setPhone(rset.getString("phone"));
//				member.setEmail(rset.getString("email"));
//				finds.add(member);
//			}
//		} catch (SQLException e) {
////						throw new SafeFoodException("없습니다.");
//		} finally {
//			util.close(pstmt);
//			util.close(con);
//		}
//		
//		return finds;
//	}
//	
//}
