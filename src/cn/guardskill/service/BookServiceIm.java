package cn.guardskill.service;

import java.util.List;

import cn.guardskill.dao.BookDao;
import cn.guardskill.dao.UserDao;
import cn.guardskill.orm.Book;
import cn.guardskill.orm.User;

public class BookServiceIm  implements  BookService{
	private BookDao bookDao;
	private UserDao userDao;
	private User user;
	@Override
	public Integer  addBook(Book book,Integer uId) {
		user=userDao.get(User.class, uId);
		if(user==null)
		{
			System.out.println("uId Error|database error,No  user with the uId");
			return null;
		}
		return (Integer) bookDao.save(book);
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


	@Override
	public List<Book> findPage(Integer pageNo) {
		return bookDao.findAllByPage(pageNo,5);
	}

}
