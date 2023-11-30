package fashion.trendaz.fashiontrendazproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fashion.trendaz.fashiontrendazproject.dto.CustomerDTO;
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.entity.Authority;
import fashion.trendaz.fashiontrendazproject.entity.Customer;

import fashion.trendaz.fashiontrendazproject.repository.AuthorityRepository;
import fashion.trendaz.fashiontrendazproject.repository.CustomerRepo;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.CustomerService;


@RestController
@RequestMapping(path="/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AuthorityRepository authorityRepo;
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@PostMapping(path = "/save")
	public String saveCustomer(@RequestBody CustomerDTO customerDTO, HttpServletRequest request){ 
		String customername = customerService.addCustomer(customerDTO);
		
		Authority authority = new Authority();
	
		authority.setUsername(customerDTO.getName());
		authority.setAuthority("CUSTOMER");
		authorityRepo.save(authority);
		
		return customername ;
}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
	LoginResponse loginResponse = customerService.loginUser(loginDTO);
	return ResponseEntity.ok(loginResponse);

	}
	
	@GetMapping
	public List<Customer> findAll(){
		
		return customerRepo.findAll();
		
	}
}

