package Application;

import java.util.List;

public class ContactService {

		public void addContact(List<Contact> contactList, Contact newContact) {
			
			for (Contact target : contactList) {
				if (target.getId().equals(newContact.getId())) {
					throw new IllegalArgumentException("Contact id already exists");
				}
				else {
					contactList.add(newContact);
					break;
				}
			}
		}
		
		public void deleteContact(List<Contact> contactList, String id) {
			
			for (Contact target : contactList) {
				if (target.getId().equals(id)) {
					contactList.remove(target);
				}
			}
		}
		
		public void updateContact(List<Contact> contactList, String id, String firstName, String lastName, String phone, String address) {
			for (Contact target : contactList) {
				if (target.getId().equals(id)) {
					target.setFirstName(firstName);
					target.setLastName(lastName);
					target.setPhone(phone);
					target.setAddress(address);
				}
			}
		}
		
}
