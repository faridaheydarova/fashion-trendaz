package fashion.trendaz.fashiontrendazproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=30,message="Maksimum 30 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(30)")
	private String name;
	
	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=200,message="Maksimum 200 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(200)")
	private String address;
	
	@Pattern(regexp="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}",message="Telefonu düzgün formatdaa yazın: 000-000-0000")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(20)")
	private String phone;
	
	@NotEmpty(message="Boş qoymaq olmaz")
	@Email(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message="Emaili düzgün formada yazın")
	@Size(max=100,message="Maksimum 100 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(100)")
	private String email;
	
	@Size(max=100,message="Maksimum 100 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(100)")
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}

