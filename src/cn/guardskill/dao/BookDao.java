package cn.guardskill.dao;

import java.util.List;

import cn.guardskill.orm.Book;

public interface BookDao extends BaseDao<Book>{
	public List<Book> findAllByPage(int pageNo,int pageSize);
}