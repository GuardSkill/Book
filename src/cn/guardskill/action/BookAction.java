package cn.guardskill.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.guardskill.orm.Book;
import cn.guardskill.service.BookService;

public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 2L;
	private Book book;
	private BookService bookService;
	
	public String newBook()  throws Exception{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		//take uId from memory
		if(bookService.addBook(book, uId)==null) return NONE;
		else return SUCCESS;
	}
	public String upload() throws Exception{
		
		return SUCCESS;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
