package com.jane.controller;
import com.jane.pojo.Result;
import com.jane.utils.PageCode;
import com.jane.utils.UploaderImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadImageController {

    @Value("${uploader_article}")
    private String uploaderArticle;

    @Value("${uploader_item}")
    private String uploaderItem;

    @Value("${uploader_avatar}")
    private String uploaderUserAvatar;
    @ResponseBody
    @RequestMapping(value = "/uploader/cover",method = RequestMethod.POST)
    public Object handlerImageUpload(MultipartFile[] uploadFiles,Integer id,@RequestParam(required = false) String type) {
        Map<String, Object> map;
        if(uploadFiles==null||uploadFiles.length==0){
            map = new HashMap<>();
            map.put("errno",1);
            map.put("data","[]");
            return  map;
        }
        if(type==null) map= UploaderImage.handlerImageUpload(uploadFiles,id,uploaderArticle);
        else if(type!=null&&"item".equals(type)){
            map= UploaderImage.itemImageUpload(uploadFiles,id,uploaderItem);
        }else{
            map= UploaderImage.handlerAvatarUpload(uploadFiles[0],id,uploaderUserAvatar);
        }
        return map;
    }


    @RequestMapping(value = "/recruit/cover")
    @ResponseBody
    public Object uploaderRecruitCover(MultipartFile uploadFiles){
        try {
            return  UploaderImage.handlerRecruit(uploadFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;

    }
    @RequestMapping(value = "/product/cover")
    @ResponseBody
    public Object uploaderProductCover(MultipartFile uploadFiles){
        try {
            return  UploaderImage.handlerProduct(uploadFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;

    }
}
