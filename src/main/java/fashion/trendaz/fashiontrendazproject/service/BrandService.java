package fashion.trendaz.fashiontrendazproject.service;

import java.util.List;

import fashion.trendaz.fashiontrendazproject.dto.BrandDTO;
import fashion.trendaz.fashiontrendazproject.dto.LoginDTO;
import fashion.trendaz.fashiontrendazproject.entity.Brand;
import fashion.trendaz.fashiontrendazproject.response.LoginResponse;

public interface BrandService {

	String addBrand(BrandDTO brandDTO);

	List<Brand> findAll();

	LoginResponse loginBrand(LoginDTO loginDTO);

}
