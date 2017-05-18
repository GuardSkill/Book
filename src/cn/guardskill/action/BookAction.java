package cn.guardskill.action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.guardskill.orm.Book;
import cn.guardskill.orm.User;
import cn.guardskill.service.BookService;
import cn.guardskill.service.UserService;

public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 2L;
	private Book book;
	private List<Book> books=new ArrayList<Book>();
	private BookService bookService;
	public List<Book> getBooks() {
		return books;
	}
	private UserService userService;
	private User user;
	public String newBook()  throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		//take uId from memory
		if(bookService.addBook(book, uId)==null) return NONE;
		else return SUCCESS;
	}
	public String  showData() throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		user=userService.findByKey(uId);
		if(user.getuType()==0)
		{
			books=bookService.findPage(1);
		}
		return SUCCESS;
	
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
}
