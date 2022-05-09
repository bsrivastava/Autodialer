package com.autodialer.authService.utils;





import java.io.UnsupportedEncodingException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.autodialer.authService.model.LoggedInUserDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserUtils {

	public com.autodialer.authService.model.LoggedInUserDetail getLoggedInUser() {
		LoggedInUserDetail userDetail = getUserDetailFromToken();

		return userDetail;
	}

	private LoggedInUserDetail getUserDetailFromToken() {
		String authtoken = getJwtToken();
		String[] token = authtoken.split("\\.");
		byte[] bytePayload = Base64.decodeBase64(token[1]);
		String payload = null;
		try {
			payload = new String(bytePayload, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("Not able to decode JWT payload. Error: {}", e);
			throw new RuntimeException();
		}
		JSONObject json = new JSONObject(payload);
		LoggedInUserDetail userDetail = new LoggedInUserDetail();
		if (!json.isNull("sub")) {
			userDetail.setUserName(json.getString("sub"));
		}
		return userDetail;
     }

	@Bean
	  public RequestContextListener requestContextListener() {
	    return new RequestContextListener();
	  }
	private String getJwtToken() {
		final HttpServletRequest request = getRequest();
		final String authorizationHeaderValue = request.getHeader("Authorization");
		final String base64AuthorizationHeader = Optional.ofNullable(authorizationHeaderValue)
				.map(headerValue -> headerValue.substring("Bearer ".length())).orElse("");

		if (StringUtils.isNotEmpty(base64AuthorizationHeader)) {
			return base64AuthorizationHeader;
		}
		return StringUtils.EMPTY;
	}

	private HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
}
