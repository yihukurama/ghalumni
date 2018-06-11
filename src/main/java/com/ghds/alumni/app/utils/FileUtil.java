package com.ghds.alumni.app.utils;

import com.ghds.alumni.app.config.StringConfig;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 文件工具
 *
 * @author: dengshuai
 * @date: Created in 11:29 2018/1/22
 * @modified: by autor in 11:29 2018/1/22
 */
public class FileUtil {

    public static String encodeBase64File(String path) {
        File file = new File(path);
        FileInputStream inputFile;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return new BASE64Encoder().encode(buffer);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 生成文件名
     *
     * @param suffix 后缀
     * @return
     */
    public static String buildFileName(String suffix) {
        StringBuffer randomStr = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            Random r = new Random();
            randomStr.append(StringUtil.chars[r.nextInt(62)]);
        }
        String dateStr = DateUtil.toString(new Date(), "yyyyMMddHHmmss");
        String fileName = String.format(StringConfig.FILE_NAME_FORMAT_STRING,
                dateStr,
                EncrUtil.GetMD5Code(new StringBuffer()
                        .append(dateStr)
                        .append(randomStr.toString())
                        .append(System.nanoTime())
                        .toString()
                ), suffix
        );
        return fileName;
    }

    /**
     * 文件写入
     *
     * @param inputStream 输入流
     * @param rootPath    根路径
     * @param fileName    文件名
     * @return
     * @author: dengshuai
     * @date: Created in 11:28 2018/1/22
     * @modified: by autor in 11:28 2018/1/22
     */
    public static String fileWrite(InputStream inputStream, String rootPath, String fileName) {

        String path = null;
        OutputStream output = null;
        if (inputStream == null) {
            return null;
        }
        // 文件写入;
        try {
            // 创建上传之后的文件路径;
            File temp = new File(rootPath, fileName);
            //文件或目录是否存在
            if (!temp.exists()) {
                temp.getParentFile().mkdirs();
            }
            temp.createNewFile();
            output = new FileOutputStream(temp);
            int byteRead = 0;
            // 1M;
            byte[] buffer = new byte[1024];
            while ((byteRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, byteRead);
            }
            output.flush();
            path = temp.getPath();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (EmptyUtil.isEmpty(path)) {
            path = path.replaceAll("\\\\", "/");
        }
        return path;
    }

    /**
     * base64字符串转输入流
     *
     * @param base64Str
     * @return
     */
    public static InputStream base64ToInputString(String base64Str) {
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64Str);
            stream = new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return stream;
        }
    }

    /**
     * 输入流转base64字符串
     *
     * @param inputStream
     * @return
     */
    public static String inputToBase64(InputStream inputStream) {
        String str = null;
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            BASE64Encoder encoder = new BASE64Encoder();
            str = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return str;
        }

    }


    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 根据图片路径生成缩略图 </p>
     * @param imagePath    原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     * @param prevfix    生成缩略图的前缀
     * @param force        是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     */
    public static String thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force){
        File imgFile = new File(imagePath);
        if(imgFile.exists()){
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                String suffix = null;
                // 获取图片后缀
                if(imgFile.getName().indexOf(".") > -1) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀全部小写，然后判断后缀是否合法
                if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0){
                    LogUtil.ErrorLog(FileUtil.class,"Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return null;
                }
                LogUtil.DebugLog(FileUtil.class,"target image's size, width:{"+w+"}, height:{"+h+"}.");
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                            LogUtil.DebugLog(FileUtil.class,"change image's size, width:{"+w+"}, height:{"+h+"}.");
                        }
                    } else {
                        if(height > h){
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                            LogUtil.DebugLog(FileUtil.class,"change image's size, width:{"+w+"}, height:{"+h+"}.");
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原目录并加上前缀
                ImageIO.write(bi, suffix, new File(p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName()));
                LogUtil.DebugLog(FileUtil.class,"缩略图在原路径下生成成功");
                return p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName();
            } catch (IOException e) {
                LogUtil.DebugLog(FileUtil.class,"generate thumbnail image failed.");
            }
        }else{
            LogUtil.DebugLog(FileUtil.class,"the image is not exist.");
            return null;
        }
        return null;
    }
}
