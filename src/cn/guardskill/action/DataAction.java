package cn.guardskill.action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.guardskill.orm.Book;
import cn.guardskill.orm.Info;
import cn.guardskill.orm.User;
import cn.guardskill.service.BookService;
import cn.guardskill.service.InfoService;
import cn.guardskill.service.UserService;

public class DataAction extends ActionSupport {
	private static final long serialVersionUID = 2L;
	private Book book;
	private String param;
	private Integer page;
	private Integer pageop;
	private List<Info> infos=new ArrayList<Info>();
	private List<Book> books=new ArrayList<Book>();
	private BookService bookService;
	private UserService userService;
	private User user;
	private InfoService infoService;
	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}
	public String newBook()  throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		//take uId from memory
		if(bookService.addBook(book, uId)==null) return NONE;
		else return SUCCESS;
	}
	public String  showData() throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		user=userService.findByKey(uId);  //get the user's real instance by id
		int type=user.getuType();
		if(type==3)
		{
			return "admin";
		}
		else //if is not administrator for person
		{
			pageArithmetic();   //page algorithm = = for the right page
			books=bookService.findPage(page);
			//return real example :books
			ActionContext.getContext().getSession().put("PAGE",page);
			if(type==0) return SUCCESS;
			else if(type==1) return "student";
			else return "manager";
		}
	}
	public String  findBook() throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		user=userService.findByKey(uId);
		if(user.getuType()==0)
		{
			pageArithmetic();   //page algorithm = = for the right page
			books=bookService.findPageByNameOrWriter(page, param);
			ActionContext.getContext().getSession().put("PAGE",page);
			//put current page to PAGE
		}
		return SUCCESS;
		
	}
	public String newInfo() throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		if(infoService.newInfo(uId,book.getbId())) return SUCCESS;
		else{
		addActionMessage("借出失败,可能你已经借了了这本书咯,也可能是没书咯- -");
		return NONE;
		}
	}
	public String showInfo() throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		pageArithmetic(); 
		infos=infoService.findPageByUid(page,uId);
		ActionContext.getContext().getSession().put("PAGE",page);
		return SUCCESS;
	}
	
	private void pageArithmetic()
	{
		if(page==null) //if *.jsp didn't transfer page to us
		{
		page=(Integer) ActionContext.getContext().getSession().get("PAGE");
		//take page from our memory
		if(page==null) page=1;  //page first to set up
		else if(pageop!=null) 		page+=pageop;  //page operation
		}
	//set the page =1
	}
	public Book getBook() {
		return book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageop() {
		return pageop;
	}
	public void setPageop(Integer pageop) {
		this.pageop = pageop;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public List<Info> getInfos() {
		return infos;
	}
	public List<Book> getBooks() {
		return books;
	}
}
