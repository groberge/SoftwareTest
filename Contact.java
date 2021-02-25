package Application;

public class Contact {
		
		// Setup contact with the following restrictions
		// id (unique,non-null, no more than 10 characters)
		// firstName (non-null, no more than 10 characters)
		// lastName (non-null, no more than 10 characters)
		// phone (non-null, all digits, no more than 10 characters)
		// address (non-null, no more than 10 characters)

		private String id;
		private String firstName;
		private String lastName;
		private String phone;
		private String address;
		
		public Contact(String id, String firstName, String lastName, String phone, String address) {

			this.setId(id);
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.setPhone(phone);			
			this.setAddress(address);
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			if(id.equals(null) || id.length()>10) {
				throw new IllegalArgumentException("Invalid id");
			}
			
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			if(firstName.equals(null) || firstName.length()>10) {
				throw new IllegalArgumentException("Invalid firstName");
			}
			
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			if(lastName.equals(null) || lastName.length()>10) {
				throw new IllegalArgumentException("Invalid lastName");
			}
			
			this.lastName = lastName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			if(phone.equals(null) || phone.length()!=10 ) {
				throw new IllegalArgumentException("Invalid phone");
			}
			
			if (phone.matches("\\d+")) {
				this.phone = phone;
			}
			else {
				throw new IllegalArgumentException("Phone must be all digits");
			}
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			if(address.equals(null) || address.length()>30) {
				throw new IllegalArgumentException("Invalid address");
			}
			
			this.address = address;
		}
				
		
}
