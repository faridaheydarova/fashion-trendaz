package fashion.trendaz.fashiontrendazproject.service.impl;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.dto.UserDTO;
import fashion.trendaz.fashiontrendazproject.entity.User;
import fashion.trendaz.fashiontrendazproject.repository.UserRepository;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.UserService;

@Service
public class UserIMPL implements UserService{
	

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public String addUsers(UserDTO userDTO) {
	User user = new User();
	user.setUserId(userDTO.getId());
	user.setUsername(userDTO.getUsername());
	user.setEmail(userDTO.getEmail());
	

	String encryptedPassword = this.passwordEncoder.encode(userDTO.getPassword());
	user.setPassword(encryptedPassword);
	userRepo.save(user);
	
	return user.getUsername();
		
	}

	@Override
	public LoginResponse loginUser (LoginDTO loginDTO) {
		
		String msg = "";
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if(user1 != null) {
		String password = loginDTO.getPassword();
		String encodePassword = user1.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			
		if(isPwdRight) {
		Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
		if(user.isPresent()) {
	
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
	public List<User> findAll() {
	
		return null;
	}


	@Override
	public LoginResponse loginUser1(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return null;
	}




}