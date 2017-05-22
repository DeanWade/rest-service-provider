package hello.repository.cassandra;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import hello.model.Customer;

@Table
public class CustomerCassandra extends Customer implements Serializable{
	
	private static final long serialVersionUID = -3037476022129120706L;

	public CustomerCassandra() {
		super();
	}

	public CustomerCassandra(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@PrimaryKey
	public String getId() {
		return super.getId();
	}

	@Column("first_name")
	public String getFirstName() {
		return super.getFirstName();
	}

	@Column("last_name")
	public String getLastName() {
		return super.getLastName();
	}
}
