package com.ssafy.pms.service;

import java.util.List;

import com.ssafy.pms.Phone;
import com.ssafy.pms.UserInfo;

public interface IPhonService {

	public UserInfo selectUser(UserInfo user);

	int delete(List<String> list);

	public int insert(Phone phone);

	public List<Phone> select();

	public Phone select(Phone phone);

}
