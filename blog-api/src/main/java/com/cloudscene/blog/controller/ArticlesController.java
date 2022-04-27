package com.cloudscene.blog.controller;

import com.cloudscene.blog.service.ArticlesService;
import com.cloudscene.blog.vo.Result;
import com.cloudscene.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gin
 * @date 2022/4/21
 * @description ArticlesController
 */


//json数据进行交互
@RestController
@RequestMapping("articles")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;





    //首页 文章列表
    @PostMapping
    public Result listArticles(@RequestBody PageParams pageParams){

        return articlesService.listArticles(pageParams);

//        return Result.success();
    }


}
