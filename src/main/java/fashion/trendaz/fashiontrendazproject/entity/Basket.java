package fashion.trendaz.fashiontrendazproject.entity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="basket")
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer count;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Products product;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Basket [id=" + id + ", count=" + count + ", product=" + product + "]";
	}
	
	
	
	}
	

