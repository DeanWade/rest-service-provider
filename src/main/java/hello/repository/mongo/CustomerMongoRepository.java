package hello.repository.mongo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMongoRepository extends CrudRepository<CustomerMongo, String> {

}
