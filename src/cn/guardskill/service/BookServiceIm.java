package cn.guardskill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.guardskill.dao.BookDao;
import cn.guardskill.dao.UserDao;
import cn.guardskill.orm.Book;
import cn.guardskill.orm.User;
@Transactional
public class BookServiceIm  implements  BookService{
	private BookDao bookDao;
	private UserDao userDao;
	private User user;
	@Override
	public Integer  addBook(Book book,Integer uId) {
		user=userDao.get(User.class, uId);
		if(user==null||user.getuType()!=2)
		{
			System.out.println("uId Error|database error");
			return null;
		}
		if(book.getbName().trim().isEmpty()||book.getbWriter().trim().isEmpty()
				||book.getbWriter().length()>20||book.getbName().length()>30
				||book.getbPress().length()>20||book.getbDesc().length()>100
				||book.getbPress().trim().isEmpty()||book.getbDesc().trim().isEmpty()
				||book.getbMaxnum()==null) return null;
		//some codes need to be accomplish：check out if Exist a Book 
		book.setbHot(0);
		book.setbStatus(1);
		book.setbNownum(book.getbMaxnum());
		return (Integer) bookDao.save(book);
	}
	public boolean  remvBook(Integer bId,Integer uId) {
		user=userDao.get(User.class, uId);
		if(user==null||user.getuType()!=2)
		{
			System.out.println("uId Error|database error");
			return false;
		}
		Book book=bookDao.get(Book.class, bId);
		if(book.getbNownum()<book.getbMaxnum()) return false;
		//If there is some books doesn't return to library 
		bookDao.delet(Book.class,bId);
		return true;
	}
	@Override
	public List<Book> findbyPage(Integer pageNo) {
		return bookDao.findAllByPage(Book.class,pageNo,5);
	}
	public List<Book> findPageByNameOrWriter(Integer pageNo,String param)
	{
		return  bookDao.findPageByNameOrWriter(pageNo, 5, param);	
	}
	public List<Book> findPageByNameOrId(Integer pageNo,String param)
	{
	return bookDao.findPageByNameOrId(pageNo, 5, param);
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
