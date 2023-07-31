package com.bptn.weatherapp.automation.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.bptn.weatherapp.automation.provider.factory.YamlPropertySourceFactory;

@Component
@PropertySource(value = "classpath:config.yml", factory = YamlPropertySourceFactory.class)
public class ResourceProvider { 

			
	@Value("${test.url.backend}")
	private String backEndUrl;

	@Value("${test.url.frontend}")
	private String frontEndUrl;

	@Value("${test.browser}")
	private String browser;

	@Value("${test.default.timeout}")
	private String timeout;

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration;

	@Value("${jwt.issuer}")
	private String jwtIssuer;
	
	@Value("${jwt.audience}")
	private String jwtAudience;

	@Value("${jwt.prefix}")
	private String jwtPrefix;
	
	@Value("${spring.jackson.time-zone}")
	private String timeZone;

	@Value("${spring.jackson.date-format}")
	private String dateFormat;
	
	public String getBackEndUrl() {
		return backEndUrl;
	}

	public String getFrontEndUrl() {
		return frontEndUrl;
	}

	public String getBrowser() {
		return browser;
	}

	public String getTimeout() {
		return timeout;
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public long getJwtExpiration() {
		return jwtExpiration;
	}

	public String getJwtIssuer() {
		return jwtIssuer;
	}

	public String getJwtAudience() {
		return jwtAudience;
	}
	
	public String getJwtPrefix() {
		return jwtPrefix;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public String getDateFormat() {
		return dateFormat;
	}
	
}
