package com.cg.sports.service;

import java.util.List;

import com.cg.sports.bean.User;

public interface IUserService {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);
	public List<User> getAllUsers();
	public User getUserById(long userId);
	public User addUser(User user);
}
