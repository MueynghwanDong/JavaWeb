package com.ssafy.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.Phone;
import com.ssafy.pms.UserInfo;
import com.ssafy.pms.repo.IPhoneDao;

@Service
public class PhoneServiceImpl implements IPhonService {

	@Autowired
	IPhoneDao PhoneDao;

	@Override
	public int insert(Phone phone) {
		return PhoneDao.insert(phone);
	}

	@Override
	public UserInfo selectUser(UserInfo user) {
		return PhoneDao.selectUser(user);
	}

	@Override
	public List<Phone> select() {
		return PhoneDao.select();
	}

	@Override
	public Phone select(Phone phone) {
		return PhoneDao.select(phone);
	}

	@Override
	@Transactional
	public int delete(List<String> list) {
		return PhoneDao.delete(list);
	}

	@Override
	@Transactional
	public int restInsert(Phone phone) {
		return PhoneDao.restInsert(phone);
	}
	
	@Override
	@Transactional
	public int restDelete(String num) {
		return PhoneDao.restDelete(num);
	}
	
	@Override
	public Phone restSelect(String num) {
		return PhoneDao.restSelect(num);
	}
	
	@Override
	public List<Phone> restSelectAll() {
		return PhoneDao.restSelectAll();
	}
	
	@Override
	@Transactional
	public int restUpdate(Phone phone) {
		return PhoneDao.restUpdate(phone);
	}
}