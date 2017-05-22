package hello.repository.cassandra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCassandraRepository extends CrudRepository<CustomerCassandra, String> {

//	@Query("Select * from customer where firstname=?0 ALLOW FILTERING")
//	Customer findByFirstName(String firstName);
//
//	@Query("Select * from customer where lastname=?0 ALLOW FILTERING")
//	List<Customer> findByLastName(String lastName);
}
