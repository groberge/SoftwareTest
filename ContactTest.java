package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Contact;

class ContactTest {

	
	@Test
	void testContact() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");
		assertTrue(contact.getId().equals("1"));
		assertTrue(contact.getFirstName().equals("Greg"));
		assertTrue(contact.getLastName().equals("Roberge"));
		assertTrue(contact.getPhone().equals("6031234569"));
		assertTrue(contact.getAddress().equals("20 Union St"));
	}
	
	@Test
	void testSetIdTooLong() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setId("12345678907");
		});
	}
	
	@Test
	void testSetIdNull() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setId(null);
		});
	}
	
	@Test
	void testSetFirstNameTooLong() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Gregory Paul");
		});
	}
	
	@Test
	void testSetFirstNameNull() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testSetLastNameTooLong() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Robergerino");
		});
	}
	
	@Test
	void testSetLastNameNull() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	@Test
	void testSetPhoneTooShort() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("601234569");
		});
	}
	
	@Test
	void testSetPhoneTooLong() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("60312345690");
		});
	}
	
	@Test
	void testSetPhoneNull() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	void testSetPhoneLetters() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("603123456a");
		});
	}
	
	@Test
	void testSetPhoneSpecialChars() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("603123456!");
		});
	}
	
	@Test
	void testSetAddressTooLong() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("20 Union St Merrimack New Hamps");
		});
	}
	
	@Test
	void testSetAddressNull() {
		Contact contact = new Contact("1","Greg","Roberge","6031234569","20 Union St");

		Assertions.assertThrows(NullPointerException.class, () -> {
			contact.setAddress(null);
		});
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678907","Greg","Roberge","6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact(null,"Greg","Roberge","6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Gregory Paul","Roberge","6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("123456789",null,"Roberge","6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Robergerino","6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("123456789","Greg",null,"6031234569","20 Union St");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Roberge","601234569","20 Union St");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Roberge","60312345690","20 Union St");
		});
	}
	
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("123456789","Greg","Roberge",null,"20 Union St");
		});
	}
	
	@Test
	void testContactPhoneLetters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Roberge","603123456a","20 Union St");
		});
	}
	
	@Test
	void testContactPhoneSpecialChars() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Roberge","603123456!","20 Union St");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789","Greg","Roberge","6031234569","20 Union St Merrimack New Hamps");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("123456789","Greg","Roberge","6031234569",null);
		});
	}
	
	

}
