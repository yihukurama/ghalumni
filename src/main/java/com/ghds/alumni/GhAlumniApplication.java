package com.ghds.alumni;

import com.ghds.alumni.app.component.SpringBeanTools;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 说明：
 *
 * @author dengshuai
 * @date Created in 14:45 2018/4/10
 * @modified by autor in 14:45 2018/4/10
 */
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.ghds.alumni.domain.tkmapper.mapper")
@SpringBootApplication
@EnableFeignClients
public class GhAlumniApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GhAlumniApplication.class);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(GhAlumniApplication.class).web(true).run(args);
        SpringBeanTools.setApplicationContext1(context);
    }
}
