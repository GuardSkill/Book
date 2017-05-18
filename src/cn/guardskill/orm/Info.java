package cn.guardskill.orm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Info")
public class Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iId;
	private Date iFirstTime;
	private Date iReturnTime;
	private Integer iStatus;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="i_uId",referencedColumnName="uId",nullable=false)
	//join Column "i_uId" to table "Info" & link 'uId" from user table to "i_uId"
	private User iUser;  //the column is i_uId in database 
	
	@ManyToOne(targetEntity=Book.class)
	@JoinColumn(name="i_bId",referencedColumnName="bId",nullable=false)
	private Book iBook;   ////the column is i_bId in database 

	public Integer getiId() {
		return iId;
	}

	public void setiId(Integer iId) {
		this.iId = iId;
	}

	public Date getiFirstTime() {
		return iFirstTime;
	}

	public void setiFirstTime(Date iFirstTime) {
		this.iFirstTime = iFirstTime;
	}

	public Date getiReturnTime() {
		return iReturnTime;
	}

	public void setiReturnTime(Date iReturnTime) {
		this.iReturnTime = iReturnTime;
	}

	public Integer getiStatus() {
		return iStatus;
	}

	public void setiStatus(Integer iStatus) {
		this.iStatus = iStatus;
	}

	public User getiUser() {
		return iUser;
	}

	public void setiUser(User iUser) {
		this.iUser = iUser;
	}

	public Book getiBook() {
		return iBook;
	}

	public void setiBook(Book iBook) {
		this.iBook = iBook;
	}
}
