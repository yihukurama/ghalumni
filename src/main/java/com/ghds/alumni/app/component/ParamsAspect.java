package com.ghds.alumni.app.component;

import com.alibaba.fastjson.JSON;
import com.ghds.alumni.app.cache.RedisUtils;
import com.ghds.alumni.app.constant.Constant;
import com.ghds.alumni.app.constant.ResponseEnum;
import com.ghds.alumni.app.utils.LogUtil;
import com.ghds.alumni.domain.admin.User;
import com.ghds.alumni.domain.tkmapper.entity.admin.UserEntity;
import com.ghds.alumni.domain.tkmapper.mapper.admin.UserMapper;
import com.ghds.alumni.web.dto.Request;
import com.ghds.alumni.web.dto.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * 功能描述:事务拦截器
 *
 * @Author:liujun
 * @Date:2016年12月16日 上午9:54:44
 */
@Aspect
@Component
public class ParamsAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParamsAspect.class);
	String methodName;

	@Autowired
	RedisUtils redisUtils;


	/**
	 * 功能描述:开启事务;
	 *
	 * @param joinPoint
	 *            连接点
	 * @Author:liujun
	 * @Date:2016年12月16日 上午10:08:38
	 */

	@Before("execution (com.ghds.alumni.web.dto.Result com..web..*(..)) ")
	public void before(JoinPoint joinPoint) {
		try {
			methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

			System.out.println(methodName + "方法开始");

			Object[] args = joinPoint.getArgs();
			StringBuilder sb = new StringBuilder();
			if (args != null || args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					Object arg = args[i];
					if (arg instanceof Integer || arg instanceof String || arg instanceof Boolean) {
						sb.append(arg);
						if (i != args.length - 1) {
							sb.append(",");
						}
					} else if (arg instanceof List || arg instanceof Request) {
						sb.append(JSON.toJSONString(arg));
						if (i != args.length - 1) {
							sb.append(",");
						}
					}
				}
			}

			LOGGER.debug("methodName:{} params:{} ", methodName, sb.toString());
		} catch (Exception e) {
			LOGGER.error("controller aop before error:{}", e);
		}

	}

    @Around("execution (* com..web..*(..)) ")
	public Object around(ProceedingJoinPoint pjp) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest hsRequest = sra.getRequest();
		String url = hsRequest.getRequestURL().toString();

		Boolean isGetMethod = "GET".equals(hsRequest.getMethod());

		LOGGER.debug("当前请求的URL是:{}", url);
        Request request = null;
		String simpleMethodName = pjp.getSignature().getName();
		Object[] os = pjp.getArgs();
		for (int i = 0; i < os.length; i++) {
			if (os[i] instanceof Request) {
				request = (Request) os[i];
				LogUtil.writeAdminSystemLogRequest(hsRequest, request);
				if (request == null) {
				    LogUtil.writeAdminSystemLogResult(request, Result.failed("请求参数request不能为空"));
					return Result.failed("请求参数request不能为空");
				}
				if (request.getUid() == null) {
					LogUtil.writeAdminSystemLogResult(request, Result.failed(JSON.toJSONString(request),"请求参数中没有uid!收到的请求是>>>>>"+JSON.toJSONString(request)));
					return Result.failed(JSON.toJSONString(request),"请求参数中没有uid!收到的请求是>>>>>"+JSON.toJSONString(request));
				}

				// 判断用户是否登录
				if (!Constant.AUTHORID.contains(request.getUid()) && !url.contains("/public/") && !redisUtils.exists(request.getUid()+Constant.encryptKey)) {
				    LOGGER.debug("获得的请求数据是>>>>>>",JSON.toJSONString(request));
				    LogUtil.writeAdminSystemLogResult(request, Result.failed(Constant.encryptKey,ResponseEnum.ERROR_CODE_4003.getCode()));
					return Result.failed(Constant.encryptKey, ResponseEnum.ERROR_CODE_4003.getCode());
				}else{
					//更新缓存
					if (redisUtils.exists(request.getUid()+Constant.encryptKey)) {
						String token = (String) redisUtils.get(request.getUid()+Constant.encryptKey);
						redisUtils.set(request.getUid()+Constant.encryptKey, token, Constant.LOGIN_EXPIRETIME);
						LOGGER.debug("更新登录状态...延长{}",Constant.LOGIN_EXPIRETIME);
					}
				}

				if (simpleMethodName.startsWith("list")) {
					if (request.getPage() == null || request.getPage() < 0) {
						LogUtil.writeAdminSystemLogResult(request, Result.failed("非法的page参数"));
						return Result.failed("非法的page参数");
					}
				}

				if (request.getPage() != null && request.getPage() > 0 && request.getLimit() != null
						&& request.getLimit() <= 0) {
					LogUtil.writeAdminSystemLogResult(request, Result.failed("page参数大于0时,limit参数必须大于0"));
					return Result.failed("page参数大于0时,limit参数必须大于0");
				}

				break;
			}
		}

		Object object = null;
		String tips = "";
		try {
			object = pjp.proceed();

		} catch (Throwable e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				tips = "请检查路径是否合法!";
			}

			if (e != null && e.getMessage() != null && !e.getMessage().equals("")) {
				tips += e.getMessage();
				LogUtil.ErrorLog(this, tips, request);
			} else {
				tips += "后台异常信息为:" + sw.toString();
				LogUtil.ErrorLog(this, tips, request);
			}
			if(!isGetMethod) {
				LogUtil.writeAdminSystemLogResult(request, Result.failed(tips));
			}
			return Result.failed(tips);
		}

        if(!isGetMethod) {
			LogUtil.writeAdminSystemLogResult(request, object);
		}

		return object;
	}

	/**
	 * 功能描述:提交事务;
	 *
	 * @Author:liujun
	 * @Date:2016年12月16日 上午10:09:10
	 */
	@AfterReturning("execution (com.ghds.alumni.web.dto.Result com..web..*(..))  ")
	public void afterReturning() {

		LOGGER.info(methodName + "方法结束");
	}

}
