package com.huahua.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huahua.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
	User findOneById(String id);

	/*
	* 通过手机号查询用户信息
	* */
	User findByMobile(String mobile);

	@Modifying
	@Query(nativeQuery = true,value = "update tb_user set followcount = followcount+?2 where id=?1")
    void incfollowCount(String userid, Integer num);

	@Modifying
	@Query(nativeQuery = true,value = "update tb_user set fans count = followcount+?2 where id=?1")
	void incfansCount(String userid, Integer num);
}
