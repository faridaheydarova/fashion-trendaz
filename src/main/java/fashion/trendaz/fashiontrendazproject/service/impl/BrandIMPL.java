package fashion.trendaz.fashiontrendazproject.service.impl;


import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fashion.trendaz.fashiontrendazproject.dto.BrandDTO;
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.entity.Brand;
import fashion.trendaz.fashiontrendazproject.repository.BrandRepo;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;
import fashion.trendaz.fashiontrendazproject.service.BrandService;


@Service
public class BrandIMPL implements BrandService{

	@Autowired
	private BrandRepo brandRepo;
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public String addBrand(BrandDTO brandDTO) {
	Brand brand = new Brand();
	brand.setBrandId(brandDTO.getBrandId());
	brand.setName(brandDTO.getName());
	brand.setUsername(brandDTO.getUsername());
	brand.setEmail(brandDTO.getEmail());
	brand.setPhone(brandDTO.getPhone());
	
	String encryptedPassword = this.passwordEncoder.encode(brandDTO.getPassword());
	brand.setPassword(encryptedPassword);
	brandRepo.save(brand);
	
	return brand.getName();
	
	}
	
	@Override
	public List<Brand> findAll() {
	
		return null;
	}
	
	@Override
	public LoginResponse loginBrand (LoginDTO loginDTO) {
		
		String msg = "";
		Brand brand = brandRepo.findByEmail(loginDTO.getEmail());
		if(brand != null) {
		String password = loginDTO.getPassword();
		String encodePassword = brand.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			
		if(isPwdRight) {
		Optional<Brand> brand1 = brandRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
		if(brand.isPresent()) {
	
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

	
}
