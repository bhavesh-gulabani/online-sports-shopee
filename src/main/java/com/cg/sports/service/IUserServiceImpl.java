package com.cg.sports.service;

import com.cg.sports.bean.User;
import com.cg.sports.dao.IUserRepository;
import com.cg.sports.dao.IUserRepositoryImpl;


public class IUserServiceImpl implements IUserService {
	
	private IUserRepository repo = new IUserRepositoryImpl() ;

	@Override
	public User signIn(User user) {
		return repo.signIn(user);
		
	}

	@Override
	public User signOut(User user) {
		return repo.signOut(user);
	}

	@Override
	public User changePassword(long id, User user) {
		return repo.changePassword(id, user);
	}

}
