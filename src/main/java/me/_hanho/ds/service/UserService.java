package me._hanho.ds.service;

import me._hanho.ds.model.Token;
import me._hanho.ds.model.User;

public interface UserService {

	// 유저 가져오기
	User getUser(User user);
	User getUser(String id);
	User getUser(Token token);
	
	Token getToken(Token token);
	int insertToken(Token token);
	int updateToken(Token token);
	

}
