package fashion.trendaz.fashiontrendazproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.trendaz.fashiontrendazproject.dto.CustomerDTO;
import fashion.trendaz.fashiontrendazproject.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);

	Optional<Customer> findOneByEmailAndPassword(String email, String encodePassword);

}
