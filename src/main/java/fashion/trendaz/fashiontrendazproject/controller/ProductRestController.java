package fashion.trendaz.fashiontrendazproject.controller;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fashion.trendaz.fashiontrendazproject.dto.ProductDTO;
import fashion.trendaz.fashiontrendazproject.entity.Products;
import fashion.trendaz.fashiontrendazproject.file.StorageService;
import fashion.trendaz.fashiontrendazproject.repository.ProductsRepository;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

	@Autowired
	private ProductsRepository productsRepo;
	
	@Autowired
	private ProductDTO productDTO;
	
	@Autowired
	private StorageService storageService;
	
	@PostMapping(path = "/save")
	public Products addProduct (@Valid @RequestBody Products product, BindingResult result ) {
			return productsRepo.save(product);
		}
	
	@GetMapping(path = "/{id}")
	public Products findById(@PathVariable(name = "id") Integer id) {
		return productsRepo.findById(id).get();
	}
	
	
	@PostMapping(path = "/new-product-process")
	public @Valid Products saveProduct(@Valid @RequestBody Products product, 
			BindingResult result,
		@RequestParam(value = "file", required=false) MultipartFile file) {
		if(result.hasErrors()){
			return productsRepo.save(product);
			}
		//product.setImage("product.jpg");
		if(file.isEmpty() && product.getProductId()!=null){
			product.setImage(productDTO.findById(product.getProductId()).get().getImage());}else{
			product.setImage(storageService.store(file));
			}
		productDTO.save(product);

		List<Products> products = productsRepo.findAll();
		return productsRepo.save(product);
	}


	@DeleteMapping(path = "/{id}") 

	public void deleteById(@PathVariable Integer id) {

		productsRepo.deleteById(id);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Products> editProducts(@PathVariable Integer id, @RequestBody Products product) {
        if (!productsRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        product.setProductId(id);
        product = productsRepo.save(product);
        return ResponseEntity.ok(product);
    }
	}

