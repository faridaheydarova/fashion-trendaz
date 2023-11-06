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

import fashion.trendaz.fashiontrendazproject.dto.UserDTO;
import fashion.trendaz.fashiontrendazproject.entity.User;
import fashion.trendaz.fashiontrendazproject.repository.UserRepository;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.UserService;

@RestController
	@RequestMapping(path="/users")
	@CrossOrigin(origins = "*")

	public class UserController {

		@Autowired
		private UserService userService;
		
		@Autowired
		private UserRepository userRepo;
		
		@Autowired
		private AuthorityRepository authorityRepo;
		

		
		@PreAuthorize("hasRole('ADMIN')")
		@PostMapping(path = "/save")
		public String saveUser(@RequestBody UserDTO userDTO, HttpServletRequest request){ 
			String id = userService.addUser(userDTO);
			
			Authority authority = new Authority();
			authority.setUsername(userDTO.getUsername());
			authority.setAuthority("ADMIN");
			authorityRepo.save(authority);
			
			return id;
	}
		

		@PostMapping(path="/login")
		public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
		LoginResponse loginResponse = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);

		}
		
		@GetMapping
		public List<User> findAll(){
			
			return userRepo.findAll();
			
		}
}
