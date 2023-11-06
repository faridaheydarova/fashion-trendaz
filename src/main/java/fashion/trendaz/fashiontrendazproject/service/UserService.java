package fashion.trendaz.fashiontrendazproject.service;

import java.util.List;

import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.dto.UserDTO;
import fashion.trendaz.fashiontrendazproject.entity.User;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;

public interface UserService {

	
	LoginResponse loginUser(LoginDTO loginDTO);

	List<User> findAll();

	String addUsers(UserDTO userDTO);

	String addUser(UserDTO userDTO);

	LoginResponse loginUser1(LoginDTO loginDTO);

}