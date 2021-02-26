package com.zln.personal.service;

import java.util.List;

public interface ArticleTagService {
    int addArticleTag(long articleId, List<Number> tagIds);

    String getTagIdsByArtId(long articleId);

    int deleteArtTagByAid(long articleId);
}
