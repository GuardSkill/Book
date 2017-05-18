package cn.guardskill.action;

import org.apache.struts2.components.File;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.guardskill.orm.Book;
import cn.guardskill.service.GoodService;


public class GoodAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Book good;
	private GoodService goodService;
	private File upload;
	private String uploadName;
	public String newGood()  throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		//take uId from memory
		if(goodService.addGood(good, uId)==null) return NONE;
		else return SUCCESS;
	}
	public String upload() throws Exception{
		
		return SUCCESS;
	}
	
	
	


	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	public Book getGood() {
		return good;
	}

	public void setGood(Book good) {
		this.good = good;
	}
}
