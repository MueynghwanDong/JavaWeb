//package com.ssafy.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//import javax.xml.parsers.SAXParser;
//import javax.xml.parsers.SAXParserFactory;
//
//import com.ssafy.service.FoodService;
//import com.ssafy.service.FoodServiceImpl;
//import com.ssafy.util.DBUtil;
//import com.ssafy.util.FoodNutritionSAXHandler;
//import com.ssafy.util.FoodSAXHandler;
//import com.ssafy.util.FoodSaxParser;
//import com.ssafy.vo.Food;
//import com.ssafy.vo.FoodPageBean;
//import com.ssafy.vo.Member;
//import com.ssafy.vo.SafeFoodException;
//
//public class FoodDaoImplBackUp implements FoodDao {
//	DBUtil util = DBUtil.getDBUtil();
//	private List<Food> foods;
//
//	public FoodDaoImplBackUp() {
//		loadData();
//		System.out.println("데이터 로딩중");
//	}
//
//	/**
//	 * 식품 영양학 정보와 식품 정보를 xml 파일에서 읽어온다.
//	 */
////	public void loadData() {
////		// FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
////		// 가져온 Food 리스트 데이터를 DB에 저장한다.
////		
////		Connection con = null;
////		FoodSaxParser sp = new FoodSaxParser();
////		foods = sp.getFoods();
////		
////		for (Food food : foods) {
////			try {
////				con = util.getConnection();
////				insertFood(con, food);
////				searchClick();
////			} catch (SQLException e) {
////				System.out.println(e.getMessage());
////			} finally {
////				try {
////					con.close();
////				} catch (SQLException e) {
////				}
////			}
////		}
////	}
////	
//	public void loadData() {
//		// 코드에 맞는 식품 클릭 수 저장
//		foods = new ArrayList<Food>();
//		String sql = "select * from food";
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rset = null;
//		try {
//			con = util.getConnection();
//			pstmt = con.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			int code = 0;
//			while (rset.next()) {
//				Food food = new Food();
////				System.out.println(rset.getInt("code"));
//				food.setCode(rset.getInt("code"));
//				food.setName(rset.getString("name"));
//				food.setCalory(rset.getDouble("supportpereat"));
//				food.setCalory(rset.getDouble("calory"));
//				food.setCarbo(rset.getDouble("carbo"));
//				food.setProtein(rset.getDouble("protein"));
//				food.setFat(rset.getDouble("fat"));
//				food.setSugar(rset.getDouble("sugar"));
//				food.setNatrium(rset.getDouble("natrium"));
//				food.setChole(rset.getDouble("chole"));
//				food.setFattyacid(rset.getDouble("fattyacid"));
//				food.setTransfat(rset.getDouble("transfat"));
//				food.setMaker(rset.getString("maker"));
//				food.setMaterial(rset.getString("material"));
//				food.setImg(rset.getString("img"));
//				food.setClickFrequency(rset.getInt("frequency"));
////				System.out.println(rset.getInt("frequency"));
//				foods.add(food);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new SafeFoodException("없습니다.");
//		} finally {
//			util.close(pstmt);
//		}
//		
//	}
//	
//	@Override
//	public int updateClick(Food food) {
//		Connection con= null;
//		String sql = "update food set frequency = ? where code = ?";
//		PreparedStatement ps = null;
//		int result = -1;
//		try {
//			con = util.getConnection();
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, food.getClickFrequency()+1);
//			ps.setInt(2, food.getCode());
//			
//			for(Food f:foods) {
//				if(f.getCode() == food.getCode()) {
//					f.setClickFrequency(food.getClickFrequency()+1);
//				}
//			}
////			search(food.getCode()).setClickFrequency(food.getClickFrequency()+1);
////			food.setClickFrequency(food.getClickFrequency()+1);
//
//			result = ps.executeUpdate();
//			System.out.println("업데이트");
//		} finally {
//			util.close(ps);
//		}
//		return result;
//	}	
//	
//	@Override
//	public int insertFood(Connection con, Food food) throws SafeFoodException {
//		String sql = "insert into food values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		PreparedStatement pstmt = null;
//		int result = -1;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, food.getCode());
//			pstmt.setString(2, food.getName());
//			pstmt.setDouble(3, food.getSupportpereat());
//			pstmt.setDouble(4, food.getCalory());
//			pstmt.setDouble(5, food.getCarbo());
//			pstmt.setDouble(6, food.getProtein());
//			pstmt.setDouble(7, food.getFat());
//			pstmt.setDouble(8, food.getSugar());
//			pstmt.setDouble(9, food.getNatrium());
//			pstmt.setDouble(10, food.getChole());
//			pstmt.setDouble(11, food.getFattyacid());
//			pstmt.setDouble(12, food.getTransfat());
//			pstmt.setString(13, food.getMaker());
//			pstmt.setString(14, food.getMaterial());
//			pstmt.setString(15, food.getImg());
//			pstmt.setString(16, food.getAllergy());
//			pstmt.setInt(17, 0);
//
//			result = pstmt.executeUpdate();
////			System.out.println(result+" 행이 영향을 받음");
//		} catch (SQLException e) {
////			System.out.println("에러");
////			e.printStackTrace();
////			throw new SafeFoodException("존재하는 음식입니다.");
//		} finally {
//			util.close(pstmt);
//		}
//		return result;
//	}	
//
//	/**
//	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
//	 * 필요
//	 * 
//	 * @param bean 검색 조건과 검색 단어가 있는 객체
//	 * @return 조회한 식품 개수
//	 */
//	public int foodCount(FoodPageBean bean) {
//		// 구현하세요.
//		int result = -1;
//		if (bean.getKey() == "all") {
//			String sql = "select count(*) from food where name like '%?%' or maker like '%?%' or material like '%?%'";
//			PreparedStatement pstmt = null;
//			Connection con = null;
//			ResultSet rset = null;
//			try {
//				con = util.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, bean.getWord());
//				pstmt.setString(2, bean.getWord());
//				pstmt.setString(3, bean.getWord());
//
//				rset = pstmt.executeQuery();
//				if (rset.next()) {
//					result = rset.getInt(1);
//				}
//			} catch (SQLException e) {
//				throw new SafeFoodException("없습니다.");
//			} finally {
//				util.close(pstmt);
//				util.close(con);
//			}
//		} else if (bean.getKey() == "name") {
//			String sql = "select count(*) from food where name like '%?%'";
//			PreparedStatement pstmt = null;
//			Connection con = null;
//			ResultSet rset = null;
//			try {
//				con = util.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, bean.getWord());
//				pstmt.setString(2, bean.getWord());
//				pstmt.setString(3, bean.getWord());
//
//				rset = pstmt.executeQuery();
//				if (rset.next()) {
//					result = rset.getInt(1);
//				}
//			} catch (SQLException e) {
//				throw new SafeFoodException("없습니다.");
//			} finally {
//				util.close(pstmt);
//				util.close(con);
//			}
//		} else if (bean.getKey() == "maker") {
//			String sql = "select count(*) from food where maker like '%?%'";
//			PreparedStatement pstmt = null;
//			Connection con = null;
//			ResultSet rset = null;
//			try {
//				con = util.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, bean.getWord());
//				pstmt.setString(2, bean.getWord());
//				pstmt.setString(3, bean.getWord());
//
//				rset = pstmt.executeQuery();
//				if (rset.next()) {
//					result = rset.getInt(1);
//				}
//			} catch (SQLException e) {
//				throw new SafeFoodException("없습니다.");
//			} finally {
//				util.close(pstmt);
//				util.close(con);
//			}
//			
//		} else if (bean.getKey() == "material") {
//			String sql = "select count(*) from food where maker like '%?%'";
//			PreparedStatement pstmt = null;
//			Connection con = null;
//			ResultSet rset = null;
//			try {
//				con = util.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, bean.getWord());
//				pstmt.setString(2, bean.getWord());
//				pstmt.setString(3, bean.getWord());
//
//				rset = pstmt.executeQuery();
//				if (rset.next()) {
//					result = rset.getInt(1);
//				}
//			} catch (SQLException e) {
//				throw new SafeFoodException("없습니다.");
//			} finally {
//				util.close(pstmt);
//				util.close(con);
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
//	 * 
//	 * @param bean 검색 조건과 검색 단어가 있는 객체
//	 * @return 조회한 식품 목록
//	 */
//	public List<Food> searchAll(FoodPageBean bean) {
//		List<Food> finds = new LinkedList<Food>();
//		if (bean != null) {
//			String key = bean.getKey();
//			String word = (bean.getWord() != null && !bean.getWord().trim().equals(""))? bean.getWord() : "";
//				if (key.equals("all")) {
//					String sql = "select * from food where material like '%"+word+"%' or maker like '%"+word+"%'or name like '%"+word+"%'"; 
//					PreparedStatement pstmt = null;
//					Connection con = null;
//					ResultSet rset = null;
//					try {
//						con = util.getConnection();
//						pstmt = con.prepareStatement(sql);
//						rset = pstmt.executeQuery();
//						while (rset.next()) {
//							Food food = new Food();
////							System.out.println(rset.getInt("code"));
//							food.setCode(rset.getInt("code"));
//							food.setName(rset.getString("name"));
//							food.setCalory(rset.getDouble("supportpereat"));
//							food.setCalory(rset.getDouble("calory"));
//							food.setCarbo(rset.getDouble("carbo"));
//							food.setProtein(rset.getDouble("protein"));
//							food.setFat(rset.getDouble("fat"));
//							food.setSugar(rset.getDouble("sugar"));
//							food.setNatrium(rset.getDouble("natrium"));
//							food.setChole(rset.getDouble("chole"));
//							food.setFattyacid(rset.getDouble("fattyacid"));
//							food.setTransfat(rset.getDouble("transfat"));
//							food.setMaker(rset.getString("maker"));
//							food.setMaterial(rset.getString("material"));
//							food.setImg(rset.getString("img"));
//							food.setClickFrequency(rset.getInt("frequency"));
//							finds.add(food);
//						}
//					} catch (SQLException e) {
////						throw new SafeFoodException("없습니다.");
//					} finally {
//						util.close(pstmt);
//						util.close(con);
//					}
//				} else if (key.equals("name")) {
//					String sql = "select * from food where name like '%"+bean.getWord()+"%'";
//					PreparedStatement pstmt = null;
//					Connection con = null;
//					ResultSet rset = null;
//					try {
//						con = util.getConnection();
//						pstmt = con.prepareStatement(sql);
//						rset = pstmt.executeQuery();
//						while (rset.next()) {
//							Food food = new Food();
//							food.setCode(rset.getInt("code"));
//							food.setName(rset.getString("name"));
//							food.setCalory(rset.getDouble("supportpereat"));
//							food.setCalory(rset.getDouble("calory"));
//							food.setCarbo(rset.getDouble("carbo"));
//							food.setProtein(rset.getDouble("protein"));
//							food.setFat(rset.getDouble("fat"));
//							food.setSugar(rset.getDouble("sugar"));
//							food.setNatrium(rset.getDouble("natrium"));
//							food.setChole(rset.getDouble("chole"));
//							food.setFattyacid(rset.getDouble("fattyacid"));
//							food.setTransfat(rset.getDouble("transfat"));
//							food.setMaker(rset.getString("maker"));
//							food.setMaterial(rset.getString("material"));
//							food.setImg(rset.getString("img"));
//							food.setClickFrequency(rset.getInt("frequency"));
//							finds.add(food);
//						}
//					} catch (SQLException e) {
//						throw new SafeFoodException("없습니다.");
//					} finally {
//						util.close(pstmt);
//					}
//				} else if (key.equals("maker")) {
//					String sql = "select * from food where maker like '%"+bean.getWord()+"%'";
//					PreparedStatement pstmt = null;
//					Connection con = null;
//					ResultSet rset = null;
//					try {
//						con = util.getConnection();
//						pstmt = con.prepareStatement(sql);
//						rset = pstmt.executeQuery();
//						while (rset.next()) {
//							Food food = new Food();
//							food.setCode(rset.getInt("code"));
//							food.setName(rset.getString("name"));
//							food.setCalory(rset.getDouble("supportpereat"));
//							food.setCalory(rset.getDouble("calory"));
//							food.setCarbo(rset.getDouble("carbo"));
//							food.setProtein(rset.getDouble("protein"));
//							food.setFat(rset.getDouble("fat"));
//							food.setSugar(rset.getDouble("sugar"));
//							food.setNatrium(rset.getDouble("natrium"));
//							food.setChole(rset.getDouble("chole"));
//							food.setFattyacid(rset.getDouble("fattyacid"));
//							food.setTransfat(rset.getDouble("transfat"));
//							food.setMaker(rset.getString("maker"));
//							food.setMaterial(rset.getString("material"));
//							food.setImg(rset.getString("img"));
//							food.setClickFrequency(rset.getInt("frequency"));							
//							finds.add(food);
//						}
//					} catch (SQLException e) {
//						throw new SafeFoodException("없습니다.");
//					} finally {
//						util.close(pstmt);
//					}
//				} else if (key.equals("material")) {
//					String sql = "select * from food where material like '%"+bean.getWord()+"%'";
//					PreparedStatement pstmt = null;
//					Connection con = null;
//					ResultSet rset = null;
//					try {
//						con = util.getConnection();
//						pstmt = con.prepareStatement(sql);
//						rset = pstmt.executeQuery();
//						while (rset.next()) {
//							Food food = new Food();
//							food.setCode(rset.getInt("code"));
//							food.setName(rset.getString("name"));
//							food.setCalory(rset.getDouble("supportpereat"));
//							food.setCalory(rset.getDouble("calory"));
//							food.setCarbo(rset.getDouble("carbo"));
//							food.setProtein(rset.getDouble("protein"));
//							food.setFat(rset.getDouble("fat"));
//							food.setSugar(rset.getDouble("sugar"));
//							food.setNatrium(rset.getDouble("natrium"));
//							food.setChole(rset.getDouble("chole"));
//							food.setFattyacid(rset.getDouble("fattyacid"));
//							food.setTransfat(rset.getDouble("transfat"));
//							food.setMaker(rset.getString("maker"));
//							food.setMaterial(rset.getString("material"));
//							food.setImg(rset.getString("img"));
//							food.setClickFrequency(rset.getInt("frequency"));
//							finds.add(food);
//						}
//					} catch (SQLException e) {
//						throw new SafeFoodException("없습니다.");
//					} finally {
//						util.close(pstmt);
//					}
//				}
//
//		}
//		return finds;
//	}
//
//	public List<Food> searchAll() throws SQLException {
//		List<Food> finds = new LinkedList<>();
//		String sql = "select * from food"; 
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rset = null;
//		try {
//			con = util.getConnection();
//			pstmt = con.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			while (rset.next()) {
//				Food food = new Food();
//				food.setCode(rset.getInt("code"));
//				food.setName(rset.getString("name"));
//				food.setCalory(rset.getDouble("supportpereat"));
//				food.setCalory(rset.getDouble("calory"));
//				food.setCarbo(rset.getDouble("carbo"));
//				food.setProtein(rset.getDouble("protein"));
//				food.setFat(rset.getDouble("fat"));
//				food.setSugar(rset.getDouble("sugar"));
//				food.setNatrium(rset.getDouble("natrium"));
//				food.setChole(rset.getDouble("chole"));
//				food.setFattyacid(rset.getDouble("fattyacid"));
//				food.setTransfat(rset.getDouble("transfat"));
//				food.setMaker(rset.getString("maker"));
//				food.setMaterial(rset.getString("material"));
//				food.setImg(rset.getString("img"));
//				finds.add(food);
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
//	/**
//	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
//	 * 
//	 * @param code 검색할 식품 코드
//	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
//	 */
//	public Food search(int code) {
//		// 코드에 맞는 식품 검색하여 리턴
//
//		String sql = "select * from food where code = ?";
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rset = null;
//		Food food = null;
//		try {
//			con = util.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, code);
//
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				food = new Food(code);
//				food.setName(rset.getString("name"));
//				food.setCalory(rset.getDouble("supportpereat"));
//				food.setCalory(rset.getDouble("calory"));
//				food.setCarbo(rset.getDouble("carbo"));
//				food.setProtein(rset.getDouble("protein"));
//				food.setFat(rset.getDouble("fat"));
//				food.setSugar(rset.getDouble("sugar"));
//				food.setNatrium(rset.getDouble("natrium"));
//				food.setChole(rset.getDouble("chole"));
//				food.setFattyacid(rset.getDouble("fattyacid"));
//				food.setTransfat(rset.getDouble("transfat"));
//				food.setMaker(rset.getString("maker"));
//				food.setMaterial(rset.getString("material"));
//				food.setImg(rset.getString("img"));
//				food.setClickFrequency(rset.getInt("frequency"));
//				foods.add(food);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new SafeFoodException("없습니다.");
//		} finally {
//			util.close(pstmt);
//		}
//		
//		return food;
//	}
//
//	
//	public void updateClick(int code) {
//		// 클릭시마다 클릭 + 1
//
//		String sql = "select * from food where code = ?";
//		PreparedStatement pstmt = null;
//		Connection con = null;
//		ResultSet rset = null;
//		Food food = null;
//		try {
//			con = util.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, code);
//
//			rset = pstmt.executeQuery();
//			if (rset.next()) {
//				food = new Food(code);
//				food.setName(rset.getString("name"));
//				food.setCalory(rset.getDouble("supportpereat"));
//				food.setCalory(rset.getDouble("calory"));
//				food.setCarbo(rset.getDouble("carbo"));
//				food.setProtein(rset.getDouble("protein"));
//				food.setFat(rset.getDouble("fat"));
//				food.setSugar(rset.getDouble("sugar"));
//				food.setNatrium(rset.getDouble("natrium"));
//				food.setChole(rset.getDouble("chole"));
//				food.setFattyacid(rset.getDouble("fattyacid"));
//				food.setTransfat(rset.getDouble("transfat"));
//				food.setMaker(rset.getString("maker"));
//				food.setMaterial(rset.getString("material"));
//				food.setImg(rset.getString("img"));
//				food.setClickFrequency(rset.getInt("frequency"));
//				
//				foods.add(food);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new SafeFoodException("없습니다.");
//		} finally {
//			util.close(pstmt);
//		}
//	}
//
//	
//	/**
//	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
//	 * 
//	 * @return
//	 */
//	public List<Food> searchBest() {
//		return null;
//	}
//
//	public List<Food> searchBestIndex() {
//		return null;
//	}
//
//	public List<Food> getAllList() {
//		return foods;
//	}
//	
//	
//	public static void main(String[] args) {
//		FoodDaoImplBackUp dao = new FoodDaoImplBackUp();
////		dao.loadData();
//		System.out.println(dao.search(1));
//		System.out.println("===========================material로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
//		System.out.println("===========================maker로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
//		System.out.println("===========================name으로 검색=================================");
//		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
//		System.out.println("============================================================");
//		print(dao.searchAll(null));
//		System.out.println("============================================================");
//	}
//
//	public static void print(List<Food> foods) {
//		for (Food food : foods) {
//			System.out.println(food);
//		}
//	}
//	
//}
