package com.zln.personal.controller;

import com.zln.personal.entity.Tag;
import com.zln.personal.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/tag")
public class TagController {

    private TagService tagService;
    @Autowired
    TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getTagList(){
        return tagService.getAll();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable int id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public int addTag(@RequestBody @Validated Tag tag) {
        return tagService.addTag(tag);
    }

    @PutMapping
    public int updateTag(@RequestBody @Validated Tag tag) {
        return tagService.updateTag(tag);
    }

    @DeleteMapping("/{id}")
    public int deleteTag(@PathVariable int id){
        return tagService.deleteTag(id);
    }
}
