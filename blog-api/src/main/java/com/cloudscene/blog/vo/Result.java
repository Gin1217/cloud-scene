package com.cloudscene.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.jvm.hotspot.utilities.ObjectReader;

/**
 * @author gin
 * @date 2022/4/21
 * @description Result
 */

//返回值，下面的内容要根据接口的返回值修改（应该吧

@Data
@AllArgsConstructor
public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

    //成功后显示的内容
    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    //失败后返回的内容
    public static Result fail(int code,String msg){
        return new Result(false,code,msg,null);
    }
}
