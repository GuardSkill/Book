package cn.guardskill.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.guardskill.orm.User;
import cn.guardskill.service.UserService;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	//this interface is implement by UserServiceImp (Spring bean)
	private User user;	
	
	/* for AJAX output*/
	 private InputStream inputStream;  
	 /*user login*/
	public String userLogin () throws Exception
	 {
		ActionContext ctx=ActionContext.getContext();//build ActionCtx
		if(!validateLogin())  //input invalid
			{
			addActionMessage("请好好输入");
			return NONE;  
			}
		 User userdata=userService.loginUser(user);
		 if(userdata==null)
			 {
			 addActionMessage("用户名或密码错误");
			 return NONE;	//if login not success
			 }
		 else 
			 {
			 ctx.getSession().put("UID", userdata.getuId());
     		 //put the data to the memory
			  return SUCCESS;
			 }
	 }
	 /*user sign up*/
	public String userAdd () throws Exception
	{
		if (!validateRegister()) {
			addActionMessage("请好好输入");
			return NONE;
		}
		Integer uId = userService.addUser(user);
		if (uId == null) {
			addActionMessage("注册失败");
			return NONE; // if register not success
		} else
		return SUCCESS;
		
	}
	 /*uName validate AJAX*/
	public String userExist() throws IOException
	{
		if(!validateName())
		{
			inputStream=new ByteArrayInputStream("请好好输入"  
					.getBytes("UTF-8"));  
		}
		User existUser =userService.findByName(user.getuName());  
	    //query if this uName is Already exist in database  
		/*get response  	*/	
		inputStream =(existUser==null)? new ByteArrayInputStream("用户名可用"  
	                .getBytes("UTF-8"))  
	            : new ByteArrayInputStream("用户名已存在"  
	                .getBytes("UTF-8"));  
	    return NONE;  
	}
	public String userOut() throws IOException
	{
	ActionContext.getContext().getSession().remove("UID");
	ActionContext.getContext().getSession().remove("PAGE");
    return SUCCESS;  //remove success
	}

	
	protected Boolean validateName()
	{
		if(user.getuName().trim().isEmpty()||user.getuName().length()>15
				||user.getuName().length()<4) return false;
		else return true;
	}
	protected Boolean validateRegister()
	{
		if(user.getuName().trim().isEmpty()||user.getuName().length()>15
		  ||user.getuName().length()<4||user.getuPassword().length()>15
          ||user.getuPassword().length()<4
          ||user.getuPassword().trim().isEmpty()
		  ||user.getuEmail().trim().isEmpty()) return false;
		else return true;
	}
	protected Boolean validateLogin(){ 
		if(user.getuName().trim().isEmpty()||user.getuName().length()>15
		  ||user.getuName().length()<4||user.getuPassword().length()>15
		  ||user.getuPassword().length()<4
		  ||user.getuPassword().trim().isEmpty())  return false;
		else return true;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public InputStream getResult() {
		return inputStream;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
