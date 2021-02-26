package com.zln.personal.mapper;

import com.zln.personal.entity.ArticleTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleTagMapper {

    @Insert({
            "<script>",
            "insert into article_tag(article_id,tag_id) values ",
            "<foreach collection='tagIds' item='item' index='index' separator=','>",
            "(#{articleId},#{item})",
            "</foreach>",
            "ON DUPLICATE KEY UPDATE article_id=VALUES(article_id),tag_id=VALUES(tag_id)",
            "</script>"
    })
    int addArticleTag(@Param(value = "articleId") long articleId, @Param(value = "tagIds") List<Number> tagId);

    @Select("SELECT GROUP_CONCAT(tag_id SEPARATOR ',') tag_ids from article_tag" +
            " WHERE article_id = #{articleId} GROUP BY article_id")
    String getTagIdsByArtId(long articleId);

    @Delete("DELETE FROM article_tag WHERE article_id = #{articleId}")
    int deleteArticleTagByArtId(long articleId);
}
