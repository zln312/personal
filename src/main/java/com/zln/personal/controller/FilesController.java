package com.zln.personal.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.zln.personal.utils.MultipartToFile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/file")
public class FilesController {
    @PostMapping("/{image}")
    public String getImgUrl(@RequestParam("img") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //MultipartFile转换File
        File toFile = MultipartToFile.multipartFileToFile(file);


// 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDIkpY2HWyRfcLp9frFTS4ScV8Ui32mDvQ";
        String secretKey = "PedOXVEiyyjEtIYpyxhCRnlUxAetsfBS";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

// 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chongqing");
        ClientConfig clientConfig = new ClientConfig(region);

// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

// 指定文件将要存放的存储桶
        String bucketName = "image-1257394013";

// 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        long time= System.currentTimeMillis();
        String key = time+toFile.getName();
        PutObjectResult putObjectResult = cosClient.putObject(bucketName, key, toFile);
//        String etag = putObjectResult.getETag();  // 获取文件的 etag
        MultipartToFile.deleteTempFile(toFile);
        Object ob = new Object();
        return  "https://image-1257394013.cos.ap-chongqing.myqcloud.com/"+key;
    }

}
