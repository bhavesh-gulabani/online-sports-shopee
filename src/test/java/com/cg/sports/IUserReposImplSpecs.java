package com.cg.sports;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.cg.sports.bean.User;
import com.cg.sports.dao.IUserRepositoryImpl;

class UserTest {

		User u1 = null;
		User u2 = new User( " 1234"," customer"," user1234");
		User u3 = new User("1234","Customer", "abcd");
		
		IUserRepositoryImpl userepo = new IUserRepositoryImpl();
		
		User user = new User("user123", "1234", "customer");
		User testResult = userepo.addUser(user);

		@BeforeAll
		void beforeAllTest()
		{
			System.out.println("start testing");
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
		
		void signInNull() {
			
			User returnUser = userepo.signIn(u1);
			assertEquals(null,returnUser); 
	    }

		
		@Test
		
		void signInPos() {			
			User returnUser = userepo.signIn(testResult);
			assertEquals(testResult,returnUser);
		}
		
		
		@Test
		
		void signInNeg() {
			User returnUser = userepo.signIn(u3);
			assertNotEquals(u3, returnUser);
		}

		@Test
		
		void signOutPos() {
			User returnUser = userepo.signOut(user);
			assertEquals(user,returnUser);
		}
		
		@Test
		
		void signOutNeg() {
			User returnUser = userepo.signOut(u2);
			assertNotEquals(u2,returnUser);
		}
		
		@Test
		
		void signOutNull() {
			User returnUser = userepo.signOut(u1);
			assertNotEquals(u2,returnUser);
		}


		@Test
		
		void changePassword() {
			
			System.out.println("Test3");
			User returnUser = userepo.changePassword(user.getUserId(),user);
			String password = "abcd";
			assertEquals(password ,returnUser.getPassword());

			
		}
		@Test
		
		void getUser(){
			long userId = 512;
			User expected1 = new User("user123", "1234", "customer");	
			//expected1.setUserId(512); 
			 
			User testResult1 = userepo.getUserById(userId);
			System.out.println(testResult1);
			assertAll(
					() -> assertEquals(expected1.getUsername(),testResult1.getUsername()),
					() -> assertEquals(expected1.getPassword(),testResult1.getPassword()),
					() -> assertEquals(expected1.getRole(),testResult1.getRole())
					);		
		}
		
		
		@Test
		void getAllCustomers() {
			List<User> testResult = userepo.getAllUsers();
			assertNotNull(testResult);
		}
		
		@AfterAll
		void afterAllTest()
		{
			System.out.println("end testing");
		}


}
