package com.cloudscene.blog.service.impl;

import com.cloudscene.blog.dao.mapper.TagsMapper;
import com.cloudscene.blog.dao.pojo.Tags;
import com.cloudscene.blog.service.TagsService;
import com.cloudscene.blog.vo.TagsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gin
 * @date 2022/4/27
 * @description TagsServiceImpl
 */

@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagsMapper tagsMapper;


    private List<TagsVo> copyList(List<Tags> tagList) {
        List<TagsVo> tagVoList = new ArrayList<>();
        for (Tags tags : tagList) {
            tagVoList.add(copy(tags));
        }
        return tagVoList;

    }

    private TagsVo copy(Tags tags) {
        TagsVo tagsVo = new TagsVo();
        BeanUtils.copyProperties(tags, tagsVo);
        tagsVo.setId(String.valueOf(tags.getId()));
        return tagsVo;
    }

    @Override
    public List<TagsVo> findTagsByArticlesId(Long articlesId) {
//      mybatisplus无法进行多表查询，所以自己写
        List<Tags> tags = tagsMapper.findTagsByArticlesId(articlesId);
        return copyList(tags);
    }
}
