package cn.guardskill.dao;

import java.util.List;

import cn.guardskill.orm.User;

public interface UserDao extends BaseDao<User>{
	User getByNameAndPass(String name,String pass);
	User getByName(Class<User> entityClazz,String name);
	List<User> findPageByNameOrId(int pageNo,int pageSize,String param);
}