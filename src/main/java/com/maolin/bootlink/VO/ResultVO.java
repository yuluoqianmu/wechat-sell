package com.maolin.bootlink.VO;

import lombok.Data;

/**
 * Created by shaomaolin on 2018/11/21.
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;
}
