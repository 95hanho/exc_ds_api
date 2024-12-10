package me._hanho.ds.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.UserMapper;
import me._hanho.ds.model.Token;
import me._hanho.ds.model.User;

@Repository
public class UserRepository {
	
	@Autowired
	private UserMapper userMapper;

	public User getUser(User user) {
		return userMapper.getUser(user);
	}
	public User getUser(String id) {
		return userMapper.getUser2(id);
	}
	public User getUser(Token token) {
		return userMapper.getUser3(token);
	}
	
	public Token getToken(Token token) {
		return userMapper.getToken(token);
	}
	public int insertToken(Token token) {
		return userMapper.insertToken(token);
	}
	public int updateToken(Token token) {
		int token_num = userMapper.get_token_num(token);
		token.setToken_num(token_num);
		return userMapper.updateToken(token);
	}

}
