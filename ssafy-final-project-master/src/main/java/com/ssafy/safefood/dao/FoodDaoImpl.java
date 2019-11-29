package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Eat;
import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.dto.FoodPageBean;

@Repository
public class FoodDaoImpl implements FoodDao {
	private List<Food> foods;

	private final String namespace = "com.ssafy.mapper.FoodMapper.";
	
	@Autowired
	SqlSession session;
	
	public FoodDaoImpl() {
	}

	/**
	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
	 * 
	 * @return
	 */
	public List<Food> eatBest() {
		return session.selectList(namespace+"best");
	}


	@Override
	public int updatesfrq(Food food) {
		return session.update(namespace+"sfreq",food);
	}
	
	public List<Food> searchBestIndex() {
		return null;
	}

	public List<Food> getAllList() {
		return foods;
	}
	
	@Override
	public int foodCount(FoodPageBean bean) {
		String stmt = namespace + "foodCount";
		return session.selectOne(stmt, bean);
	}

	@Override
	public List<Food> searchAll(FoodPageBean bean) {
		String stmt = namespace + "searchAllBean";
		//System.out.println("결과");
		//System.out.println(bean.getKey() + " " + bean.getWord());
		List<Food> res = session.selectList(stmt, bean);
		//System.out.println(res);
		return res;
	}

	public List<Food> searchAll() {
		String stmt = namespace + "searchAll";
		return session.selectList(stmt);
	}

	@Override
	public Food search(int code) {
		String stmt = namespace + "search";
		return session.selectOne(stmt, code);
	}

	@Override
	public int insertFood(Food food) {
		String stmt = namespace + "insertFood";
		return session.selectOne(stmt, food);
	}

	@Override
	public int updateClick(Food food) {
		String stmt = namespace + "updateClick";
		System.out.println("update" + food);
		food.setAllergy(food.getAllergy());
		return session.update(stmt, food);
	}

	@Override
    public int insertEat(Eat eat) {
        String stmt = namespace + "insertEat";
        return session.insert(stmt, eat);
    }
	
	@Override
	public void loadData() {
	}

	@Override
	public List<Food> searchview() {
		return session.selectList(namespace+"viewsearch");
	}

	
}
