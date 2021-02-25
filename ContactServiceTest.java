package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Application.Contact;
import Application.ContactService;

class ContactServiceTest {

	private List<Contact> contactList = new ArrayList<Contact>();
	private ContactService service = new ContactService();

	@BeforeEach
	void setupList() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");
		contactList = new ArrayList<>(Arrays.asList(contact));
	}
	
	@AfterEach
	void teardownList() {
		contactList.clear();
	}
	
	@Test
	// Confirm that the list includes both contacts after adding
	void testAddContact() {
		Contact contact = contactList.get(0);
		Contact contact2 = new Contact("2","John","Smith","6034567891","35 Cilley Rd");
		service.addContact(contactList, contact2);
		
		for (Contact target : contactList) {
			if (target.getId().equals(contact2.getId())) {
				assertTrue(target.getId().equals("2"));
				assertTrue(target.getFirstName().equals("John"));
				assertTrue(target.getLastName().equals("Smith"));
				assertTrue(target.getPhone().equals("6034567891"));
				assertTrue(target.getAddress().equals("35 Cilley Rd"));
			}
		}
		
		List<Contact> expected = Arrays.asList(contact,contact2);
				
		assertThat(contactList, is(expected));

	}
	
	@Test
	// Confirm that an error is thrown if the id of one contact matches another
	void testAddNonUniqueContact() {
		Contact contact2 = new Contact("1","John","Smith","6034567891","35 Cilley Rd");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		service.addContact(contactList, contact2);
		});
	}
	
	@Test
	// Confirm that the correct contact is deleted
	void testDeleteContact() {
		Contact contact2 = new Contact("2","John","Smith","6034567891","35 Cilley Rd");
		contactList.add(contact2);
		
		for (Contact target : contactList) {
			
			if (target.getId().equals("1")) {
				assertTrue(target.getFirstName().equals("Greg"));
				assertTrue(target.getLastName().equals("Roberge"));
				assertTrue(target.getPhone().equals("6031234569"));
				assertTrue(target.getAddress().equals("20 Union St"));
			}
			if (target.getId().equals("2")) {
				assertTrue(target.getFirstName().equals("John"));
				assertTrue(target.getLastName().equals("Smith"));
				assertTrue(target.getPhone().equals("6034567891"));
				assertTrue(target.getAddress().equals("35 Cilley Rd"));
			}
			
		}
		
		List<Contact> expected = Arrays.asList(contact2);
		
		service.deleteContact(contactList, "1");
		
		assertThat(contactList, is(expected));

	}
	
	@Test
	// Confirm that the updated contact is correct
	void testUpdateContact() {
		
		for (Contact target : contactList) {
			if (target.getId().equals("1")) {
				assertTrue(target.getFirstName().equals("Greg"));
				assertTrue(target.getLastName().equals("Roberge"));
				assertTrue(target.getPhone().equals("6031234569"));
				assertTrue(target.getAddress().equals("20 Union St"));
			}
		}
		
		service.updateContact(contactList, "1", "Edwin", "McCain", "1569894561", "46 Grant Rd");
		
		for (Contact target : contactList) {
			if (target.getId().equals("1")) {
				assertTrue(target.getFirstName().equals("Edwin"));
				assertTrue(target.getLastName().equals("McCain"));
				assertTrue(target.getPhone().equals("1569894561"));
				assertTrue(target.getAddress().equals("46 Grant Rd"));
			}
		}
	}

}
