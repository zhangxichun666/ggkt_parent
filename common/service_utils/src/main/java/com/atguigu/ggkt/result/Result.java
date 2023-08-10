package com.atguigu.ggkt.result;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @ClassName Result
 * @Description
 * @Author zxc
 * @Date 2023/8/10 8:28
 * @Version 1.0
 */
//统一返回结果
@Data
public class Result<T> {
    private Integer code;   //状态码
    private String message; //返回状态信息
    private T data; //返回数据

    public Result(){}

    //成功的方法，没有data数据
    /*public static<T> Result<T> ok(){
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }*/
    //失败的方法，没有data数据
    /*public static<T> Result<T> fail(){
        Result<T> result = new Result<T>();
        result.setCode(201);
        result.setMessage("失败");
        return result;
    }*/

    //成功的方法，有data数据
    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        if(data != null){
            result.setData(data);
        }
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
    //失败的方法，有data数据
    public static<T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        if(data != null){
            result.setData(data);
        }
        result.setCode(201);
        result.setMessage("失败");
        return result;
    }
}
