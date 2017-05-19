package cn.guardskill.dao;

import java.util.List;

import org.hibernate.Query;

import cn.guardskill.orm.Book;
import cn.guardskill.orm.Info;


public class InfoDaoIm extends UniversalDaoIm<Info> implements InfoDao
{
	List<Info> infos;

	@Override
	public boolean ifInfoExit(Integer uid, Integer bid) {
		infos=find("from Info where i_uId = ?0 and i_bId=?1",uid,bid);
		if(infos.size()==0) return false;
		else return true;
	}
	@SuppressWarnings("unchecked")
	public List<Info> findAllByPage(int pageNo,int pageSize,Integer uId) 
	 {
		String hql = "from Info where i_uId = ?";
		Query query=getSessionFactory().getCurrentSession().createQuery(hql)
				.setParameter(0, uId);
		return query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
   }
}
