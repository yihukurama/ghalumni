package com.ghds.alumni.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "ysturlconfig")
@Configuration
public class UrlConfig {


	private String urlStaticPic;

	public String getUrlStaticPic() {
		return urlStaticPic;
	}

	public void setUrlStaticPic(String urlStaticPic) {
		this.urlStaticPic = urlStaticPic;
	}
}
