package fashion.trendaz.fashiontrendazproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer productId;
	private String name;
	private String description;
	private Long price;
	private Integer stockCount;
	private Integer categoryId;
	private String picture;
	private String specification;
	
	public Products() {
		super();
	}

	public Products(Integer productId, String name, String description, Long price, Integer stockCount,
			Integer categoryId, String picture, String specification) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockCount = stockCount;
		this.categoryId = categoryId;
		this.picture = picture;
		this.specification = specification;
	}

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

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", stockCount=" + stockCount + ", categoryId=" + categoryId + ", picture=" + picture
				+ ", specification=" + specification + "]";
	}
	
	
	
	
	
	
	
}
