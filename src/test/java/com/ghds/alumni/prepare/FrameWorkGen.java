package com.ghds.alumni.prepare;

import com.ghds.alumni.service.prepareservice.IGenDomainService;
import com.ghds.alumni.service.prepareservice.IGenEntity;
import com.ghds.alumni.service.prepareservice.IGenMapper;
import com.ghds.alumni.service.prepareservice.base.Column;
import com.ghds.alumni.service.prepareservice.base.LogUtil;
import com.ghds.alumni.service.prepareservice.base.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrameWorkGen {


    @Test
    public void batchGenBaseMapper() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SQLException {

        String[] tableNames = {"business_wxuser"};//指定重新构造某些表

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "ghxyh";
            String pwd = "ghxyh";
            String url = "jdbc:mysql://119.29.253.166:3306/ghxyh_dev?useUnicode=true&amp;characterEncoding=UTF-8";
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", pwd);
            props.setProperty("remarks", "true"); // 设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");// 设置可以获取tables
            // remarks信息
            conn = DriverManager.getConnection(url, props);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 1、获取数据库所有表
        StringBuffer sbTables = new StringBuffer();
        List<Table> tables = new ArrayList<Table>();
        sbTables.append("-------------- 数据库中有下列的表 ----------<br/>");
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet rs = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {// ///TABLE_TYPE/REMARKS
                Table table = new Table();
                table.setName(rs.getString("TABLE_NAME"));
                table.setRemark(rs.getString("REMARKS"));
                sbTables.append("表名：" + rs.getString("TABLE_NAME") + "<br/>");
                sbTables.append("表类型：" + rs.getString("TABLE_TYPE") + "<br/>");
                sbTables.append("表所属数据库：" + rs.getString("TABLE_CAT") + "<br/>");
                sbTables.append("表所属用户名：" + rs.getString("TABLE_SCHEM") + "<br/>");
                sbTables.append("表备注：" + rs.getString("REMARKS") + "<br/>");
                sbTables.append("------------------------------<br/>");
                tables.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 2、遍历数据库表，获取各表的字段等信息
        for (int i = 0; i < tables.size(); i++) {
            String tableName = tables.get(i).getName();


            boolean needUpdate = false;
            for (int j = 0; j < tableNames.length; j++) {
                if (tableName.equals(tableNames[j])) {
                    LogUtil.DebugLog(this, "需要更新的表3是" + tableName);
                    needUpdate = true;
                    break;
                }
            }
            if (!needUpdate) {
                continue;
            }

            ResultSet rs = conn.getMetaData().getColumns(null, "", tableName.toUpperCase(), "%");
            List<Column> columns = new ArrayList<>();
            while (rs.next()) {
                //System.out.println("字段名："+rs.getString("COLUMN_NAME")+"--字段注释："+rs.getString("REMARKS")+"--字段数据类型："+rs.getString("TYPE_NAME"));
                String colName = rs.getString("COLUMN_NAME");
                String remarks = rs.getString("REMARKS");
                if (remarks == null || remarks.equals("")) {
                    remarks = colName;
                }

                String dbType = rs.getString("TYPE_NAME");
                LogUtil.DebugLog(this, tableName + "------------" + colName + "----------->" + dbType);
                String javaType = Column.sqlType2JavaType(dbType);
                Column column = new Column();
                column.setName(colName);
                column.setRemark(remarks);
                column.setType(javaType);
                columns.add(column);
            }
            tables.get(i).setColumns(columns);

            genEntity.genEntity(tables.get(i));
            genMapper.genMapper(tables.get(i));
            //genDomainService.genDomainService(tables.get(i));
        }

    }


    @Autowired
    IGenEntity genEntity;
    @Autowired
    IGenMapper genMapper;
//    @Autowired
//    IGenDomainService genDomainService;
}
