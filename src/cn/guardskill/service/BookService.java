package cn.guardskill.service;

import cn.guardskill.orm.Book;

public interface BookService {
	Integer  addBook(Book book,Integer uId);
	Book findByKey(Integer uName);
	Book findByName(String uName);
}
