package com.ghds.alumni.app.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint("/websocket")
@Component
public class YstWebSocket extends BaseWebSocket{
	private final static Logger logger = LoggerFactory.getLogger(YstWebSocket.class);
	private String key;

	@OnOpen
	@Override
	public void onOpen(Session session) {
		super.onOpen(session);
		this.key = session.getQueryString();

		logger.debug("onOpen key:{}",key);

		if(key == null) {
			logger.info("该连接无id");
			return;
		}

	}

	@OnClose
	@Override
	public void onClose() {
		logger.debug("onClose key:{}",key);

		super.onClose();
	}

	@OnMessage
	@Override
	public void onMessage(String message, Session session) throws IOException {
		
			
			broadcast(message);
		
	}

	// 向所有连接上来的socket广播消息
	public static void broadcast(String message) {

	}

	// 向指定的socket发送消息
	public static void sendMsgByUserId(String message, String key) {

	}
	
	/**
	 * 功能描述:通知用户跟进
	 * @param id 用户id
	 * @param data 事故单Accorder,案件Cases,鉴定单Apporder
	 * @param cmd 各种socket命令
	 * @Author:dengshuai
	 * @Date:2017年2月9日 上午11:23:03
	 */
	public static void notifyUser(String id,Object data,String cmd){

	}

	/**
	 * 功能描述:广播通知
	 * @param id  数据id
	 * @param data  数据
	 * @param cmd  各种socket命令
	 * @Author:dengshuai
	 * @Date:2017年2月14日 下午3:58:57
	 */
	public static void broadcast(String id,Object data,String cmd){

	}
	
	
	

}