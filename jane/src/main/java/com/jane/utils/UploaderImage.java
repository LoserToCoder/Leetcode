package com.jane.utils;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
public  class  UploaderImage {
    public static Map<String, Object>  handlerImageUpload(MultipartFile[] uploadFiles,Integer id,String uploaderUrl) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isError = false;
        List<String> urls = new ArrayList<>();
        try {
            for (MultipartFile uploadFile : uploadFiles) {
                if (!uploadFile.isEmpty()) {
                    DateTime date = new DateTime();
                    String pattern=date.toString("yyyyMMdd");
                    String dir = id+File.separator+pattern;
                    String tempDir = uploaderUrl + dir;
                    File tempFile = new File(tempDir);
                    if (!tempFile.exists()) {
                        tempFile.mkdirs();
                    }
                    String fileName = UUID.randomUUID().toString().toLowerCase();
                    String originalName = uploadFile.getOriginalFilename();
                    int idx = originalName.lastIndexOf(".");
                    String suffixName = originalName.substring(idx);
                    String finalPath = tempDir+File.separator+fileName + suffixName;
                    uploadFile.transferTo(new File(finalPath));
                    System.out.println(finalPath);
                    urls.add(uploaderUrl.split(":")[1].replace("\\", "/")+id+"/"+pattern+ "/" + fileName + suffixName);
                }
            }
            map.put("errno", 0);
            map.put("data", urls);
        } catch (IOException e) {
           //日志记录
            isError = true;
        } finally {
            if (isError) {
                map.put("errno", 1);
                map.put("data", "fail");
            }
        }
        return map;
    }
    public static Map<String, Object>  handlerAvatarUpload(MultipartFile uploadFiles,Integer id,String uploaderUrl) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isError = false;
        List<String> urls = new ArrayList<>();
        try {
                if (!uploadFiles.isEmpty()) {
                    File tempFile = new File(uploaderUrl);
                    if (!tempFile.exists()) {
                        tempFile.mkdirs();
                    }
                    String suffixName =id+"/uuid"+id+".jpg";
                    String finalPath =uploaderUrl+suffixName;
                    uploadFiles.transferTo(new File(finalPath));
                    urls.add(uploaderUrl.split(":")[1].replace("\\", "/")+suffixName);
                }
            map.put("errno", 0);
            map.put("data", urls);
        } catch (IOException e) {
            //日志记录
            isError = true;
        } finally {
            if (isError) {
                map.put("errno", 1);
                map.put("data", "fail");
            }
        }
        return map;
    }
    public static Map<String, Object>  itemImageUpload(MultipartFile[] uploadFiles,Integer pid,String uploaderUrl) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isError = false;
        List<String> urls = new ArrayList<>();
        try {
            for (MultipartFile uploadFile : uploadFiles) {
                if (!uploadFile.isEmpty()) {
                    String tempDir = uploaderUrl + pid;
                    File tempFile = new File(tempDir);
                    if (!tempFile.exists()) {
                        tempFile.mkdirs();
                    }
                    String fileName = UUID.randomUUID().toString().toLowerCase();
                    String originalName = uploadFile.getOriginalFilename();
                    int idx = originalName.lastIndexOf(".");
                    String suffixName = originalName.substring(idx);
                    String finalPath = tempDir+File.separator+fileName + suffixName;
                    uploadFile.transferTo(new File(finalPath));
                    System.out.println(finalPath);
                    urls.add(fileName + suffixName);
                }
            }
            map.put("errno", 0);
            map.put("data", urls);
        } catch (IOException e) {
            //日志记录
            isError = true;
        } finally {
            if (isError) {
                map.put("errno", 1);
                map.put("data", "fail");
            }
        }
        return map;
    }

    public static Map<String,Object> handlerRecruit(MultipartFile uploadFiles)throws Exception{
        Map<String, Object> map = new HashMap<>();
        if(uploadFiles!=null){
            String fileName=UUID.randomUUID().toString();
            String originalName = uploadFiles.getOriginalFilename();
            int idx = originalName.lastIndexOf(".");
            String suffixName = originalName.substring(idx);
            String finalPath="E:\\images\\recruit\\"+fileName+suffixName;
            uploadFiles.transferTo(new File(finalPath));
            map.put("url", "/images/recruit/" + fileName + suffixName);
            map.put("status", 200);
            return map;
        }
        map.put("status", 404);
        return map;
    }
    public static Map<String,Object> handlerProduct(MultipartFile uploadFiles)throws Exception{
        Map<String, Object> map = new HashMap<>();
        if(uploadFiles!=null){
            String fileName=UUID.randomUUID().toString();
            String originalName = uploadFiles.getOriginalFilename();
            int idx = originalName.lastIndexOf(".");
            String suffixName = originalName.substring(idx);
            String finalPath="E:\\images\\products\\"+fileName+suffixName;
            uploadFiles.transferTo(new File(finalPath));
            map.put("url", "/images/products/" + fileName + suffixName);
            map.put("status", 200);
            return map;
        }
        map.put("status", 404);
        return map;
    }
}
