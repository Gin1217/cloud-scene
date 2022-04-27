package com.cloudscene.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloudscene.blog.dao.mapper.ArticlesMapper;
import com.cloudscene.blog.dao.pojo.Articles;
import com.cloudscene.blog.service.ArticlesService;
import com.cloudscene.blog.vo.ArticlesVo;
import com.cloudscene.blog.vo.Result;
import com.cloudscene.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gin
 * @date 2022/4/26
 * @description ArticlesServicesImpl
 */

@Service
public class ArticlesServicesImpl implements ArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;


    @Override
    public Result listArticles(PageParams pageParams) {

//        1、分页查询article数据库表
//        需要两个参数，一个是根据文章数量进行分页
        Page<Articles> page=new Page<>(pageParams.getPage(),pageParams.getPageSize());

//        一个是根据发布时间进行倒序排列
        LambdaQueryWrapper<Articles> queryWrapper = new LambdaQueryWrapper<>();
//        根据文章是否置顶进行排序（根据数据库中文章的weight是否为1进行置顶）
        queryWrapper.orderByDesc(Articles::getWeight);
//        这相当于order by create_date desc语句
        queryWrapper.orderByDesc(Articles::getCreateDate);
        Page<Articles> articlesPage = articlesMapper.selectPage(page, queryWrapper);
        List<Articles> records = articlesPage.getRecords();
//        能直接返回吗？ 不能
        List<ArticlesVo> articlesVoList=copyList(records);
        return Result.success(articlesVoList);
    }
//      进行一个什么转化来着，属性？？字段属性不一样的进行转化，方便在页面上进行使用
    private List<ArticlesVo> copyList(List<Articles> records) {
        List<ArticlesVo> articlesVoList=new ArrayList<>();
        for (Articles record : records){
            articlesVoList.add(copy(record));
        }
        return null;
    }
//    把相同属性的进行转化
    private ArticlesVo copy(Articles articles,boolean isTag,boolean isAuthor){
        ArticlesVo articlesVo=new ArticlesVo();
        BeanUtils.copyProperties(articles,articlesVo);
//    属性不一样，无法copy，比如时间
        articlesVo.setCreateDate(new DateTime(articles.getCreateDate()).toString("yyyy-MM-dd HH:mm"));

//        并不是所有接口都需要标签，作者信息
if(isTag){
    Long articleId = articles.getId();
    articlesVo.setTags();
}
if(isAuthor){
    articlesVo.setAuthor("");
}

        return articlesVo;
    }

}
