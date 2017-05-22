package hello.repository.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import hello.model.Customer;

@Entity
public class CustomerJPA extends Customer implements Serializable{
	
	private static final long serialVersionUID = -3037476022129120706L;

	public CustomerJPA() {
	}

	public CustomerJPA(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	@Id
	public String getId() {
		return super.getId();
	}

	@Column(name="first_name")
	public String getFirstName() {
		return super.getFirstName();
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return super.getLastName();
	}
}
