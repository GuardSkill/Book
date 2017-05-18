package cn.guardskill.service;

import cn.guardskill.orm.Book;

public interface GoodService {
	Integer  addGood(Book good,Integer uId);
	Book findByKey(Integer uName);
	Book findByName(String uName);
}
