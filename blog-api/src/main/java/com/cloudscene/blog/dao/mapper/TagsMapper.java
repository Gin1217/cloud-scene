package com.cloudscene.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloudscene.blog.dao.pojo.Tags;

import java.util.List;


public interface TagsMapper extends BaseMapper<Tags> {
//    根据文章id查询标签列表
    List<Tags> findTagsByArticlesId(Long articlesId);
}
