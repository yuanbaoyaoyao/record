package com.yuanbao.record.common.api.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yuanbao.record.common.api.config.UploadConfig;
import com.yuanbao.record.common.api.service.QiNiuYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class QiNiuYunServiceImpl implements QiNiuYunService {

    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private BucketManager bucketManager;
    @Autowired
    private Auth auth;

    @Autowired
    private UploadConfig uploadConfig;

    private String getUploadToken() {
        return this.auth.uploadToken(uploadConfig.getBucket(), null, 3600, null);
    }

    @Override
    public Boolean deleteFile(String key) {
        if(checkFile(key)==null){
            return true;
        }else{
            try {
                bucketManager.delete(uploadConfig.getBucket(), key);
                return true;
            } catch (QiniuException e) {
                throw new RuntimeException();
            }
        }
    }

    @Override
    public FileInfo checkFile(String key) {
        FileInfo fileInfo = null;
        try {
            fileInfo = bucketManager.stat(uploadConfig.getBucket(),key);
        }catch (QiniuException e){
            e.printStackTrace();
        }
        return fileInfo;
    }

    @Override
    public Map<String, String> uploadImg(MultipartFile files, String path) {
        String fileName = files.getOriginalFilename();
        File file = new File(path+fileName);
        String imgName = "";
        try{
            files.transferTo(file);
            Map response = uploadFile(file,path,fileName);
            imgName = (String)response.get("imgName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("image",imgName);
        return map;
    }

    @Override
    public FetchRet fetchNetSource(String url) throws ConnectException {
        FetchRet fetchRet = null;
        try {
            fetchRet = bucketManager.fetch(url,uploadConfig.getBucket(), LocalDate.now()+"/"+ IdUtil.randomUUID());
        }catch (QiniuException e){
            e.printStackTrace();
        }
        if (fetchRet == null){
            throw new ConnectException();
        }
        return null;
    }

    @Override
    public Map uploadFile(File file, String filePath, String fileName) throws QiniuException {
        Map map = new HashMap();
        LocalDateTime dateTime = LocalDateTime.now();
        Response response = this.uploadManager.put(
                file,
                filePath+dateTime.getYear()+""+dateTime.getMonthValue()+""+dateTime.getDayOfMonth()+""+
                        dateTime.getMinute()+""+dateTime.getSecond()+"/"+fileName,getUploadToken());
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        String imgName = putRet.key;
        String imgHash = putRet.hash;
        int retry = 0;
        while (response.needRetry()&&retry<3){
            response = this.uploadManager.put(file,null,getUploadToken());
        }
        map.put("imgName",imgName);
        map.put("response",response);
        map.put("imgHash",imgHash);
        return map;
    }

    @Override
    public JSONObject getQiniuPolicy() {
        JSONObject json = new JSONObject();
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody",
                "{\"key\":\"$(key)\"," +
                        "\"hash\":\"$(etag)\"," +
                        "\"bucket\":\"$(bucket)\"," +
                        "\"fsize\":\"$(fsize)\"," +
                        "\"mimeType\":\"$(mimeType)\"}");
        putPolicy.put("mimeLimit","!application/json;text/plain");
        json.put("token",auth.uploadToken(uploadConfig.getBucket(),null,uploadConfig.getExpireSeconds(),putPolicy));
        json.put("url",uploadConfig.getDomain());
        json.put("dirPrefix",LocalDate.now()+"/");
        return json;
    }
}