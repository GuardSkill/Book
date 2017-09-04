package cn.guardskill.dao;

import java.util.List;

import org.hibernate.Query;

import cn.guardskill.orm.Book;


public class BookDaoIm extends UniversalDaoIm<Book>
implements BookDao
{
	@SuppressWarnings("unchecked")
	public List<Book> findPageByNameOrWriter(int pageNo,int pageSize,String param)
	{
		String hql = "from Book where bName like :name or bWriter like :name";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql)
				.setString("name", "%"+param+"%"); 
		return query.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize).list();	
		//setFirstResult： the first result to start query 
		//the max number of query's results
	}
	public List<Book> findPageByNameOrId(int pageNo,int pageSize,String param)
	{
		String hql;
		if(isNum(param)){  //if all char is a N+
			 hql = "from Book where  bId =?0 or bName like ?1 ";
			 return findByPage(hql,pageNo,pageSize,Integer.parseInt(param),
					 '%' + param + '%');
		}
		else{
			hql="from Book where bName like ?0";
			return findByPage(hql,pageNo,pageSize,'%' + param + '%');
		}
	}
}
