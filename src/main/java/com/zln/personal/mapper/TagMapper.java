package com.zln.personal.mapper;

import com.zln.personal.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {

    @Select("select id,name from tag")
    @ResultType(Tag.class)
    List<Tag> getAll();

    @Select("select id,name from tag where id = #{id}")
    Tag getTagById(int id);

    @Insert("insert into tag (name) values (#{name})")
    int addTag(Tag tag);

    @Update("update tag set name = #{name} where id = #{id}")
    int updateTag(Tag tag);

    @Delete("delete from tag where id = #{id}")
    int deleteTag(int id);


}
