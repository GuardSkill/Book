package cn.guardskill.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	private List<User> users;	
	private Integer page;   // implement find by page
	private Integer pageop; // implement find by page
	private int op;
	private String param;   // this text is "search for User" 
	/* for AJAX output*/
 private InputStream inputStream;  
	 /*user login*/
	public String loginUser () throws Exception{
		if(!validateLogin())  {//input invalid
			addActionMessage("请输入4~10字符的数据");
			return NONE;  
			}
		 User userNow=userService.loginUser(user);
		 if(userNow==null){
			 addActionMessage("用户名或密码错误");
			 return NONE;	//if login not success
			 }
		 else 
			 {
			 ActionContext.getContext().getSession().put("UID", userNow.getuId());
     		 //put the data to the memory
			 if(userNow.getuType()!=3) return SUCCESS;
			 else return "admin";
			 }
	 }
	 /*user sign up*/
	public String addUser () throws Exception
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
	public String existUser() throws IOException
	{
		if(!validateName())
		{
			inputStream=new ByteArrayInputStream("请输入4~10字符的数据"  
					.getBytes("UTF-8"));  
		}
		else
		{
		User existUser =userService.findByName(user.getuName());  
	    //query if this uName is Already exist in database  
		/*get response  	*/	
		inputStream =(existUser==null)? new ByteArrayInputStream("用户名可用"  
	                .getBytes("UTF-8"))  
	            : new ByteArrayInputStream("用户名已存在"  
	                .getBytes("UTF-8"));
		}
	    return NONE;  
	}
	public String outUser() throws IOException
	{
	ActionContext.getContext().getSession().remove("UID");
	ActionContext.getContext().getSession().remove("PAGE");
    return SUCCESS;  //remove success
	}
	public String showUser() throws IOException
	{
		if(param!=null)		        { //param if isEmpty
			if(!param.trim().isEmpty())  //*.jsp input param isEmpty?
				return findUser();  //if *.jsp is in a finding status
			}
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		user=userService.findByKey(uId);  //get the user's real instance by id
		if(user.getuType()==3)
		{
		pageArithmetic();   //calculate the page the client want
		users=userService.findByPage(page);
		ActionContext.getContext().getSession().put("PAGE",page);
		return SUCCESS;
		}
		else  { addActionMessage("你拥有的权限不正确，请重新登录");	return SUCCESS;}
		//no permission
	}

	public String remvUser() throws IOException{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		User userNow=userService.findByKey(uId);  //get the user's real instance by id
		if(userNow.getuType()==3){
			if(userService.remvUser(user.getuId())){
			addActionMessage("删除成功！");
			return SUCCESS;
			}
			else {
			addActionMessage("用户不存在！");
			return SUCCESS;
			}
		}
		else  { addActionMessage("你拥有的权限不正确，请重新登录");	return SUCCESS;}
}
	public String updateUser() throws IOException{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		User userNow=userService.findByKey(uId);  //get the user's real instance by id
		if(userNow.getuType()==3)
		{
		if(userService.updateUser(user.getuId(),op)) 
			{
			addActionMessage("操作成功");
			return SUCCESS;
			}
		else {
			addActionMessage("该用户已经是最低/高权限了");
			return SUCCESS;
			}
		}
		else { addActionMessage("你拥有的权限不正确，请重新登录");	return SUCCESS;}
	}
	public String findUser() throws IOException
	{
		Integer uId=(Integer) ActionContext.getContext().getSession().get("UID");
		user=userService.findByKey(uId);
		if(user.getuType()==3){
			pageArithmetic();   //calculate the page the client want
			if(param.trim().isEmpty())  addActionMessage("输入为空");	
			 //validate the input
			else users=userService.findPageByNameOrId(page,param);
			ActionContext.getContext().getSession().put("PAGE",page);
			return SUCCESS;
		}
		else { addActionMessage("权限不正确，请重登");	return SUCCESS;}
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
	
	private void pageArithmetic()
	{
		if(page==null) //if *.jsp didn't transfer page to us
		{
		page=(Integer) ActionContext.getContext().getSession().get("PAGE");
		//take page from our memory(if it has been exist)
		if(page==null) page=1; 
		//page first to set up(memory doesn't exist a page)
		else if(pageop!=null) 	
			{
			page+=pageop;  //page operation
			if(page<1) page=1;
			}
		}
	//set the page =1
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
	public List<User> getUsers() {
		return users;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setPageop(Integer pageop) {
		this.pageop = pageop;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getParam() {
		return param;
	}
}
