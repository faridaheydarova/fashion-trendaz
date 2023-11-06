package  fashion.trendaz.fashiontrendazproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.trendaz.fashiontrendazproject.entity.Brand;

public interface BrandRepo extends JpaRepository<Brand, Integer>{

	Brand findByEmail(String email);

	Optional<Brand> findOneByEmailAndPassword(String email, String encodePassword);

}
