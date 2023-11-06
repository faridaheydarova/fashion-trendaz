package fashion.trendaz.fashiontrendazproject.controller;

import java.util.ArrayList;   

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fashion.trendaz.fashiontrendazproject.entity.Basket;
import fashion.trendaz.fashiontrendazproject.entity.Orders;
import fashion.trendaz.fashiontrendazproject.repository.OrderRepo;


@RestController
@RequestMapping(path="/orders")
@CrossOrigin(origins = "*")
public class OrderRestController {
	
	@Autowired
	private OrderRepo orderRepo;

	@GetMapping
	public List<Orders> findAll() {
		return orderRepo.findAll();
	}
	
	@PostMapping(path="/save")
	public Orders save(@RequestBody Orders order){
		
		ArrayList<String> usernames=new ArrayList<>();
		for (int i=0; i < order.getBasket().size(); i++) {
			Basket basket=order.getBasket().get(i);
			if(usernames.contains(basket.getProduct().getName())) {}else{
			usernames.add(basket.getProduct().getName());
			}
		}
			
			List<Orders> orders=new ArrayList<>();

			for (int i = 0; i < usernames.size(); i++){
				Orders o =new Orders();
				o.setNote(order.getNote());
				o.setCustomer(order.getCustomer());
				double totalPrice=0;
				
				for (int j=0; j < order.getBasket().size(); j++) {
					if( order.getBasket().get(j).getProduct().getName().equals(usernames.get(i))){
						o.getBasket().add(order.getBasket().get(j));
						totalPrice+=order.getBasket().get(j).getProduct().getPrice()*
								order.getBasket().get(j).getCount();
			}
			}
				o.setTotalPrice(totalPrice);
				o.setUsername(usernames.get(i));
				orders.add(o);
			}
			
	
		return orderRepo.save(order);
	}
	
	@GetMapping(path = "/{id}")
	public Orders findById(@PathVariable(name = "id") Integer id) {
		return orderRepo.findById(id).get();
	}
	
	@GetMapping(path = "/{username}")
	public Orders findAllByUsername(@PathVariable(name = "username") String username) {
		return orderRepo.findAllByUsername(username);
	}
	
}
	