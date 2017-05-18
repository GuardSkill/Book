package cn.guardskill.orm;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //generate type��auto+1
	private Integer bId;
	private String bName;
	private String bWriter;
	private String bPress;
	private String bDesc;
	private Integer bNownum;
	private Integer bMaxnum;
	private Integer bHot;
	private Integer bStatus;
	@OneToMany(targetEntity=Info.class,mappedBy="iBook")  
	private Set<Info> gInfo;
	
	
	
	//setter & getter
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbPress() {
		return bPress;
	}
	public void setbPress(String bPress) {
		this.bPress = bPress;
	}
	public String getbDesc() {
		return bDesc;
	}
	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}
	public Integer getbNownum() {
		return bNownum;
	}
	public void setbNownum(Integer bNownum) {
		this.bNownum = bNownum;
	}
	public Integer getbMaxnum() {
		return bMaxnum;
	}
	public void setbMaxnum(Integer bMaxnum) {
		this.bMaxnum = bMaxnum;
	}
	public Integer getbHot() {
		return bHot;
	}
	public void setbHot(Integer bHot) {
		this.bHot = bHot;
	}
	public Integer getbStatus() {
		return bStatus;
	}
	public void setbStatus(Integer bStatus) {
		this.bStatus = bStatus;
	}
	public Set<Info> getgInfo() {
		return gInfo;
	}
	public void setgInfo(Set<Info> gInfo) {
		this.gInfo = gInfo;
	}
}
