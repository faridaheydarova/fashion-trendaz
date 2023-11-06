package fashion.trendaz.fashiontrendazproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String authority;
	
	public Authority() {
		super();
	}

	public Authority(Integer id, String username, String authority) {
		super();
		this.id = id;
		this.username = username;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", username=" + username + ", authority=" + authority + "]";
	}
	
	

}
