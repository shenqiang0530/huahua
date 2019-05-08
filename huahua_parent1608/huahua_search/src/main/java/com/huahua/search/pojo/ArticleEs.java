package com.huahua.search.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@Document(indexName = "huahua_article",type = "articleEs")
public class ArticleEs implements Serializable {
    private static final long serialVersionUID = 5076534605957319824L;


    private String id;
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;
    private String state;
}
