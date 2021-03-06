package com.cg.sports.dao;

import java.util.List;


import com.cg.sports.bean.User;

public interface IUserRepository {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
	public List<User> getAllUsers();
	public User getUserById(long custId);
}
