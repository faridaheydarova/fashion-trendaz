package fashion.trendaz.fashiontrendazproject.service;

import fashion.trendaz.fashiontrendazproject.dto.CustomerDTO; 
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;

public interface CustomerService {

	LoginResponse loginUser(LoginDTO loginDTO);

	String addCustomer(CustomerDTO customerDTO);

	String addCustomers(CustomerDTO customerDTO);

}
