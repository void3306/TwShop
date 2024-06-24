package com.api.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.api.common.enums.ErrorMsg;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * T泛型可以自定义传入的数据类型
 * @JsonInclude 所有返回的数据必须是json类型 注解的目的防止为空
 * @param <T>
 */

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ResultVo<T> {
    private Integer status_code;
    private String  msg;
    private T  data;



    //直接返回成功状态码
    public static  ResultVo success(){

        ResultVo resultVo = new ResultVo();

        resultVo.setStatus_code(1);

        return  resultVo;

    }

    //返回成功状态码的同时返回对象

    public  static  <T>ResultVo success(T  data){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setStatus_code(1);
        resultVo.setData(data);
        return  resultVo;
    }



    //直接返回成功状态码
    public static  ResultVo fail(ErrorMsg errorMsg){
        ResultVo resultVo = new ResultVo();
        resultVo.setStatus_code(0);
        resultVo.setMsg(errorMsg.getMsg());
        return  resultVo;
    }

    //返回成功状态码的同时返回对象

    public  static  <T>ResultVo fail(ErrorMsg errorMsg,T  data){
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setStatus_code(0);
        resultVo.setMsg(errorMsg.getMsg());
        resultVo.setData(data);
        return  resultVo;
    }

    public static ResultVo error(Integer status_code, String msg){
        return new ResultVo<>(status_code, msg);
    }

    public static <T>ResultVo error(Integer status_code, String msg, T data){
        return new ResultVo<>(status_code, msg, data);
    }

    public ResultVo(Integer status_code, String msg, T data) {
        this.status_code = status_code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(Integer status_code, String msg) {
        this.status_code = status_code;
        this.msg = msg;
    }

    public ResultVo() {

    }
}
