package fashion.trendaz.fashiontrendazproject.dto;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import fashion.trendaz.fashiontrendazproject.entity.Products;

@Component
public class ProductDTO {

	private Integer productId;
	private String name;
	private String description;
	private Long price;
	private Integer stockCount;
	private Integer categoryId;
	private String picture;
	private String specification;
	private String image;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stockCount=" + stockCount + ", categoryId=" + categoryId + ", picture=" + picture
				+ ", specification=" + specification + ", image=" + image + "]";
	}
	public Optional<Products> findById(Integer productId2) {
		// TODO Auto-generated method stub
		return null;
	}
	public void save(@Valid Products product) {
		// TODO Auto-generated method stub
		
	}
	
	
}
