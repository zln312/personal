package com.zln.personal.service;

import com.zln.personal.entity.Tag;
import com.zln.personal.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TagServiceImpl implements TagService{

    private TagMapper tagMapper;
    @Autowired
    public void getTagMapper(TagMapper tagMapper){
        this.tagMapper = tagMapper;
    }

    @Override
    public List<Tag> getAll() {
        return tagMapper.getAll();
    }

    @Override
    public Tag getTagById(int id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public int addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public int deleteTag(int id) {
        return tagMapper.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }
}
