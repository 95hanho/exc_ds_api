package me._hanho.ds.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me._hanho.ds.service.TokenService;

@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

	@Autowired
	private TokenService tokenService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authorizationHeader = request.getHeader("Authorization");
		String access_token = null;
		 
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			access_token = authorizationHeader.substring(7); // "Bearer " 이후의 문자열만 추출
	    }
		
		
		if (access_token != null && !access_token.isEmpty()) {
            try {
                // JWT 파싱 및 복호화
                Claims claims = tokenService.parseJwtToken(access_token);

                // login_id 추출
                String loginId = claims.get("login_id", String.class);

                // HttpServletRequest에 login_id 추가
                request.setAttribute("login_id", loginId);
            } catch (Exception e) {
                // 토큰이 유효하지 않으면 요청을 거부
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                logger.error("token UNAUTHORIZED");
                return false;
            }
        }

        return true;
	}
}
