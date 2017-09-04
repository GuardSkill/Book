package cn.guardskill.service;

import java.util.List;

import cn.guardskill.orm.Book;

public interface BookService {
	Integer  addBook(Book book,Integer uId);
	boolean  remvBook(Integer bId,Integer uId);
	List<Book> findbyPage(Integer pageNo);
	List<Book> findPageByNameOrWriter(Integer pageNo,String param);
	List<Book> findPageByNameOrId(Integer pageNo,String param);
}
