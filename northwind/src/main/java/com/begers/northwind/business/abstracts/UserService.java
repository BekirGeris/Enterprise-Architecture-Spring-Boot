package com.begers.northwind.business.abstracts;

import com.begers.northwind.core.entities.User;
import com.begers.northwind.core.utilities.result.DataResult;
import com.begers.northwind.core.utilities.result.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
