package com.ghds.alumni.service.businessservice.admin;

import com.ghds.alumni.app.constant.FilePathEnum;
import com.ghds.alumni.app.constant.ImagePathEnum;
import com.ghds.alumni.web.dto.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: 图片上传接口
 * @author: dengshuai
 * @date: Created in 10:54 2018/1/22
 * @modified: by autor in 10:54 2018/1/22
 */
public interface IFileUpload {

    /**
     * 上传普通文件（一般用来处理非图片文件）
     *
     * @param file         上传的文件
     * @param filePathEnum 上传的文件类型
     * @return
     * @author: dengshuai
     * @date: Created in 10:55 2018/1/22
     * @modified: by autor in 10:55 2018/1/22
     * @see FilePathEnum
     **/
    public Result uploadFile(MultipartFile file, FilePathEnum filePathEnum) throws IOException;

    /**
     * 使用base64上传图片
     *
     * @param base64File    base64数据
     * @param filePathEnum  文件类型
     * @param imagePathEnum 图片类型，如头像文件等
     * @return
     * @author: dengshuai
     * @date: Created in 10:55 2018/1/22
     * @modified: by autor in 10:55 2018/1/22
     * @see FilePathEnum
     * @see ImagePathEnum
     **/
    public Result uploadPicBase64(String base64File, FilePathEnum filePathEnum, ImagePathEnum imagePathEnum);

    /**
     * 传统Form表单上传图片
     *
     * @param file          图片数据
     * @param filePathEnum  文件类型
     * @param imagePathEnum 图片类型，如头像文件等
     * @return
     * @author: dengshuai
     * @date: Created in 10:55 2018/1/22
     * @modified: by autor in 10:55 2018/1/22
     * @see FilePathEnum
     * @see ImagePathEnum
     */
    public Result uploadPicForm(MultipartFile file, FilePathEnum filePathEnum, ImagePathEnum imagePathEnum) throws IOException;


    /**
     * 获取图片文件的base64数据
     *
     * @param file 上传的文件
     * @return base64数据
     * @author: dengshuai
     * @date: Created in 10:55 2018/1/22
     * @modified: by autor in 10:55 2018/1/22
     */
    public Result doGetPicBase64(MultipartFile file) throws IOException;

}
