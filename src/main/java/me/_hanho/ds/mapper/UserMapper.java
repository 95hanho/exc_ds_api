package me._hanho.ds.mapper;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.Token;
import me._hanho.ds.model.User;

@Mapper
public interface UserMapper {

	User getUser(User user);
	User getUser2(String id);
	User getUser3(Token token);
	
	Token getToken(Token token);

	int insertToken(Token token);

	int get_token_num(Token token);
	
	int updateToken(Token token);
	


}
