package com.cloudscene.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @author gin
 * @date 2022/4/26
 * @description ArticlesVo
 */

@Data
public class ArticlesVo {
    private String id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

//    private ArticleBodyVo body;

    private List<TagVo> tags;

//    private CategoryVo category;
}
