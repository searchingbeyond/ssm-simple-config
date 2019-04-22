package cn.ganlixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ganlixin.dao.UserDao;
import cn.ganlixin.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectUserById(User user) {
		
		return userDao.selectUserById(user);
	}
}
