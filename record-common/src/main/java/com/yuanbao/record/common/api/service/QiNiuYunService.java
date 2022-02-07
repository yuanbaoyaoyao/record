package com.yuanbao.record.common.api.service;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.ConnectException;
import java.util.Map;

public interface QiNiuYunService {
    Boolean deleteFile(String key);

    FileInfo checkFile(String key);

    Map<String, String> uploadImg(MultipartFile files, String path);

    FetchRet fetchNetSource(String url) throws ConnectException;

    Map uploadFile(File file, String filePath, String fileName) throws QiniuException;

    JSONObject getQiniuPolicy();
}
