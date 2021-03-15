package com.cg.sports.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.sports.bean.User;

public class IUserRepositoryImpl implements IUserRepository {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager entityManager = factory.createEntityManager(); 

	@Override
	public User signIn(User user) {
		List<User> userList = getAllUsers();
		if (user == null)
		{
			return null;
		}
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
		if(entityManager.contains(user)) 
		{
			System.out.println("Successfully signed out...");
			return user;
		}
		return null;
	}

	@Override
	public User changePassword(long id, User user) {
//		User user2 = getUserById(id);
//		System.out.println("USER 2 "+user2);
		String select = "SELECT userId FROM User WHERE UserId = :id";
		Query query = entityManager.createQuery(select);
		query.setParameter("id",id);
		
		if(query.getResultList().size() == 0)
		{
			System.out.println("ID does not exist!");
			return null;
		}
		else
		{
			final Scanner sc = new Scanner(System.in);
			System.out.println("Enter new Password");
			String st = sc.nextLine();
			user.setPassword(st);
			sc.close();
			return user;
		}
	}



	@Override
	public List<User> getAllUsers() {
		String queryString = "SELECT u FROM User u";
		Query query = entityManager.createQuery(queryString);
		return query.getResultList().isEmpty() ? null : query.getResultList(); 
	}

	@Override
	public User getUserById(long userId) {
//		String queryString = "SELECT u FROM User u WHERE User.userId = :uId";
//		TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
//		query.setParameter("uId", userId);
//		User user = query.getSingleResult();
//		return user == null ? null : user;
//		
		
		User user1 = entityManager.find(User.class, userId);
		return user1 == null ? null : user1;
		
	}

	@Override
	public User addUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return user;
	}
	
}
