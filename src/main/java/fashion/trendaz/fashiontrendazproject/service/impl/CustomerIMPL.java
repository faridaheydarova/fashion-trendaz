package fashion.trendaz.fashiontrendazproject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fashion.trendaz.fashiontrendazproject.dto.CustomerDTO;
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.entity.Customer;
import fashion.trendaz.fashiontrendazproject.entity.User;
import fashion.trendaz.fashiontrendazproject.repository.CustomerRepo;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.CustomerService;


@Service
public class CustomerIMPL implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addCustomer(CustomerDTO customerDTO) {
	Customer customer = new Customer();
	customer.setId(customerDTO.getCustomerId());
	customer.setName(customerDTO.getName());
	customer.setPhone(customerDTO.getPhone());
	
	String encryptedPassword = this.passwordEncoder.encode(customerDTO.getPassword());
	customer.setPassword(encryptedPassword);
	customerRepo.save(customer);
	
	return customer.getName();
	}
	

	@Override
	public LoginResponse loginUser (LoginDTO loginDTO) {
		
		String msg = "";
		Customer customer = customerRepo.findByEmail(loginDTO.getEmail());
		if(customer != null) {
		String password = loginDTO.getPassword();
		String encodePassword = customer.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			
		if(isPwdRight) {
		Optional<Customer> customerr = customerRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
		if(customerr.isPresent()) {
	
		return new LoginResponse( "Giriş uğurludur!",true);
		}else{
			return new LoginResponse("Giriş uğursuzdur!",  false);
		}
		
		}else {
		return new LoginResponse( "Şifrəni düzgün daxil edin.", false);
		}
		} else {
			return new LoginResponse( "Email düzgün daxil edin",  false);
		}
	
	}


	@Override
	public String addCustomers(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
