package cn.guardskill.dao;

import java.util.List;

import cn.guardskill.orm.Book;


public class BookDaoIm extends UniversalDaoIm<Book>
implements BookDao
{
	@SuppressWarnings("unchecked")
	public List<Book> findAllByPage(int pageNo,int pageSize) 
	 {
		String hql = "from Book";
		return getSessionFactory().getCurrentSession().createQuery(hql).
				setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
    }
}
