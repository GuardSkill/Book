package cn.guardskill.orm;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uId;
	private String uName;
	private String uPassword;
	private String uEmail;
	private Integer uType;
	@OneToMany(targetEntity=Info.class,mappedBy="iUser")  
	private Set<Info> uInfos;
	
	
	
	
	//setter a& getter
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public Integer getuType() {
		return uType;
	}
	public void setuType(Integer uType) {
		this.uType = uType;
	}
	public Set<Info> getuInfos() {
		return uInfos;
	}
	public void setuInfos(Set<Info> uInfos) {
		this.uInfos = uInfos;
	}
}
