package cn.guardskill.service;

import java.util.List;

import cn.guardskill.orm.User;

public interface UserService
{
	Integer  addUser(User user);
	User findByKey(Integer uName);
	User findByName(String uName);
	User  loginUser(User user);
	List<User> findByPage(Integer pageNo);
	boolean updateUser(Integer uId,int op);
	boolean remvUser(Integer uId);
	List<User> findPageByNameOrId(int page,String param);
}