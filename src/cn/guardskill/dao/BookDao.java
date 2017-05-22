package cn.guardskill.dao;

import java.util.List;

import cn.guardskill.orm.Book;

public interface BookDao extends BaseDao<Book>{
	List<Book> findPageByNameOrWriter(int pageNo,int pageSize,String param);
	List<Book> findPageByNameOrId(int pageNo,int pageSize,String param);
}