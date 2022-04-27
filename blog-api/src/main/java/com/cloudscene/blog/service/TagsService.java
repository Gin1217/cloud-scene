package com.cloudscene.blog.service;

import com.cloudscene.blog.vo.TagsVo;

import java.util.List;

public interface TagsService {

    List<TagsVo> findTagsByArticlesId(Long articlesId);
}
