package com.jane.controller;


import com.jane.pojo.Result;
import com.jane.pojo.StarScore;
import com.jane.service.ItemCommonService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemCommonsController {

    @Autowired
    private ItemCommonService itemCommonService;

    @RequestMapping(value = "/item/score/star")
    @ResponseBody
    public Result itemScores(String pid){
        try {
          StarScore starScore =itemCommonService.itemScore(pid);
            if(starScore!=null){
                Result result = new Result();
                result.setInfo(starScore);
                result.setStatus(PageCode.ITEM_START_SUCCESS.getCode());
                result.setMsg(PageCode.ITEM_START_SUCCESS.getMsg());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setMsg(PageCode.ITEM_START_FAILED.getMsg());
        result.setStatus(PageCode.ITEM_START_FAILED.getCode());
        return result;
    }

    @RequestMapping(value = "/item/score/add")
    @ResponseBody
    public Result itemAddScore(String pid,Integer uid,Integer score){
        try {
            Integer nums=itemCommonService.itemAddScore(pid, uid, score);
            if(nums!=null){
                Result result=new Result();
                result.setInfo(nums);
                result.setMsg(PageCode.ITEM_START_ADD_SUCCESS.getMsg());
                result.setStatus(PageCode.ITEM_START_ADD_SUCCESS.getCode());
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return  result;
    }


    @RequestMapping(value = "/item/user/star")
    @ResponseBody
    public Result itemUserScore(String pid,Integer uid) {
        try {
            Object id=itemCommonService.itemUserScore(pid, uid);
            if(id!=null){
                Result result=new Result();
                result.setInfo(id);
                result.setStatus(PageCode.ITEM_USER_SCORE.getCode());
                result.setMsg(PageCode.ITEM_USER_SCORE.getMsg());
                return  result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return  result;
    }




}
