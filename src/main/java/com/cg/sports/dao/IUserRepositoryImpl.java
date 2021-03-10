package com.cg.sports.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.sports.bean.User;

public class IUserRepositoryImpl implements IUserRepository {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
	EntityManager em = factory.createEntityManager();
	
	User u = new User(1111, "1234", "Customer");
	
	

	@Override
	public User signIn(User user) {
		String select = "SELECT userId FROM User WHERE UserId = :UserID and Password=:Password";
		Query query = em.createQuery(select);
		query.setParameter("UserId",user.getUserId());
		query.setParameter("Password",user.getPassword());
		
		if(query.getResultList().size() == 0)
		{
			System.out.println("Account does not exist!");
			return null;
		}
		else
		{
			System.out.println("Login success!");
			return user;
		}

	}

	@Override
	public User signOut(User user) {
		if(em.contains(user))
		{
			em.remove(user);
			return user;
		}
		return null;
	}

	@Override
	public User changePassword(long id, User user) {
		String select = "SELECT userId FROM User WHERE UserId = :id";
		Query query = em.createQuery(select);
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

}