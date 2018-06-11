package com.ghds.alumni.service.businessservice;

import com.ghds.alumni.app.constant.BusinessEnum;
import com.ghds.alumni.app.constant.FileEnum;
import com.ghds.alumni.app.constant.ImageEnum;
import com.ghds.alumni.app.utils.FileUtil;
import com.ghds.alumni.app.utils.PathUtil;
import com.ghds.alumni.web.dto.Result;
import com.ghds.alumni.app.config.UrlConfig;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述: 文件相关服务
 *
 * @Author: 蔡伟浩
 * @Date: 2017/1/13 11:32
 */
@Service
public class FileService {

    @Autowired
    private UrlConfig urlConfig;

    /**
     * 说明： 可放回base64
     * @author dengshuai
     * @date Created in 11:41 2018/5/24
     * @modified by autor in 11:41 2018/5/24
     */
    public Result upload(MultipartFile file, FileEnum fileEnum, ImageEnum imageEnum, Integer base64) throws IOException {
        String rootPath = PathUtil.buildRootPath(urlConfig.getUrlStaticPic(),BusinessEnum.CASES, fileEnum, imageEnum);
        String fileName = FileUtil.buildFileName(fileEnum.getSuffix());
        String absPath = FileUtil.fileWrite(new ByteArrayInputStream(file.getBytes()), rootPath, fileName);

        FileUtil.thumbnailImage(absPath,100,150,"thumb_",false);

        if(base64!=null){
            String msg = FileUtil.encodeBase64File(absPath);
            absPath = absPath.substring(urlConfig.getUrlStaticPic().length());

            if (!StringUtil.isEmpty(absPath)) {

                return Result.successed(absPath,msg);
            } else {
                return Result.failed("文件上传失败");
            }
        }



        absPath = absPath.substring(urlConfig.getUrlStaticPic().length());
        if (!StringUtil.isEmpty(absPath)) {
            return Result.successed(absPath);
        } else {
            return Result.failed("文件上传失败");
        }
    }
    
    /**
     * 说明： 上传图片
     * @author dengshuai
     * @date Created in 11:41 2018/5/24
     * @modified by autor in 11:41 2018/5/24
     */
    public Result upload(String base64File, FileEnum fileEnum, ImageEnum imageEnum) throws IOException {
        String rootPath = PathUtil.buildRootPath(urlConfig.getUrlStaticPic(),BusinessEnum.CASES, fileEnum, imageEnum);
        String fileName = FileUtil.buildFileName(fileEnum.getSuffix());
        InputStream  input = FileUtil.base64ToInputString(base64File);
        if (input == null) {
            return Result.failed("文件上传失败");
        }
        String absPath = FileUtil.fileWrite(input, rootPath, fileName);
        FileUtil.thumbnailImage(absPath,100,150,"thumb_",false);

        absPath = absPath.substring(urlConfig.getUrlStaticPic().length());

        if (!StringUtil.isEmpty(absPath)) {
            return Result.successed(absPath);
        } else {
            return Result.failed("文件上传失败");
        }
    }

}
