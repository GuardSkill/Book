package cn.guardskill.dao;

import java.util.List;
import cn.guardskill.orm.User;


public class UserDaoIm extends UniversalDaoIm<User> implements UserDao
{
	public User getByName(Class<User> entityClazz,String name)
	{
		/*
		String hql = "from User where uName = ? ";  
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);  
        query.setParameter(0, name);  
        return (User)query.uniqueResult();  */
		List<User> users=find("from User where uName = ?0 ",name);
		if(users!=null&&users.size()==1)
		{
			return users.get(0);
		}
        return null;
	}
	public User getByNameAndPass(String name,String pass)
	{
		/*
		String hql = "from User where uName = ? and uPassword = pass";  
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);  
        query.setParameter(0, name);  
        query.setParameter(0, pass);
        return (User)query.uniqueResult();  */	
		List<User> users=find("from User where uName = ?0 and uPassword =?1 "
				,name,pass);
		if(users!=null&&users.size()==1)
		{
			return users.get(0);
		}
		else return null;
	}
	public List<User> findPageByNameOrId(int pageNo,int pageSize,
			String param) 
	{
		String hql;
		if(isNum(param)){  //if all char is a N+
			 hql = "from User where uId =?0 or uName=?1 ";
			 return findByPage(hql,pageNo,pageSize,Integer.parseInt(param),param);
		}
		else{
			hql="from User where uName=?0";
			return findByPage(hql,pageNo,pageSize,param);
		}
	}
}
