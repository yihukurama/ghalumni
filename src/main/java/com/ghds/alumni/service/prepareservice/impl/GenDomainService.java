package com.ghds.alumni.service.prepareservice.impl;

import com.ghds.alumni.service.prepareservice.IGenDomainService;
import com.ghds.alumni.service.prepareservice.base.PrepareConstant;
import com.ghds.alumni.service.prepareservice.base.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GenDomainService implements IGenDomainService {

    @Autowired
    ReplaceFileString rfs;

    @Override
    public int genDomainService(Table table) {
        if (table == null || table.getColumns() == null) {
            return 0;
        }

        File domainServiceFile = null;
        String tableName = table.getName();
        String packages = "";

        if (table.getName().startsWith("business_")) {
            packages = PrepareConstant.businessDomainServicePackage;
        } else {
            packages = PrepareConstant.adminDomainServicePackage;
        }
        String domainName = table.getName().split("_")[1];
        domainName = domainName.substring(0, 1).toUpperCase() + domainName.substring(1);
        if (tableName.startsWith("business_")) {
            domainServiceFile = new File(PrepareConstant.businessDomainServicePath + File.separator + domainName + "Service.java");
        } else {
            domainServiceFile = new File(PrepareConstant.adminDomainServicePath + File.separator + domainName + "Service.java");
        }


        File tplFile = new File(PrepareConstant.DOMAINSERVICETPL_PATH);

        if (!domainServiceFile.exists()) {
            try {
                domainServiceFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return -1;
            }
        }

        BufferedReader br = null;
        String line = null;
        StringBuffer buf = new StringBuffer();
        BufferedWriter bw = null;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(tplFile), "UTF-8");
            // 根据文件路径创建缓冲输入流
            br = new BufferedReader(read);

            // 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
            while ((line = br.readLine()) != null) {

                buf.append(line).append("\r\n");

            }

            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(domainServiceFile), "UTF-8");
            // 根据文件路径创建缓冲输出流
            bw = new BufferedWriter(write);
            // 将内容写入文件中
            bw.write(buf.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            // 关闭流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                }
            }
            // 关闭流
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    bw = null;
                }
            }
        }


        rfs.replacePackage(domainServiceFile.getAbsolutePath(), "${package}", packages);
        rfs.replacePackage(domainServiceFile.getAbsolutePath(), "${domainName}", domainName);

        return 1;
    }
}
