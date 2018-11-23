package com.maolin.bootlink.utils;

import com.maolin.bootlink.VO.ResultVO;

/**
 * Created by shaomaolin on 2018/11/22.
 */
public class ResultVOUtil {

    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setCode(code);
        resultVO.setMsg("失败");
        return resultVO;
    }
}
