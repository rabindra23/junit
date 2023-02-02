package com.masai.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class ContactManagerTest {

	private static ContactManager manager = null;
	
	@BeforeAll
	public static void setUp() {
		manager = new ContactManager();
	}
	
	@Test
	@DisplayName("Should Create Contact")
	public void testCreate() {
		manager.addContact("Rabindra", "Kumar", "0987456321");		
		Collection<Contact> allContacts = manager.getAllContacts();
		assertEquals(1, allContacts.size());
	}
	
	@Test
	@DisplayName("Should Not Create Contact When First Name is Null")
	public void testFirstName() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			manager.addContact("", "ABC", "0176543210");
		});
		assertEquals("First Name Cannot be null or empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("Phone Number should start with 0")
	public void testNumber() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			manager.addContact("ABC", "GEF", "9871026452");
		});
		assertEquals("Phone Number Should Start with 0", exception.getMessage());
	}
	
	@Test
	@Disabled("For Testing disabled annotation")
	public void disabledTest() {
		
	}
	
	@AfterAll
	public static void cleanUp() {
		manager = null;
	}
}
