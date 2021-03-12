package com.cg.sports.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.sports.bean.User;

public class UserRepositoryImpl implements IUserRepository {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager entityManager = factory.createEntityManager();

	@Override
	public User signIn(User user) {
		List<User> userList = getAllUsers();
		for (User systemUser : userList) {
			if ( (systemUser.getUsername().equals(user.getUsername())) && 
					(systemUser.getPassword().equals(user.getPassword())) ) {
				
				System.out.println("Successfully signed in...");
				return user;
			}
		}
		return null;
	}

	@Override
	public User signOut(User user) {
		System.out.println("Successfully signed out...");
		return user;
	}

	@Override
	public User changePassword(long id, User user) {
		
		// Get user by id
		User systemUser = getUserById(id);
		
		// Change his/her password
		systemUser.setPassword(user.getPassword());
		
		return systemUser;
	}

	@Override
	public List<User> getAllUsers() {
		String queryString = "SELECT user FROM User user";
		Query query = entityManager.createQuery(queryString);
		return query.getResultList().isEmpty() ? null : query.getResultList();
	}

	@Override
	public User getUserById(long userId) {
		String queryString = "SELECT user FROM User user WHERE user.userId = :uId";
		TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
		query.setParameter("uId", userId);
		User user = query.getSingleResult();
		return user == null ? null : user;
	}
	
}
