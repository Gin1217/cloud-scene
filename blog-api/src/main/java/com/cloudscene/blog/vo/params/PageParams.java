package com.cloudscene.blog.vo.params;

import lombok.Data;

/**
 * @author gin
 * @date 2022/4/21
 * @description PageParams
 */

@Data
public class PageParams {

    private int page=1;

    private int pageSize=10;

}
