package com.huahua.gathering.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huahua.gathering.pojo.Gathering;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering>{
	Gathering findOneById(String id);


	Page<Gathering> findAllByCity(String city, Pageable pageable);
}
