package com.fh.meeting.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private MeetingService meetingService;

    @RequestMapping("uploadToOSS")
    public ServerResponse uploadToOSS(MultipartFile file){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FyCnJcVyepPtzdTpqdY";
        String accessKeySecret = "0sWHhu3RuC85xQAG4TYt58UedIUdSd";
        String backetName = "1908b";
        String prefixUrl ="http://1908b.oss-cn-beijing.aliyuncs.com/";
        String fileName = file.getOriginalFilename(); //原文件名
        String newFileName = UUID.randomUUID()+getSuffix(fileName);
        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(backetName, newFileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ServerResponse.success(prefixUrl+newFileName);
    }
    /**
     * 获取后缀名
     * @param fileName
     * @return
     */
    public String getSuffix(String fileName){
        int index =  fileName.lastIndexOf(".");
        return fileName.substring(index);

    }
}
