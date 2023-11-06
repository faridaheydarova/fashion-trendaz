package fashion.trendaz.fashiontrendazproject.controller;

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
import org.springframework.web.bind.annotation.RestController;

import fashion.trendaz.fashiontrendazproject.entity.Products;
import fashion.trendaz.fashiontrendazproject.repository.ProductsRepository;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

	@Autowired
	private ProductsRepository productsRepo;
	
	@PostMapping(path = "/save")
	public Products addProduct (@Valid @RequestBody Products product, BindingResult result ) {
			return productsRepo.save(product);
		}
	
	@GetMapping(path = "/{id}")
	public Products findById(@PathVariable(name = "id") Integer id) {
		return productsRepo.findById(id).get();
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

