package cn.guardskill.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.guardskill.dao.UserDao;
import cn.guardskill.orm.User;
@Transactional
public class UserServiceIm implements UserService{
	User user;
	private UserDao userDao;  //userDao interface implement reply UserHibernate by spring bean
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Integer addUser(User user) {	
		//subtract " " and calculate  if empty
		User test=userDao.getByName(User.class,user.getuName());
		if(test!=null) return null;  //the name already exist 
		else 
			{
			user.setuType(1);    //设置用户初始权限
			return (Integer) userDao.save(user);
			}	
	}
	public User loginUser(User user) {
		User userdata=userDao.getByNameAndPass(user.getuName(),user.getuPassword());
		if(userdata==null) 	return null;
		//user name or password isn't right
		else return userdata;
		
	}

	@Override
	public User findByKey(Integer uId) {
		return userDao.get(User.class,uId);
	}
	public User findByName(String uName)
	{
		return userDao.getByName(User.class, uName);
	}

	@Override
	public List<User> findByPage(Integer pageNo) {
		return userDao.findAllByPage(User.class,pageNo,5);  //every page 5 datas
	}

	@Override
	public boolean updateUser(Integer uId, int op) {
		user=userDao.get(User.class, uId);
		int temp=user.getuType()+op;
		if(-1<temp&&temp<4)
		{
		user.setuType(temp);
		return true;
		}
		else return false;
	}

	@Override
	public boolean remvUser(Integer uId) {
		user=userDao.get(User.class, uId);
		if(user!=null)
		{
		userDao.delet(User.class, uId);
		return true;
		}
		else return false;
	}
	public List<User> findPageByNameOrId(int page,String param){
		return userDao.findPageByNameOrId(page, 5, param);
	}
}
