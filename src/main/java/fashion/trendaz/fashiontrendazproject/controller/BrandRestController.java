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

import fashion.trendaz.fashiontrendazproject.dto.BrandDTO;
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.entity.Authority;
import fashion.trendaz.fashiontrendazproject.entity.Brand;
import fashion.trendaz.fashiontrendazproject.repository.AuthorityRepository;
import fashion.trendaz.fashiontrendazproject.repository.BrandRepo;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.BrandService;


@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "*")
public class BrandRestController {
	
	@Autowired
	private AuthorityRepository authorityRepo;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private BrandRepo brandRepo;
	
	@PreAuthorize("hasRole('BRAND')")
	@PostMapping(path = "/save")
	public String addBrand(@RequestBody BrandDTO branDto,HttpServletRequest request ) {
	String id = brandService.addBrand(branDto);
		
		Authority authority = new Authority();
		authority.setUsername(branDto.getUsername());
		authority.setAuthority("BRAND");

		authorityRepo.save(authority);
		
		return id;
	
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> loginBrand(@RequestBody LoginDTO loginDTO){
	LoginResponse loginResponse = brandService.loginBrand(loginDTO);
	return ResponseEntity.ok(loginResponse);

	}
	
	@GetMapping
	public List<Brand> findAll(){
		
		return brandRepo.findAll();
		
	}
}
	

