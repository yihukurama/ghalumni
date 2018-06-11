package com.ghds.alumni.web.admin;

import com.ghds.alumni.app.constant.FileEnum;
import com.ghds.alumni.app.constant.ImageEnum;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.service.businessservice.FileService;
import com.ghds.alumni.web.dto.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 说明： 图片上传接口，不做任何业务操作
 *
 * @author: dengshuai
 * @date: Created in 12:01 2018/1/22
 * @modified: by autor in 12:01 2018/1/22
 */
@Api(value = "FileController", description = "文件上传接口")
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;
    /**
     * 说明： 上传文件，可返回base64
     * @author dengshuai
     * @date Created in 11:39 2018/5/24
     * @modified by autor in 11:39 2018/5/24
     */
    @RequestMapping(value="/uploadPic", method= RequestMethod.POST)
    public Result uploadPic(@RequestParam(value = "file", required = true) MultipartFile file,
                            @RequestParam(value = "fileType", required = true) Integer fileType,
                            @RequestParam(value = "imgType", required = true) Integer imgType,
                            @RequestParam(value = "base64", required = false) Integer base64) throws TipsException
    {
        try {
            FileEnum fileEnum = FileEnum.buildByType(fileType);
            if (fileEnum == null) {
                return Result.failed("fileType error");
            }
            ImageEnum imageEnum = ImageEnum.buildByType(imgType);
            if (imageEnum == null) {
                return Result.failed("imgType error");
            }

            return fileService.upload(file, fileEnum, imageEnum,base64);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failed("文件上传失败");
        }
    }


    /**
     * 说明： base64上传
     * @author dengshuai
     * @date Created in 11:39 2018/5/24
     * @modified by autor in 11:39 2018/5/24
     */
    @RequestMapping(value="/uploadPicBase64", method=RequestMethod.POST)
    public Result uploadPicBase64(
            @RequestParam(value = "dataStr", required = true) String dataStr,
            @RequestParam(value = "fileType", required = true) Integer fileType,
            @RequestParam(value = "imgType", required = true) Integer imgType) throws TipsException
    {
        try {
            FileEnum fileEnum = FileEnum.buildByType(fileType);
            if (fileEnum == null) {
                return Result.failed("fileType error");
            }
            ImageEnum imageEnum = ImageEnum.buildByType(imgType);
            if (imageEnum == null) {
                return Result.failed("imgType error");
            }

            return fileService.upload(dataStr, fileEnum, imageEnum);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failed("文件上传失败");
        }
    }







}
