package com.ssafy.pms.repo;

import java.util.List;

import com.ssafy.pms.Phone;
import com.ssafy.pms.UserInfo;

public interface IPhoneDao {

	UserInfo selectUser(UserInfo user);
	
	public int insert(Phone phone);
	int delete(List<String> list);
	public List<Phone> select();
	public Phone select(Phone phone);
	int restInsert(Phone phone);
	Phone restSelect(String num);
	List<Phone> restSelectAll();
	int restDelete(String num);
	int restUpdate(Phone phone);
}
