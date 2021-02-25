package com.zln.personal.service;

import com.zln.personal.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getAll();

    Tag getTagById(int id);

    int addTag(Tag tag);

    int deleteTag(int id);

    int updateTag(Tag tag);
}
