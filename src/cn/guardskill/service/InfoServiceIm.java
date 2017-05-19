package cn.guardskill.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.guardskill.dao.BookDao;
import cn.guardskill.dao.InfoDao;
import cn.guardskill.dao.UserDao;
import cn.guardskill.orm.Book;
import cn.guardskill.orm.Info;
import cn.guardskill.orm.User;
@Transactional
public class InfoServiceIm implements InfoService{
	private InfoDao infoDao;
	private UserDao userDao;
	private BookDao bookDao;
	private User user;
	private Book book;
	private Info info;
	
	public boolean newInfo(Integer uid,Integer bid)  //new  Borrow information
	{
		if(ifAlreadyExist(uid,bid)==true) return false;
		book=bookDao.get(Book.class, bid);
		if(book.getbNownum()==0) return false;
		user=userDao.get(User.class, uid);
		info=new Info();
		info.setiBook(book);
		info.setiUser(user);
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
		info.setiFirstTime(date);
		info.setiReturnTime(new Date(date.getTime()+30*24*60*60*1000));
		info.setiStatus(1);
		book.setbNownum(book.getbNownum()-1);  //nownum -1
		System.out.println(book.getbNownum());
		bookDao.save(book);
		userDao.save(user);
		infoDao.save(info);
		return true;
		
	}
	public List<Info> findPageByUid(Integer pageNo,Integer uId)
	{
		return infoDao.findAllByPage(pageNo,5,uId);
	}
	public boolean ifAlreadyExist(Integer uid,Integer bid)
	{
		if(infoDao.ifInfoExit(uid,bid)==false) return false;  //if info is Exist
		else return true;
        
	}
	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
