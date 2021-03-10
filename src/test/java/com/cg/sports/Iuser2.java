package com.cg.sports;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import com.cg.sports.bean.User;
import com.cg.sports.dao.IUserRepositoryImpl;

import org.junit.jupiter.api.Test;

import com.cg.sports.bean.User;

class Iuser2 {
	
	User u = new User(1111,"1234","Customer");

	@Test
	void test1() {
		System.out.println("Test1");
		IUserRepositoryImpl userepo = new IUserRepositoryImpl();
		User returnUser = userepo.signIn(u);
		assertNotNull(returnUser);
        assertEquals(u,returnUser); 
        System.out.println("Tes1");

}
}