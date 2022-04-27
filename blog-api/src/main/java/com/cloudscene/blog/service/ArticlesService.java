package com.cloudscene.blog.service;

import com.cloudscene.blog.vo.Result;
import com.cloudscene.blog.vo.params.PageParams;

public interface ArticlesService {
//    分页查询 文章列表

    Result listArticles(PageParams pageParams);
}
