package cn.guardskill.service;

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

	@Override
	public Book findByKey(Integer uName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByName(String uName) {
		// TODO Auto-generated method stub
		return null;
		
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
