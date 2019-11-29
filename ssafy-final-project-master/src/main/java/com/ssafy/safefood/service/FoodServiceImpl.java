package com.ssafy.safefood.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dao.FoodDao;
import com.ssafy.safefood.dto.Eat;
import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.dto.FoodPageBean;

@Service
public class FoodServiceImpl implements FoodService {

	private static Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);

	@Autowired
	FoodDao dao;

	private String[] allergys = { "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레",
			"계란흰자" };

	// singleton
	private static FoodServiceImpl fs = new FoodServiceImpl();

	private FoodServiceImpl() {
	}

	public static FoodServiceImpl getFoodServiceImpl() {
		return fs;
	}

	public List<Food> searchAll(FoodPageBean bean) {
		try {
			return dao.searchAll(bean);
		} catch (RuntimeException e) {
			logger.error("로그인 정보 받아오기 실패", e);
		}
		return null;
	}

	public Food search(int code) {
		// code에 맞는 식품 정보를 검색하고, 검색된 식품의 원재료에 알레르기 성분이 있는지 확인하여 Food 정보에 입력한다.
		Food food = null;
		try {

			food = dao.search(code);
//			StringBuilder sb = new StringBuilder("");
//			for (String allergy : allergys) {
//				if (allergy != null && food.getMaterial().contains(allergy)) {
//					sb.append(allergy + " ");
//				}
//			}
//			food.setAllergy(sb.toString());
		} catch (RuntimeException e) {
			logger.error("로그인 정보 받아오기 실패", e);
		}
		return food;
	}

	// 문제가 있음.
	public List<Food> searchlAll() {
		List<Food> result = null;
		try {
			result = dao.searchAll(new FoodPageBean());
		} catch (RuntimeException e) {
			logger.error("전체 리스트 정보 받아오기 실패", e);
		}
		return result;
	}

	@Transactional
	public void updateClick(Food food) {
		try {
			System.out.println("update : " + dao.updateClick(food));
		} catch (RuntimeException e) {
			logger.error("개수 업데이트 실패", e);
		}
	}

//	public List<Food> searchBest() {
//		return dao.searchBest();
//	}

	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

	@Override
	@Transactional
	public void insertData(Food food) {
		try {
			int insertResult = dao.insertFood(food);
			System.out.println(insertResult + "개가 저장됨");
		} catch (RuntimeException e) {
			logger.error("로그인 정보 받아오기 실패", e);
		}
	}

	@Transactional
	public void insertEat(Eat eat) {
		try {
			int insertResult = dao.insertEat(eat);
			System.out.println(insertResult + "개가 저장됨");
		} catch (RuntimeException e) {
			logger.error("로그인 정보 받아오기 실패", e);
		}
	}

	@Override
	public List<Food> searchview() {
		return dao.searchview();
	}

	@Override
	public List<Food> eatBest() {
		return dao.eatBest();
	}

	@Override
	public int updatesfrq(Food food) {
		return dao.updatesfrq(food);
	}

	@Override
	public List<Food> searchBest() {
		// TODO Auto-generated method stub
		return null;
	}
}
