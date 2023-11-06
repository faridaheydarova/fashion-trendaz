package fashion.trendaz.fashiontrendazproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String password;
	
	public Brand() {
		super();
	}

	public Brand(Integer brandId, String name, String username, String email, String phone, String password) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + "]";
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
