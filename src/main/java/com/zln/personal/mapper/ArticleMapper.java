package com.zln.personal.mapper;

import com.zln.personal.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ArticleMapper {

    @Select("select * from article")
    @ResultType(Article.class)
    List<Article> findAll();

    @Select("select * from article where id=#{id}")
    Article findArticleById(long id);

    @Select("select * from article where tag=#{tag}")
    Article findArticleByTag(int tag);

    @Insert("INSERT INTO article (title,content,create_time,update_time,tag,intro,cover)VALUES" +
            "(#{title},#{content},#{createTime},#{updateTime},#{tag},#{intro},#{cover})")
    int addArticle(Article article);

    @Update("UPDATE article SET title = #{title},content= #{content}," +
            "create_time=#{createTime}," +
            "update_time=#{updateTime},tag=#{tag},intro=#{intro},cover=#{cover} where id=#{id}")
    int updateArticle(Article article);

    @Delete("DELETE FROM article where id = #{id}")
    int deleteArticle(long id);
}
