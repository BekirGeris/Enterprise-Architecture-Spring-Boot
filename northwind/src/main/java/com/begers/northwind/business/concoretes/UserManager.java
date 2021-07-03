package com.begers.northwind.business.concoretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.begers.northwind.business.abstracts.UserService;
import com.begers.northwind.core.dataAccess.UserDao;
import com.begers.northwind.core.entities.User;
import com.begers.northwind.core.utilities.result.DataResult;
import com.begers.northwind.core.utilities.result.Result;
import com.begers.northwind.core.utilities.result.SuccessDataResult;
import com.begers.northwind.core.utilities.result.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanici Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanici Bulundu");
	}

}
