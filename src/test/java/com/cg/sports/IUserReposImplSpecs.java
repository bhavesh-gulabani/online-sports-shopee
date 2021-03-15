package com.cg.sports;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import com.cg.sports.bean.User;
import com.cg.sports.dao.IUserRepositoryImpl;

class IUserReposImplSpecs 
{

	User u = new User(1111,"1234","Customer");
	IUserRepositoryImpl userepo = new IUserRepositoryImpl();
	
	@BeforeAll
	void beforeAllTest()
	{
		System.out.println("start testing");
	}
	
	@AfterAll
	void afterAllTest()
	{
		System.out.println("end testing");
	}
	
	@BeforeEach
	void beforeEachTest()
	{
		System.out.println("before testing");
	}
	
	@AfterEach
	void afterEachTest()
	{
		System.out.println("after testing");
	}
	
	
	@Test
	void test1() {
		System.out.println("Test1");
		User returnUser = userepo.signIn(u);
		assertNotNull(returnUser);
        assertEquals(u,returnUser); 
        System.out.println("Tes1");
	}
	
	
	
	
	@Test
	void test2() {
		System.out.println("Test2");
		User returnUser = userepo.signOut(u);
		assertEquals(u,returnUser);
	
	}
	

	@Test
	void test3() {
		System.out.println("Test3");
		User returnUser = userepo.changePassword(1111,u);
		String password = "abcd";
		assertEquals(password ,returnUser.getPassword());

		
		
	}

}