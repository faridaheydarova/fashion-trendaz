package fashion.trendaz.fashiontrendazproject.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerDTO {

	private Integer customerId;
	private String name;
	private String address;
	private String phone;
	private String note;
	private String email;
	private String password;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerDTO(Integer customerId, String name, String address, String phone, String note, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.note = note;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", note=" + note + ", email=" + email + ", password=" + password + "]";
	}
	public CustomerDTO() {
		super();
	}
	
	
	
	
	
	
	
}
