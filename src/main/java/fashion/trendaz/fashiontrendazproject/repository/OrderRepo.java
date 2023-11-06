package fashion.trendaz.fashiontrendazproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fashion.trendaz.fashiontrendazproject.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

	Orders save(Orders order);

	Orders findAllByUsername(String username);



}
