package me._hanho.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Token;
import me._hanho.ds.model.User;
import me._hanho.ds.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDAO;
	
	@Override
	public User getUser(User user) {
		return userDAO.getUser(user);
	}
	@Override
	public User getUser(String id) {
		return userDAO.getUser(id);
	}
	@Override
	public User getUser(Token token) {
		return userDAO.getUser(token);
	}

	@Override
	public int createToken(Token token) {
		return userDAO.createToken(token);
	}





}
