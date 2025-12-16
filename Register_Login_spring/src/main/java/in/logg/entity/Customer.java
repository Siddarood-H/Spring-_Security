package in.logg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String name;
	private String email;
	private String password;
	private Long phoNo;
	
	public Customer(Integer cId, String name, String email, String password, Long phoNo) {
		super();
		this.cId = cId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoNo = phoNo;
	}
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getPhoNo() {
		return phoNo;
	}
	public void setPhoNo(Long phoNo) {
		this.phoNo = phoNo;
	}

}
