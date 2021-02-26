package com.zln.personal.mapper;

import com.zln.personal.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ArticleMapper {

    @Select("SELECT article.*,GROUP_CONCAT(tag.`name` SEPARATOR ',') tag_name FROM article " +
            "LEFT JOIN article_tag on article.id = article_tag.article_id " +
            "LEFT JOIN tag on article_tag.tag_id = tag.id " +
            "GROUP BY article.id " +
            "order by update_time DESC")
    @ResultType(Article.class)
    List<Article> findAll();

    @Select("SELECT * from article where article.id=#{id}")
    Article findArticleById(long id);

    @Insert("INSERT INTO article (title,content,create_time,update_time,intro,cover)VALUES" +
            "(#{title},#{content},#{createTime},#{updateTime},#{intro},#{cover})")
    @Options(useGeneratedKeys = true, keyProperty = "id" ,keyColumn = "id")
    int addArticle(Article article);

    @Update("UPDATE article SET title = #{title},content= #{content}," +
            "create_time=#{createTime}," +
            "update_time=#{updateTime},intro=#{intro},cover=#{cover} where id=#{id}")
    int updateArticle(Article article);

    @Delete("DELETE FROM article where id = #{id}")
    int deleteArticle(long id);
}
