package in.logg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.logg.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	public Customer findByEmail(String email);
	

}
