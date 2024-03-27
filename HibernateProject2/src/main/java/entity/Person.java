package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personId;
	private String aadharNo;
	private String name;
	private String email;
	private String address;
	
	public long getPersonId() {
		return personId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
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
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", aadharNo=" + aadharNo + ", name=" + name + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
