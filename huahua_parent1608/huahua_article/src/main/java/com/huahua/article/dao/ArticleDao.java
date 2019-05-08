package com.huahua.article.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huahua.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
	Article findOneById(String id);

	//@Modifying 如果直接执行增删改的方法，需要加上modifying的注解 否则不起效果

	@Modifying
	@Query(value = "update tb_article set thumbup = thumbup+1 where id=?",nativeQuery = true)
	void updateArticleThumbup(String id);

	@Query(nativeQuery = true,value = "select * from tb_channel , tb_article where tb_channel.id = tb_article.channelid order by createtime desc")
    Page<Article> channel(String labelid, PageRequest pageRequest);

	@Query(nativeQuery = true,value = "select * from tb_column , tb_article where tb_column.id = tb_article.columnid")
	Page<Article> column(String labelid, PageRequest pageRequest);

	@Query(nativeQuery = true,value = "select * from tb_article where  istop = 1 order by thumbup desc ")
	List<Article> findByisTop();
}
