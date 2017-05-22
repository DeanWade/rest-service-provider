package hello.model;

import java.util.UUID;

public abstract class Customer{
	
	private String id;

	private String firstName;
	
	private String lastName;

	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Customer(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(this.getClass().getSimpleName() +": [id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
