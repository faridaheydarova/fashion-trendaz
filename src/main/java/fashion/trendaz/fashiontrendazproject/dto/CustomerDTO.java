package fashion.trendaz.fashiontrendazproject.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerDTO {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	private String name;
	private String description;
	public CustomerDTO(Integer categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}
	public CustomerDTO() {
		super();
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	@Override
	public String toString() {
		return "CustomerDTO [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
