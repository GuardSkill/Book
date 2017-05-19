package cn.guardskill.dao;
import java.util.List;

import cn.guardskill.orm.Info;

public interface InfoDao extends BaseDao<Info>{
	 boolean ifInfoExit(Integer uid,Integer bid);
	 List<Info> findAllByPage(int pageNo,int pageSize,Integer uId);
}
