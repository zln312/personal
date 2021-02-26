package com.zln.personal.entity;

import lombok.Data;

import java.util.List;

@Data
public class ArticleTag {
   private long id;

   private long articleId;

   private int tagId;

   private List<Number> tagIds;
}
