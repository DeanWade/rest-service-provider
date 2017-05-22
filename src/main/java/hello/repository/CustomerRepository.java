package hello.repository;

import java.util.List;

import hello.model.Customer;

public interface CustomerRepository{

	Customer findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);
}
