package hello.repository.cassandra;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.model.Customer;

@Repository
public interface CustomerCassandraRepository extends CrudRepository<Customer, String> {

	@Query("Select * from customer where firstname=?0 ALLOW FILTERING")
	Customer findByFirstName(String firstName);

	@Query("Select * from customer where lastname=?0 ALLOW FILTERING")
	List<Customer> findByLastName(String lastName);
}
