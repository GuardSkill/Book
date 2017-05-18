package cn.guardskill.service;

import java.util.List;

import cn.guardskill.orm.Book;

public interface BookService {
	Integer  addBook(Book book,Integer uId);
	List<Book> findPage(Integer pageNo);
}
