package me._hanho.ds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//			.allowedOrigins("*");
			.allowedOrigins("http://localhost:5173/", "http://localhost:5174/", "https://95hanho.pe.kr/") // 클라이언트 도메인 명시
			.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 메서드 명시
//		 	.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 메서드 명시
//	        .allowedHeaders("*") // 허용할 헤더
	        .allowCredentials(true) // 인증 정보(쿠키) 허용 여부
	        .maxAge(3600); // preflight 요청 캐싱 시간 (초 단위)
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
			.addPathPatterns("/**");
	}
}
