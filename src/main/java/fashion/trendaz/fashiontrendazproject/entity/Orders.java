package fashion.trendaz.fashiontrendazproject.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String note;
	@CreationTimestamp
	private Timestamp register;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;
	@OneToMany(mappedBy = "order")
	private List<Basket> basket;
	private Double totalPrice;
	private String status;
	private String username;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public Timestamp getRegister() {
		return register;
	}



	public void setRegister(Timestamp register) {
		this.register = register;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Products getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product = product;
	}



	public List<Basket> getBasket() {
		return basket;
	}



	public void setBasket(List<Basket> basket) {
		this.basket = basket;
	}



	public Double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "Orders [id=" + id + ", note=" + note + ", register=" + register + ", customer=" + customer
				+ ", product=" + product + ", basket=" + basket + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", username=" + username + "]";
	}
	
	
	
}