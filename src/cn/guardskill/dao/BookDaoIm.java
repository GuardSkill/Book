package cn.guardskill.dao;

import java.util.List;

import org.hibernate.Query;

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
	@SuppressWarnings("unchecked")
	public List<Book> findNameOrWriterByPage(int pageNo,int pageSize,String param)
	{
		String hql = "from Book where bName like :name or bWriter like :name";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql)
				.setString("name", "%"+param+"%"); 
		return query.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize).list();
        /*
			hql="from Book where bId =?0";
			query = getSessionFactory().getCurrentSession().createQuery(hql)
					.setParameter(0,id); 
			return query.setFirstResult((pageNo-1)*pageSize)
					.setMaxResults(pageSize).list();
		*/
		
		//setFirstResult： the first result to start query 
		//the max number of results
	}

}
