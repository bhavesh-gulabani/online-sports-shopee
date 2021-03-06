package com.cg.sports.service;

import com.cg.sports.bean.User;

public interface IUserService {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
}
