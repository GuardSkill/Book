package cn.guardskill.service;

import java.util.List;

import cn.guardskill.orm.Info;

public interface InfoService {

	boolean newInfo(Integer uid,Integer bid);
	boolean ifAlreadyExist(Integer uid,Integer bid);
	List<Info> findPageByUid(Integer pageNo,Integer uId);
	boolean removeInfo(Integer iId);
}
