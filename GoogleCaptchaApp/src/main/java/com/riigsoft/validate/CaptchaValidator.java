package com.riigsoft.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.riigsoft.model.CaptchaResponse;
/**
 * @author Abdallah Mahmoud
 * */
@Component
public class CaptchaValidator {

	@Autowired
	private RestTemplate rt;
	
	@Value("${google.recaptcha.url}")
	private String url;
	
	@Value("${google.recaptcha.url2}")
	private String url2;
	
	public boolean isValid(String captcha) {
		CaptchaResponse resp = rt.postForObject(url + captcha, null, CaptchaResponse.class);		
		return resp.isSuccess();
	}
	
	public boolean isValid2(String captcha) {
		CaptchaResponse resp = rt.postForObject(url2 + captcha, null, CaptchaResponse.class);		
		return resp.isSuccess();
	}
}

