package com.zln.personal.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
public class Article {

    private Long id;

    @NotNull(message="title cannot be null")
    private String title;

    @NotNull(message="content cannot be null")
    private String content;

//    @NotNull(message="createTime cannot be null")
    private Long createTime;

//    @NotNull(message="updateTime cannot be null")
    private Long updateTime;

//    @NotNull(message="intro cannot be null")
    private String intro;

    private String cover;

    private String tagName;

    private List<Number> tagIds;

}
