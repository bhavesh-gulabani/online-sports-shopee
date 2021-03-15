package com.cg.sports.service;

import java.util.List;

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

@Override
public List<User> getAllUsers() {
	return repo.getAllUsers();
}

@Override
public User getUserById(long userId) {
	return repo.getUserById(userId);
}

@Override
public User addUser(User user) {
	return repo.addUser(user);
}

}
