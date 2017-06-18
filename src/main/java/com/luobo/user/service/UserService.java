package com.luobo.user.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luobo.common.MailUtils;
import com.luobo.user.dao.userMapper;
import com.luobo.user.pojo.user;

@Service("userService")
public class UserService  implements IUserService{
	
	@Resource
	private userMapper userDao;

	@Override
	public int register(user record) {
		// TODO Auto-generated method stub
		record.setRegistertime(new Date());
		int ret = userDao.insert(record);
		if(1 == ret)
			MailUtils.sendRegister(record.getEmail(), record.getUsername()+","+record.getId());
		//还有错误时的日志
		return 1;
	}

}

