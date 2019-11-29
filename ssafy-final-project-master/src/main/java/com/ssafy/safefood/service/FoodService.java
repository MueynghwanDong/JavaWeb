package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Food;
import com.ssafy.safefood.dto.FoodPageBean;

public interface FoodService {
	
	public void insertData(Food food);
	public List<Food> searchAll(FoodPageBean bean);
	public Food search(int code);
	public List<Food> searchBest();
	public List<Food> searchBestIndex();
	public void updateClick(Food food);
//	public void addeat(int code, int amount);
	public List<Food> searchview();
	
	public List<Food> eatBest();
	public int updatesfrq(Food food);
	
}
