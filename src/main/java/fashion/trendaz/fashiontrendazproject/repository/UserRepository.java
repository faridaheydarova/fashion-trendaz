package fashion.trendaz.fashiontrendazproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import fashion.trendaz.fashiontrendazproject.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findAll();

	User findByEmail(String email);

	Optional<User> findOneByEmailAndPassword(String email, String encodePassword);

}