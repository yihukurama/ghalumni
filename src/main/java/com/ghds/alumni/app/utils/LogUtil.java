package com.ghds.alumni.app.utils;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.component.ScheduledTools;
import com.ghds.alumni.app.component.SpringBeanTools;
import com.ghds.alumni.app.exception.TipsException;
import com.ghds.alumni.domain.tkmapper.entity.admin.SystemlogEntity;
import com.ghds.alumni.service.domainservice.admin.SystemlogService;
import com.ghds.alumni.web.dto.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Jieyq
 * @date 2017年6月27日 下午2:27:01
 */
public class LogUtil {

    public static void DebugLog(Object o, String msg) {
        Logger logger = LoggerFactory.getLogger(o.getClass());
        logger.debug(msg);
    }

    public static void InfoLog(Object o, String msg) {
        Logger logger = LoggerFactory.getLogger(o.getClass());
        logger.info(msg);
    }

    public static void ErrorLog(Object o, String msg) {
        Logger logger = LoggerFactory.getLogger(o.getClass());
        logger.error(msg);
    }

    public static void ErrorLog(Object o, String msg, Request request){

    	String errorMsg = "";
    	if(request != null){
    		errorMsg = "SystemLog.id = " + request.getLogId() + "\n" + msg;
		}else {
    		errorMsg = msg;
		}
    	ErrorLog(o, errorMsg);
	}

	/**
     * 说明： 把返回记录写入log表
     * @author dengshuai
     * @date Created in 10:17 2018/4/16
     * @modified by autor in 10:17 2018/4/16
     */
	public static void writeAdminSystemLogResult(Request dtoRequest, Object result){
		//新建线程写入，不影响业务
		if(dtoRequest == null){
			LogUtil.ErrorLog(LogUtil.class,"写入返回值时无法获取正确参数");
			return;
		}
		ScheduledTools scheduledTools = (ScheduledTools) SpringBeanTools.getBean(ScheduledTools.class);
		Runnable run = () -> {
			SystemlogEntity systemLogEntity = new SystemlogEntity();
			systemLogEntity.setId(dtoRequest.getLogId());
			systemLogEntity.setResult(JSON.toJSONString(result));
			try {
				SystemlogService systemlogService = (SystemlogService) SpringBeanTools.getBean(SystemlogService.class);
				systemlogService.update(systemLogEntity);
			} catch (TipsException e) {
				InfoLog(LogUtil.class,"系统日志id"+dtoRequest.getLogId()+"写入系统日志时失败");
			}
		};
		scheduledTools.runTaskWithDelaySecond(run,0);
	}

    /**
     * 说明： 把请求记录写入系统log表
     * @author dengshuai
     * @date Created in 10:16 2018/4/16
     * @modified by autor in 10:16 2018/4/16
     */
	public static void writeAdminSystemLogRequest(HttpServletRequest request,Request dtoRequest){
		if(request == null){
			return;
		}
		//获取IP地址
		String ip= getIpAddr(request);
		//获取请求链接
		String url = "";
		if(request!=null && request.getRequestURL() != null){
			url = request.getRequestURL().toString();//request.getRequestURI();
		}
		SystemlogEntity systemLogEntity = new SystemlogEntity();
		//转换参数到json字符串
		String jsonStr="null";

		jsonStr=JSON.toJSONString(dtoRequest);
		systemLogEntity.setUserId(dtoRequest.getUid());
		systemLogEntity.setContent(jsonStr);
		systemLogEntity.setUrl(url);
		systemLogEntity.setRequestIP(ip);
		try {
			SystemlogService systemlogService = (SystemlogService) SpringBeanTools.getBean(SystemlogService.class);
			systemlogService.create(systemLogEntity);
			dtoRequest.setLogId(systemLogEntity.getId());
		} catch (TipsException e) {
			LogUtil.InfoLog(LogUtil.class,"插入系统日志记录失败");
		}

	}

    /**
     * 功能描述:获取IP地址
     *
     * @param request
     * @return
     * @Author:Jieyq
     * @Date:2016年10月14日 下午3:21:16
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        //地址过长截取前100位
        if (ipAddress != null && ipAddress.length() > 100) {
            ipAddress = ipAddress.substring(0, 100);
        }
        return ipAddress;
    }

}
